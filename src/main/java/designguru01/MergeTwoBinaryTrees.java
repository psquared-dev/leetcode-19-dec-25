package designguru01;

public class MergeTwoBinaryTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // ToDo: Write Your Code Here.
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root = null;

        if (t1 == null) {
            root = new TreeNode(t2.val);
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        }

        if (t2 == null) {
            root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        }

        if (t1 != null && t2 != null) {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(3);

        System.out.println(mergeTrees(root1, root2));
    }
}
