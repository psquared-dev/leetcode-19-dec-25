package designguru01;

public class MinimumDifferenceBetweenBSTNodes {

    // TreeNode class to represent the Binary Search Tree nodes.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        // Using a List to hold the values in order.
        private int minDiff = Integer.MAX_VALUE;
        private TreeNode prev;

        public void inOrder(TreeNode root) {
            if (root != null) {
                inOrder(root.left);
//                nodes.add(root.val);
                if (prev != null) {
                    minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
                }
                prev = root;
                inOrder(root.right);
            }
        }

        public int minDiffInBST(TreeNode root) {
            // ToDo: Write Your Code Here.
            inOrder(root);
            return minDiff;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(7);
//
//        root.right.right = new TreeNode(18);


        TreeNode root = new TreeNode(40);

        root.right = new TreeNode(70);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(90);

        Solution solution = new Solution();
//        solution.inOrder(root, null);
//        System.out.println(solution.nodes);
        System.out.println(solution.minDiffInBST(root));
    }
}
