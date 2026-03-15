package designguru01;

public class BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = findHeight(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced(TreeNode root) {
        // ToDo: Write Your Code Here.
        return findHeight(root) != -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        root.right = node5;
        root.left = node2;
        node2.left = node3;
        node3.left = node4;

        System.out.println(isBalanced(root));
    }
}
