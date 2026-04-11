package designguru01;

public class MaximumBinaryTree {

    /**
     * Definition for a binary tree node.
     **/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode create(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIdx = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIdx]);

        root.left = create(nums, left, maxIdx - 1);
        root.right = create(nums, maxIdx + 1, right);

        return root;
    }

    public static int findMax(int[] nums, int left, int right) {
        int idx = left;

        for (int i = left; i <= right; i++) {
            if (nums[idx] < nums[i]) {
                idx = i;
            }
        }

        return idx;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }
}
