package com.ratelimiter.ratelimiter.core;

import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class SlidingWindowAlgorithm extends AbstractAlgorithm{
    private final Queue<Long> requestTimestamps = new ConcurrentLinkedQueue<>();

    public SlidingWindowAlgorithm(int limit, int timePeriod) {
        super(limit, timePeriod);
    }

    @Override
    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        // Remove timestamps outside the time window
        while (!requestTimestamps.isEmpty() && requestTimestamps.peek() < currentTime - timePeriod) {
            requestTimestamps.poll();
        }

        if (requestTimestamps.size() < limit) {
            // Allow request and add current timestamp
            requestTimestamps.add(currentTime);
            return true;
        }
        return false; // Reject request
    }
}
