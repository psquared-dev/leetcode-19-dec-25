package designguru02;

import java.util.HashSet;
import java.util.LinkedList;

public class ZigzagConversion {
    public static String convert(String str, int numRows) {
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        HashSet<Integer> visited = new HashSet<>();
        int jump = numRows + (numRows != 2 ? (numRows / 2) : 0);

        for (int i = 0; i < str.length(); i += jump) {
            queue.add(i);
            visited.add(i);
            result.append(str.charAt(i));
        }

//        System.out.println(queue);
//        System.out.println(result);

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            int prev = polled - 1;
            int next = polled + 1;

            if (prev >= 0 && !visited.contains(prev)) {
                queue.add(prev);
                visited.add(prev);
                result.append(str.charAt(prev));
            }

            if (next < str.length() && !visited.contains(next)) {
                queue.add(next);
                visited.add(next);
                result.append(str.charAt(next));
            }
        }

//        System.out.println(result);

        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(convert("PAYPALISHIRING", 3));
//        System.out.println(convert("PAYPALISHIRING", 4));
//        System.out.println(convert("A", 1));
//        System.out.println(convert("ABC", 2));
        System.out.println(convert("ABCD", 3));
    }
}
