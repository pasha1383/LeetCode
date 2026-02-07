// 108

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    List<TreeNode> nodes = new ArrayList<>();

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBinaryTree(nums,0, nums.length - 1);
    }

    private TreeNode createBinaryTree(int[] nums, int left, int right) {
        if (left > right ) {
            return null;
        }

        int index = (right + left)/2;
        TreeNode node = new TreeNode(nums[index]);
        nodes.add(node);
        node.left = createBinaryTree(nums, left, index - 1 );
        node.right = createBinaryTree(nums, index + 1, right);
        return node;

    }
}
