package revision.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyTree {

    Node root;
    Scanner sc = new Scanner(System.in);
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

    public Node createTree(){
        Node root = null;
        System.out.println("Enter data : ");
        int data = sc.nextInt();

        if(data == -1 ) return null;

        root = new Node(data);
        System.out.println("left for : " + data);
        root.left = createTree();

        System.out.println("right for : " + data);
        root.right = createTree();

        return root;
    }

    public void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        postOrder(root.left);
        postOrder(root.right);
    }

    public void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curNode = q.remove();
            if(curNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else{
                System.out.print(curNode.data+" ");
                if(curNode.left != null){
                    q.add(curNode.left);
                }
                if(curNode.right != null){
                    q.add(curNode.right);
                }
            }
        }

    }

    public int height(){
        return 0;
    }

    public int count(Node root){
        return 0;
    }

    public int sum(Node root){
        return 0;
    }

}
