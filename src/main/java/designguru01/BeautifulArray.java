package designguru01;

import java.util.ArrayList;
import java.util.Arrays;

public class BeautifulArray {
    public static int[] beautifulArray(int n) {
        int[] result = {1};

        for (int i = 0; i < n; i++) {
            int[] odds = handleOdds(result, n);
            int[] evens = handleEven(result, n);

            result = new int[odds.length + evens.length];
            System.arraycopy(odds, 0, result, 0, odds.length);
            System.arraycopy(evens, 0, result, odds.length, evens.length);
        }

        return result;
    }

    public static int[] handleOdds(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int newNum = 2 * arr[i] - 1;
            if (newNum > n) {
                continue;
            }

            list.add(newNum);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] handleEven(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int newNum = 2 * arr[i];
            if (newNum > n) {
                continue;
            }

            list.add(newNum);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(beautifulArray(3)));
    }
}
