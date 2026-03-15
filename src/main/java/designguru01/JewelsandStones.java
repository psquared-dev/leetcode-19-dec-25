package designguru01;

import java.util.Set;
import java.util.stream.Collectors;

public class JewelsandStones {
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> jewelsHashSet = jewels.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toSet());

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if(jewelsHashSet.contains(ch)){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("abc", "aabbcc"));
    }
}
