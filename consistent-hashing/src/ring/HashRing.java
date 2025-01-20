package ring;

import hash.HashFunction;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class HashRing {
    private final TreeMap<Integer, Node> ring;
    private final Set<Node> nodes;
    private final HashFunction hashFunction;

    public HashRing(HashFunction hashFunction) {
        this.ring = new TreeMap<>();
        this.nodes = new HashSet<>();
        this.hashFunction = hashFunction;
    }

    public void addNode(Node node) {
        int hash = hashFunction.hash(node.getId());
        ring.put(hash, node);
//        nodes.add(node);
        System.out.println("Added node: " + node.getId() + " with hash: " + hash);
    }

    public void removeNode(Node node) {
        int hash = hashFunction.hash(node.getId());
        ring.remove(hash);
//        nodes.remove(node);
        System.out.println("Removed node: " + node.getId() + " with hash: " + hash);
    }

    public Node getNodeForKey(String key) {
        int hash = hashFunction.hash(key);
        System.out.println("hash for the key ::: " + hash);
        if(ring.containsKey(hash)) {
            return ring.get(hash);
        }

        // Get the next node in the ring (or wrap around)
        Integer ceilingKey = ring.ceilingKey(hash);
        if(ceilingKey == null) {
            ceilingKey =  ring.firstKey();
        }

        return ring.get(ceilingKey);
    }
}
