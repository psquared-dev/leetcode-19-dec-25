package designguru01;

public class MaximumDepthBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        // ToDo: Write Your Code Here.

        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(4);
        node2.left = new TreeNode(4);

        root.left = node2;
        root.right = new TreeNode(3);

        System.out.println(maxDepth(root));
    }
}
