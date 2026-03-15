package blind75;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0,
                right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int b = right - left;
            int currArea = b * h;

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{8, 7, 2, 1}));
    }
}
