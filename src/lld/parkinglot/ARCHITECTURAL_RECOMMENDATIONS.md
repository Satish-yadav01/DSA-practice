# Parking Lot LLD - Architectural Recommendations

## Overview
This document provides detailed architectural recommendations for improving the Parking Lot system design to better adhere to SOLID principles and design patterns.

---

## 1. RECOMMENDED REFACTORING: Service Layer Architecture

### Current Architecture Issues
- Business logic is scattered across model classes
- Admin class has too many responsibilities
- Entrance class handles multiple concerns
- No clear separation of concerns

### Proposed Service Layer

```
┌─────────────────────────────────────────────────────────┐
│                    Presentation Layer                    │
│                    (Driver/Controller)                   │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                    Service Layer                         │
│  ┌──────────────────────────────────────────────────┐   │
│  │ • ParkingService (Orchestrator)                  │   │
│  │ • SpotFinderService                              │   │
│  │ • TicketService                                  │   │
│  │ • PaymentService                                 │   │
│  │ • VehicleService                                 │   │
│  └──────────────────────────────────────────────────┘   │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                    Manager Layer                         │
│  ┌──────────────────────────────────────────────────┐   │
│  │ • FloorManager                                   │   │
│  │ • ParkingSpotManager                             │   │
│  │ • TicketManager                                  │   │
│  └──────────────────────────────────────────────────┘   │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                    Model Layer                           │
│  ┌──────────────────────────────────────────────────┐   │
│  │ • Floor, ParkingSpot, Vehicle, Ticket            │   │
│  │ • Admin, Entrance                                │   │
│  └──────────────────────────────────────────────────┘   │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                    Repository Layer                      │
│  ┌──────────────────────────────────────────────────┐   │
│  │ • TicketRepository                               │   │
│  │ • VehicleRepository                              │   │
│  │ • ParkingSpotRepository                          │   │
│  └──────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────┘
```

---

## 2. PROPOSED SERVICE IMPLEMENTATIONS

### 2.1 ParkingService (Main Orchestrator)

```java
public interface ParkingService {
    Ticket parkVehicle(Vehicle vehicle, int floorNumber) throws ParkingException;
    void unparkVehicle(Ticket ticket) throws ParkingException;
    int findAvailableSpot(VehicleType vehicleType) throws ParkingException;
    double calculateParkingCost(Ticket ticket, CostComputation strategy);
    List<Floor> getAllFloors();
}

public class ParkingServiceImpl implements ParkingService {
    private final SpotFinderService spotFinderService;
    private final TicketService ticketService;
    private final ParkingSpotManager spotManager;
    private final Admin admin;
    
    // Implementation
}
```

### 2.2 SpotFinderService

```java
public interface SpotFinderService {
    int findAvailableSpot(VehicleType vehicleType) throws ParkingException;
    int findAvailableSpotOnFloor(VehicleType vehicleType, int floorNumber) throws ParkingException;
    List<Integer> findAllAvailableSpots(VehicleType vehicleType);
}

public class SpotFinderServiceImpl implements SpotFinderService {
    private final Admin admin;
    
    @Override
    public int findAvailableSpot(VehicleType vehicleType) throws ParkingException {
        for (Floor floor : admin.getFloors()) {
            if (floor.isParkingSpotAvailable(vehicleType) && 
                !floor.isParkingSpotOccupied(vehicleType)) {
                return floor.getFloorNumber();
            }
        }
        throw new ParkingException("No available spots for " + vehicleType);
    }
}
```

### 2.3 TicketService

```java
public interface TicketService {
    Ticket generateTicket(Vehicle vehicle, int spotId, CostComputation strategy);
    void processCheckout(Ticket ticket, CostComputation strategy);
    double calculateCost(Ticket ticket, CostComputation strategy);
}

public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final AtomicLong ticketIdGenerator = new AtomicLong(1);
    
    @Override
    public Ticket generateTicket(Vehicle vehicle, int spotId, CostComputation strategy) {
        double cost = strategy.calculateCostForTicket(vehicle.getVehicleType());
        Ticket ticket = new Ticket(
            (int)ticketIdGenerator.getAndIncrement(),
            spotId,
            LocalDateTime.now(),
            vehicle,
            cost
        );
        ticketRepository.save(ticket);
        return ticket;
    }
}
```

### 2.4 PaymentService

```java
public interface PaymentService {
    PaymentResult processPayment(Ticket ticket, PaymentMethod method);
    double calculateFinalCost(Ticket ticket, CostComputation strategy);
}

public class PaymentServiceImpl implements PaymentService {
    private final PaymentGateway paymentGateway;
    
    @Override
    public PaymentResult processPayment(Ticket ticket, PaymentMethod method) {
        double amount = ticket.getPrice();
        return paymentGateway.charge(amount, method);
    }
}
```

---

## 3. PROPOSED MANAGER LAYER

### 3.1 ParkingSpotManager

