package populating_next_right_pointer_in_each_node_117;

import common.Node;

/**
 * Created by Ahmed Al-Aishat on Jul/22/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        var node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.right = new Node(7);
        node.left.right = new Node(5);
        node.left.left = new Node(4);
        System.out.println(new Solution().connect(node));
    }


    public Node connect(Node root) {
        connectChildren(root);
        return root;
    }

    public void connectChildren(Node node) {
        if (node == null || (node.left == null && node.right == null)) return;
        Node childNext = null;
        Node parentNext = node.next;
        while (parentNext != null && childNext == null) {
            if (parentNext.left != null) childNext = parentNext.left;
            else if (parentNext.right != null) childNext = parentNext.right;
            parentNext = parentNext.next;
        }
        if (node.left == null) {
            node.right.next = childNext;
            connectChildren(node.right);
        } else if (node.right == null) {
            node.left.next = childNext;
            connectChildren(node.left);
        } else {
            node.left.next = node.right;
            node.right.next = childNext;
            connectChildren(node.right);
            connectChildren(node.left);
        }
    }
}
