package dsalgo.datastructure.tree.newTree;

/**
 * @author satish yadav
 * @apiNote This is the first method to create dsalgo.datastructure.tree where we are passing nodes in arrays itself
 */
public class MyTree2 {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

}
