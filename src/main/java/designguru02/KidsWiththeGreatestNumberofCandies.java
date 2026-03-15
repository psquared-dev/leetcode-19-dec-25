package designguru02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class KidsWiththeGreatestNumberofCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        boolean[] result1 = new boolean[candies.length];

                                                                                                                        IntStream.range(0, result1.length).mapToObj(i -> result1[i]).toList();


        int max = candies[0];

        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        for (int candy : candies) {
            result.add(extraCandies + candy >= max);
        }

//        System.out.println(max);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{7, 3, 9, 2, 4}, 5));
        System.out.println(kidsWithCandies(new int[]{5, 8, 6, 4, 2}, 3));
    }
}
