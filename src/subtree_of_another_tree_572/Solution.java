package subtree_of_another_tree_572;

import common.TreeNode;

/**
 * Created by Ahmed Al-Aishat on Jul/22/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return root != null && (isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    public boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        return root1.val == root2.val && isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
    }

}