```java
public interface ParkingSpotManager {
    void addSpot(ParkingSpot spot, VehicleType type, int floorNumber);
    void removeSpot(ParkingSpot spot, VehicleType type, int floorNumber);
    void occupySpot(int spotId, VehicleType type, int floorNumber);
    void vacateSpot(int spotId, VehicleType type, int floorNumber);
    boolean isSpotAvailable(int spotId, VehicleType type, int floorNumber);
}

public class ParkingSpotManagerImpl implements ParkingSpotManager {
    private final Map<Integer, Floor> floorMap;
    
    @Override
    public synchronized void occupySpot(int spotId, VehicleType type, int floorNumber) {
        Floor floor = floorMap.get(floorNumber);
        if (floor != null) {
            floor.occupyParkingSpot(type, spotId);
        }
    }
}
```

### 3.2 FloorManager

```java
public interface FloorManager {
    void addFloor(Floor floor);
    void removeFloor(int floorNumber);
    Floor getFloor(int floorNumber);
    List<Floor> getAllFloors();
    int getAvailableCapacity(int floorNumber);
}

public class FloorManagerImpl implements FloorManager {
    private final Map<Integer, Floor> floors = new ConcurrentHashMap<>();
    
    @Override
    public synchronized void addFloor(Floor floor) {
        floors.put(floor.getFloorNumber(), floor);
    }
}
```

---

## 4. PROPOSED REPOSITORY LAYER

### 4.1 TicketRepository

```java
public interface TicketRepository {
    void save(Ticket ticket);
    Ticket findById(int ticketId);
    List<Ticket> findByVehicleNo(String vehicleNo);
    List<Ticket> findByDateRange(LocalDateTime start, LocalDateTime end);
    void update(Ticket ticket);
    void delete(int ticketId);
}

public class InMemoryTicketRepository implements TicketRepository {
    private final Map<Integer, Ticket> tickets = new ConcurrentHashMap<>();
    
    @Override
    public void save(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }
}
```

### 4.2 VehicleRepository

```java
public interface VehicleRepository {
    void save(Vehicle vehicle);
    Vehicle findByVehicleNo(String vehicleNo);
    List<Vehicle> findAll();
    void update(Vehicle vehicle);
    void delete(String vehicleNo);
}
```

---

## 5. PROPOSED EVENT SYSTEM

### 5.1 Event Architecture

```java
public abstract class ParkingEvent {
    private final LocalDateTime timestamp;
    private final String eventType;
    
    public ParkingEvent(String eventType) {
        this.eventType = eventType;
        this.timestamp = LocalDateTime.now();
    }
}

public class SpotAvailableEvent extends ParkingEvent {
    private final int spotId;
    private final VehicleType vehicleType;
    
    public SpotAvailableEvent(int spotId, VehicleType vehicleType) {
        super("SPOT_AVAILABLE");
        this.spotId = spotId;
        this.vehicleType = vehicleType;
    }
}

public class ParkingFullEvent extends ParkingEvent {
    private final int floorNumber;
    
    public ParkingFullEvent(int floorNumber) {
        super("PARKING_FULL");
        this.floorNumber = floorNumber;
    }
}

public interface EventListener {
    void onEvent(ParkingEvent event);
}

public class EventPublisher {
    private final List<EventListener> listeners = new CopyOnWriteArrayList<>();
    
    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }
    
    public void publish(ParkingEvent event) {
        listeners.forEach(listener -> listener.onEvent(event));
    }
}
```

---

## 6. IMPROVED DEPENDENCY INJECTION

### 6.1 Using Constructor Injection

```java
public class ParkingServiceImpl implements ParkingService {
    private final SpotFinderService spotFinderService;
    private final TicketService ticketService;
    private final ParkingSpotManager spotManager;
    private final EventPublisher eventPublisher;
    
    // Constructor injection - no singletons needed
    public ParkingServiceImpl(
        SpotFinderService spotFinderService,
        TicketService ticketService,
        ParkingSpotManager spotManager,
        EventPublisher eventPublisher) {
        this.spotFinderService = spotFinderService;
        this.ticketService = ticketService;
        this.spotManager = spotManager;
        this.eventPublisher = eventPublisher;
    }
}
```

### 6.2 Factory for Dependency Creation

```java
public class ParkingSystemFactory {
    public static ParkingService createParkingService(List<Floor> floors) {
        Admin admin = new Admin(floors);
        SpotFinderService spotFinder = new SpotFinderServiceImpl(admin);
        TicketRepository ticketRepo = new InMemoryTicketRepository();
        TicketService ticketService = new TicketServiceImpl(ticketRepo);
        ParkingSpotManager spotManager = new ParkingSpotManagerImpl(floors);
        EventPublisher eventPublisher = new EventPublisher();
        
        return new ParkingServiceImpl(
            spotFinder,
            ticketService,
            spotManager,
            eventPublisher
        );
    }
}
```

---

## 7. IMPROVED EXCEPTION HANDLING

### 7.1 Custom Exception Hierarchy

