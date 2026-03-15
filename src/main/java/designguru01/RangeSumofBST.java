package designguru01;

public class RangeSumofBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static class Solution {
        private int rangeSum = 0;

        public void inOrder(TreeNode root, int L, int R) {
            if (root != null) {
                inOrder(root.left, L, R);

                if (L <= root.val && root.val <= R) {
                    rangeSum += root.val;
                }

                inOrder(root.right, L, R);
            }
        }

        public int rangeSumBST(TreeNode root, int L, int R) {
            // ToDo: Write Your Code Here.
            inOrder(root, L, R);
            return rangeSum;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);

        Solution solution = new Solution();
        System.out.println(solution.rangeSumBST(root, 7, 15));
    }
}
