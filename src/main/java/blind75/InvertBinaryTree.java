package blind75;

import java.util.*;

public class InvertBinaryTree {
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

    public static boolean isValidBST(TreeNode root) {
        return false;
    }

    private static List<Integer> printTree(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.add(root);
        visited.add(root);
        result.add(root.val);

        while (!queue.isEmpty()){
            ArrayList<TreeNode> adjecents = new ArrayList<>();
            TreeNode polled = queue.poll();

            if(polled.left != null){
                adjecents.add(polled.left);
                result.add(polled.left.val);
            }

            if(polled.right != null){
                adjecents.add(polled.right);
                result.add(polled.right.val);
            }

            for (TreeNode adj : adjecents) {
                queue.add(adj);
                visited.add(adj);
            }
        }

        return result;
    }

    private static void doInvertTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        doInvertTree(root.left);
        doInvertTree(root.right);
    }

    public static TreeNode invertTree(TreeNode root) {
        doInvertTree(root);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        System.out.println(printTree(root1));
//        TreeNode inverted1 = invertTree(root1);
//        System.out.println(printTree(inverted1));

        TreeNode root2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(printTree(root2));

        TreeNode inverted2 = invertTree(root2);
        System.out.println(printTree(inverted2));
    }
}