```java
public abstract class ParkingException extends RuntimeException {
    public ParkingException(String message) {
        super(message);
    }
}

public class NoAvailableSpotException extends ParkingException {
    public NoAvailableSpotException(VehicleType type) {
        super("No available spots for " + type);
    }
}

public class InvalidVehicleTypeException extends ParkingException {
    public InvalidVehicleTypeException(String type) {
        super("Invalid vehicle type: " + type);
    }
}

public class InsufficientCapacityException extends ParkingException {
    public InsufficientCapacityException(int floorNumber) {
        super("Insufficient capacity on floor " + floorNumber);
    }
}

public class PaymentFailedException extends ParkingException {
    public PaymentFailedException(String reason) {
        super("Payment failed: " + reason);
    }
}
```

---

## 8. IMPROVED CONFIGURATION MANAGEMENT

### 8.1 Configuration Class

```java
public class ParkingLotConfiguration {
    private final int totalFloors;
    private final int capacityPerFloor;
    private final Map<VehicleType, Integer> spotPrices;
    private final CostComputation defaultCostStrategy;
    
    public ParkingLotConfiguration(
        int totalFloors,
        int capacityPerFloor,
        Map<VehicleType, Integer> spotPrices,
        CostComputation defaultCostStrategy) {
        this.totalFloors = totalFloors;
        this.capacityPerFloor = capacityPerFloor;
        this.spotPrices = spotPrices;
        this.defaultCostStrategy = defaultCostStrategy;
    }
}
```

---

## 9. IMPROVED LOGGING & MONITORING

### 9.1 Logging Strategy

```java
public class ParkingLogger {
    private static final Logger logger = LoggerFactory.getLogger(ParkingLogger.class);
    
    public static void logVehicleEntry(Vehicle vehicle, int spotId) {
        logger.info("Vehicle {} parked at spot {}", vehicle.getVehicleNo(), spotId);
    }
    
    public static void logVehicleExit(Vehicle vehicle, double cost) {
        logger.info("Vehicle {} exited. Cost: {}", vehicle.getVehicleNo(), cost);
    }
    
    public static void logError(String message, Exception e) {
        logger.error(message, e);
    }
}
```

### 9.2 Metrics Collection

```java
public class ParkingMetrics {
    private final AtomicInteger totalVehiclesParked = new AtomicInteger(0);
    private final AtomicInteger totalRevenue = new AtomicInteger(0);
    private final AtomicInteger currentlyParked = new AtomicInteger(0);
    
    public void recordParking() {
        totalVehiclesParked.incrementAndGet();
        currentlyParked.incrementAndGet();
    }
    
    public void recordExit(double cost) {
        currentlyParked.decrementAndGet();
        totalRevenue.addAndGet((int)cost);
    }
    
    public void printMetrics() {
        System.out.println("Total Vehicles Parked: " + totalVehiclesParked.get());
        System.out.println("Currently Parked: " + currentlyParked.get());
        System.out.println("Total Revenue: " + totalRevenue.get());
    }
}
```

---

## 10. TESTING STRATEGY

### 10.1 Unit Test Structure

```java
public class ParkingServiceTest {
    private ParkingService parkingService;
    private SpotFinderService spotFinderService;
    private TicketService ticketService;
    
    @Before
    public void setUp() {
        spotFinderService = mock(SpotFinderService.class);
        ticketService = mock(TicketService.class);
        parkingService = new ParkingServiceImpl(spotFinderService, ticketService, ...);
    }
    
    @Test
    public void testParkVehicleSuccess() {
        // Test successful parking
    }
    
    @Test
    public void testParkVehicleNoSpots() {
        // Test when no spots available
    }
}
```

### 10.2 Integration Test Structure

```java
public class ParkingSystemIntegrationTest {
    private ParkingService parkingService;
    
    @Before
    public void setUp() {
        List<Floor> floors = createTestFloors();
        parkingService = ParkingSystemFactory.createParkingService(floors);
    }
    
    @Test
    public void testCompleteParking Flow() {
        // Test entry -> booking -> exit flow
    }
}
```

---

## 11. MIGRATION PLAN

### Phase 1: Create Service Layer (Week 1)
- Create all service interfaces
- Implement basic services
- Add unit tests

### Phase 2: Create Manager Layer (Week 2)
- Create manager interfaces
- Implement managers
- Refactor existing code to use managers

### Phase 3: Create Repository Layer (Week 3)
- Create repository interfaces
- Implement in-memory repositories
- Add data persistence

### Phase 4: Add Event System (Week 4)
- Implement event classes
- Add event listeners
- Integrate with services

### Phase 5: Improve DI & Configuration (Week 5)
- Remove singletons
- Implement factory pattern
- Add configuration management

### Phase 6: Testing & Documentation (Week 6)
- Add comprehensive tests
- Update documentation
- Performance optimization

---

## 12. CONCLUSION

The proposed architecture provides:
- ✅ Better separation of concerns
- ✅ Improved testability
- ✅ Better SOLID compliance
- ✅ Scalability for future features
- ✅ Easier maintenance and debugging
- ✅ Event-driven capabilities
- ✅ Proper dependency injection

This refactoring will transform the parking lot system from a monolithic design to a well-structured, maintainable, and scalable system.

