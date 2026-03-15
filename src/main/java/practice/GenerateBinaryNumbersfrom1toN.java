package practice;

import java.util.Arrays;
import java.util.LinkedList;

public class GenerateBinaryNumbersfrom1toN {
    public static String[] generateBinaryNumbers(int n) {
        String[] res = new String[n];
        LinkedList<String> queue = new LinkedList<>();
        int count = 0;
        queue.add("1");

        while (count < n) {
            String polled = queue.poll();
            res[count++] = polled;
            queue.add(polled + "0");
            queue.add(polled + "1");
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateBinaryNumbers(4)));
    }
}
