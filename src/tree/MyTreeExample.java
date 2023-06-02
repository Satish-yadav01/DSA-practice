package tree;

public class MyTreeExample {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        MyTree.Node root = tree.createTree();
        System.out.println(root.data);
        tree.inOrder(root);
        System.out.println();
        tree.preOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrder(root);
        System.out.println("Count : " + tree.count(root));
        System.out.println("sum : " + tree.sum(root));
        System.out.println("height : " + tree.height(root));
    }
}
