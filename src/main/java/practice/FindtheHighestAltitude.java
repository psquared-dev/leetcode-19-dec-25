package practice;

public class FindtheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currAlt = 0;

        for (int i = 0; i < gain.length; i++) {
            currAlt = currAlt + gain[i];
            maxAltitude = Math.max(maxAltitude, currAlt);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{
                -5, 1, 5, 0, -7
        }));

        System.out.println(largestAltitude(new int[]{
                4, -3, 2, -1, -2
        }));
    }
}
