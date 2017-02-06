package cn.fql.coderush.structure;

import java.util.Stack;

/**
 * Created by fuquanlin on 2016/11/18.
 */
public class TreeScan {


    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, node1);
        Node node3 = new Node(3, null, null);
        Node node4 = new Node(4, node2, node3);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, null, node5);
        Node node7 = new Node(7, null, null);
        Node node8 = new Node(8, node7, node6);
        Node node9 = new Node(9, node4, node8);
        travel(node9);
        System.out.println("loop");
        travel2(node9);
    }

    public static void travel(Node root) {
        if (root != null) {
            travel(root.getLeft());
            System.out.println(root.getData());
            travel(root.getRight());
        }
    }

    public static void travel2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                System.out.println(current.getData());
                current = current.getRight();
            }
        }
    }

}
