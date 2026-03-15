package designguru01;

public class ClosestBinarySearchTreeValue {

    // Define a TreeNode structure with left and right children.
    public static class TreeNode {
        int val;                  // Value stored in the node.
        TreeNode left;            // Reference to the left child.
        TreeNode right;           // Reference to the right child.

        // Constructor to initialize a new node with a value.
        TreeNode(int x) {
            val = x;
        }
    }

    public static int closestValue(TreeNode root, double target) {
        int closestVal = root.val;
        TreeNode curr = root;

        while (curr != null) {
            double oldDist = Math.abs(closestVal - target);
            double newDist = Math.abs(curr.val - target);

            if (oldDist > newDist) {
                closestVal = curr.val;
            } else if (oldDist == newDist) {
                closestVal = Math.min(closestVal, curr.val);
            }

            if (target > curr.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }

        }

        return closestVal;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(4);
//
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(50);
//
//        root.left = new TreeNode(30);
//        root.right = new TreeNode(70);
//
//        root.left.left = new TreeNode(10);
//        root.left.right = new TreeNode(40);
//
//        root.right.left = new TreeNode(60);
//        root.right.right = new TreeNode(90);


        System.out.println(closestValue(root, 3.5));
    }
}
