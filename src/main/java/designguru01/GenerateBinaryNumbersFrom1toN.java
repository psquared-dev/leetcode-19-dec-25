package designguru01;

import java.util.ArrayDeque;
import java.util.Arrays;

public class GenerateBinaryNumbersFrom1toN {
    public static String[] generateBinaryNumbers(int n) {
        String[] res = new String[n]; //You can modify this

        // ToDo: Write Your Code Here.
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String polled = queue.poll();
            res[i] = polled;

            queue.add(polled + "0");
            queue.add(polled + "1");
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateBinaryNumbers(2)));
        System.out.println(Arrays.toString(generateBinaryNumbers(5)));
    }
}
