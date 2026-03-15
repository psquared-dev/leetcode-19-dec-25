package blind75;

public class MinimumCommonValue {

    public static int findMinimumCommonValue(int[] nums1, int[] nums2) {
        int idx1 = 0, idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                return nums1[idx1];
            }

            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            }

        }

        return -1;
    }

//    public static int findMinimumCommonValue(int[] nums1, int[] nums2) {
//        HashSet<Integer> activeHashSet;
//        int[] activeArr;
//
//        HashSet<Integer> hashSet1 = Arrays.stream(nums1)
//                .boxed()
//                .collect(Collectors.toCollection(HashSet::new));
//
//        HashSet<Integer> hashSet2 = Arrays.stream(nums2)
//                .boxed()
//                .collect(Collectors.toCollection(HashSet::new));
//
//        if (nums1.length < nums2.length) {
//            activeArr = nums1;
//            activeHashSet = hashSet2;
//        } else {
//            activeArr = nums2;
//            activeHashSet = hashSet1;
//        }
//
//        System.out.println(Arrays.toString(activeArr));
//
//        for (int i = 0; i < activeArr.length; i++) {
//            if(activeHashSet.contains(activeArr[i])){
//                return activeArr[i];
//            }
//        }
//
//        return -1;
//    }

    public static void main(String[] args) {
//        System.out.println(findMinimumCommonValue(
//                new int[]{1, 3, 5, 7},
//                new int[]{3, 4, 5, 6, 8, 10}
//        ));
//
//        System.out.println(findMinimumCommonValue(
//                new int[]{2, 4, 6},
//                new int[]{1, 3, 5}
//        ));
//
//        System.out.println(findMinimumCommonValue(
//                new int[]{1, 2, 2, 3},
//                new int[]{2, 2, 4}
//        ));

        System.out.println(findMinimumCommonValue(
                new int[]{10, 20, 30},
                new int[]{15, 25, 35}
        ));
    }
}
