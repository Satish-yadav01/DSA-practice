package revision.tree;

public class MyTreeExample {
    public static void main(String[] args) {
        MyTree tree = new MyTree();

        MyTree.Node root = tree.createTree();
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.preOrder(root);
        System.out.println();
        tree.postOrder(root);

    }
}
