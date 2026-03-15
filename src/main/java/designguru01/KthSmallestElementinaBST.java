package designguru01;

public class KthSmallestElementinaBST {

    public static class TreeNode {
        int val;                // Value of the node.
        TreeNode left;          // Reference to the left child.
        TreeNode right;         // Reference to the right child.

        // Constructor to initialize the node with its value.
        TreeNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        private int result = 0;
        private int count = 1;

        public void inOrder(TreeNode root, int k) {
            if (root != null) {
                inOrder(root.left, k);
                if (count == k) {
                    result = root.val;
                }
                count++;
                inOrder(root.right, k);
            }
        }

        public int kthSmallest(TreeNode root, int k) {
            // ToDo: Write Your Code Here.
            inOrder(root, k);
            return result;
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(root, 4));
    }
}
