package designguru01;

import java.util.Arrays;

public class AppleRedistributionintoBoxes {
    // Method to determine the minimum number of boxes required to store all apples
    public static int distributeApples(int[] apples, int[] boxCapacities) {
        int[] boxes = Arrays.copyOf(boxCapacities, boxCapacities.length);
        int remainingApples = Arrays.stream(apples).sum(), count = 0;

        Arrays.sort(boxes);

        for (int i = boxes.length - 1; i >= 0; i--) {
            remainingApples -= boxes[i];
            count++;
            if (remainingApples < 0) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(distributeApples(new int[]{2, 3, 1}, new int[]{4, 2, 5, 1}));
        System.out.println(distributeApples(new int[]{4, 5, 6}, new int[]{5, 10}));
        System.out.println(distributeApples(new int[]{1, 2, 5, 6}, new int[]{2, 3, 7, 4, 5, 2, 4}));
    }
}
