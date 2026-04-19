import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root,null,null);
    }

    private boolean validate(TreeNode node , Integer min , Integer max) {
        if (node == null) return true;

        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        return validate(node.left,min, node.val) & validate(node.right, node.val, max);
    }

    private static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // فرزند چپ
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // فرزند راست
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    private static void runTest(String testName, Integer[] arr, boolean expected) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        TreeNode root = buildTree(arr);
        boolean result = vbst.isValidBST(root);

        String status = (result == expected) ? "✅ PASS" : "❌ FAIL";
        System.out.println(testName);
        System.out.println("  Tree: " + Arrays.toString(arr));
        System.out.println("  Expected: " + expected + ", Got: " + result + " " + status);
        System.out.println();
    }

    public static void main(String[] args) {

        // Test 1: BST معتبر ساده
        //     2
        //    / \
        //   1   3
        runTest("Test 1: Valid simple BST",
                new Integer[]{2, 1, 3}, true);

        // Test 2: نامعتبر - root value اشتباه
        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        runTest("Test 2: Invalid - 3 < 5 in right subtree",
                new Integer[]{5, 1, 4, null, null, 3, 6}, false);

        // Test 3: تک node
        runTest("Test 3: Single node",
                new Integer[]{1}, true);

        // Test 4: درخت خالی
        runTest("Test 4: Empty tree",
                new Integer[]{}, true);

        // Test 5: مقادیر مساوی (BST strict هست، مساوی قبول نیست)
        //     1
        //    / \
        //   1
        runTest("Test 5: Duplicate values (should fail)",
                new Integer[]{1, 1}, false);

        // Test 6: Trap معروف - parent-child درسته ولی subtree اشتباه
        //       10
        //      /  \
        //     5    15
        //         /  \
        //        6    20   ← 6 < 10 در subtree راست 10
        runTest("Test 6: Classic trap - deep violation",
                new Integer[]{10, 5, 15, null, null, 6, 20}, false);

        // Test 7: BST بزرگ معتبر
        //        8
        //       / \
        //      3   10
        //     / \    \
        //    1   6    14
        //       / \   /
        //      4   7 13
        runTest("Test 7: Larger valid BST",
                new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13}, true);

        // Test 8: Edge case - Integer.MIN_VALUE
        runTest("Test 8: Integer.MIN_VALUE as root",
                new Integer[]{Integer.MIN_VALUE}, true);

        // Test 9: Edge case - Integer.MAX_VALUE
        //  MAX_VALUE
        //      \
        //    (nothing can be bigger)
        // این معتبره چون فقط یه node داره
        runTest("Test 9: Integer.MAX_VALUE as root",
                new Integer[]{Integer.MAX_VALUE}, true);

        // Test 10: Left-skewed valid BST
        //     3
        //    /
        //   2
        //  /
        // 1
        runTest("Test 10: Left-skewed valid BST",
                new Integer[]{3, 2, null, 1}, true);
    }
}
