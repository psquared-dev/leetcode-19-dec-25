package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NextGreaterElement {
    public static List<Integer> nextLargerElement(List<Integer> arr) {
        int[] res = new int[arr.size()];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            int curr = arr.get(i);

            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.poll();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(curr);
        }

        return Arrays.stream(res).boxed().toList();
    }

    public static void main(String[] args) {
//        System.out.println(nextLargerElement(List.of(4, 5, 2, 25)));
//        System.out.println(nextLargerElement(List.of(13, 7, 6, 12)));
        System.out.println(nextLargerElement(List.of(6, 6, 6, 6, 6)));
    }
}
