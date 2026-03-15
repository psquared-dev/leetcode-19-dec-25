package designguru01;

public class FindHighestAlt {

    // 1 - (-5)
    // -5 + 1
    // 0 + x = -5
    // -5 + x = 1

    /**
     * [-5, 1, 5, 0, -7]
     * 0  -5  -4   1   1   -6
     *
     */


    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0; // To store the maximum altitude encountered
        // TODO: Write your code here
        int prevHeight = 0;

        for (int i = 0; i < gain.length; i++) {
            prevHeight = gain[i] + prevHeight;
            maxAltitude = Math.max(maxAltitude, prevHeight);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(largestAltitude(new int[]{4, -3, 2, -1, -2}));
    }
}
