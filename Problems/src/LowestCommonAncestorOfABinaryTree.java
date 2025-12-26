import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }

        TreeNode leftResult = lowestCommonAncestor(root.left,p,q);
        TreeNode rightResult = lowestCommonAncestor(root.right,p,q);

        if (leftResult != null && rightResult != null) {
            return root;
        }

        return (leftResult != null) ? leftResult : rightResult;
    }

    public static void main(String[] args) {
        System.out.println("hi");
    }


}
