package blind75;

import java.util.*;

public class ThreeSum {
    static class Tuple {
        private final int a, b, c;

        public Tuple(int a, int b, int c) {
            int[] inputs = {a, b, c};
            Arrays.sort(inputs);
            this.a = inputs[0];
            this.b = inputs[1];
            this.c = inputs[2];
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Tuple)) return false;
            Tuple tuple = (Tuple) o;
            return a == tuple.a && b == tuple.b && c == tuple.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<Tuple> hashSet = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    hashSet.add(new Tuple(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(hashSet);

        return hashSet.stream().map(tuple -> {
            int a = tuple.getA();
            int b = tuple.getB();
            int c = tuple.getC();
            return List.of(a, b, c);
        }).toList();
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-100, -70, -60, 110, 120, 130, 160}));
    }
}
