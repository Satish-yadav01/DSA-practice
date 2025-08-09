import hash.HashFunction1;
import ring.HashRing;
import ring.Node;

public class ConsistentHashingExample {
    public static void main(String[] args) {

        HashRing hashRing = new HashRing(new HashFunction1());

        // Add nodes
        hashRing.addNode(new Node("NodeA"));
        hashRing.addNode(new Node("NodeB"));
        hashRing.addNode(new Node("NodeC"));

        // Test key distribution
        System.out.println("Key1 is assigned to: " + hashRing.getNodeForKey("Key1"));
        System.out.println("Key2 is assigned to: " + hashRing.getNodeForKey("Key2"));
        System.out.println("Key3 is assigned to: " + hashRing.getNodeForKey("75440735"));
        System.out.println("Key3 is assigned to: " + hashRing.getNodeForKey("Key3"));
        System.out.println("Key3 is assigned to: " + hashRing.getNodeForKey("754407353"));
        System.out.println("Key3 is assigned to: " + hashRing.getNodeForKey("Key3"));
        System.out.println("Key3 is assigned to: " + hashRing.getNodeForKey("1234567"));
        System.out.println("Key3 is assigned to: " + hashRing.getNodeForKey("75440735ww"));

        // Remove a node
        hashRing.removeNode(new Node("NodeB"));

        // Re-test key distribution
        System.out.println("Key1 is now assigned to: " + hashRing.getNodeForKey("Key1"));
        System.out.println("Key2 is now assigned to: " + hashRing.getNodeForKey("Key2"));
        System.out.println("Key3 is now assigned to: " + hashRing.getNodeForKey("Key3"));


    }
}