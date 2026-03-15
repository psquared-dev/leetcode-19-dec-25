package blind75;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            boolean added = hashSet.add(num);
            if(!added){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}));
    }
}
