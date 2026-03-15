package blind75;

import javax.lang.model.type.ArrayType;
import java.util.Objects;

public class ValidateBinarySearchTree {
    private static class TreeNode {
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

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof TreeNode treeNode)) return false;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    public static boolean doBSTValidation(TreeNode root, double lower, double upper){
        if (root == null) {
            return true;
        }

        if (!(lower < root.val && root.val < upper)) {
            return false;
        }

        boolean isLeftValid = doBSTValidation(root.left, lower, root.val);
        boolean isRightValid = doBSTValidation(root.right, root.val, upper);

        return isLeftValid && isRightValid;
    }

    public static boolean isValidBST(TreeNode root) {
        return doBSTValidation(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        System.out.println(isValidBST(root1));
//
//        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
//        System.out.println(isValidBST(root2));

//        TreeNode root3 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
//        System.out.println(isValidBST(root3));

        TreeNode root4 = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7))
        );
        System.out.println(isValidBST(root4));
    }
}
