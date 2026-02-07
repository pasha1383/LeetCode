// 654
import java.util.ArrayList;
import java.util.List;

public class MaximumBinaryTree {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createBinaryTree(nums,0, nums.length-1);
    }

    private TreeNode createBinaryTree(int[] nums,int left, int right) {
        if (left > right ) {
            return null;
        }

        int index = findMaxIndex(nums,left,right);
        var node = new TreeNode(nums[index]);
        nodes.add(node);
        node.right = createBinaryTree(nums, index + 1, right);
        node.left = createBinaryTree(nums, left, index - 1);
        return node;
    }

    private int findMaxIndex(int[] nums,int left, int right) {
        int max = nums[left];
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        return maxIndex;
    }

}
