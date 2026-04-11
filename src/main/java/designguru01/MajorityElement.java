package designguru01;

public class MajorityElement {
    public static int findMajority(int[] arr) {
        int count = 0;
        int result = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                result = arr[i];
            }

            if (result == arr[i]) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }


//    approach 1
//    public static int findMajority(int[] arr) {
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            freqMap.merge(arr[i], 1, (oldCount, newCount) -> oldCount + 1);
//        }
//
//        System.out.println(freqMap);
//
//        List<Map.Entry<Integer, Integer>> list = freqMap.entrySet()
//                .stream()
//                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
//                .toList();
//
//        System.out.println(list);
//
//        return list.get(0).getKey();
//    }

    public static void main(String[] args) {
//        System.out.println(findMajority(new int[]{1, 2, 2, 3, 2}));
//        System.out.println(findMajority(new int[]{4, 4, 4, 4, 7, 4, 4}));
//        System.out.println(findMajority(new int[]{9, 9, 1, 1, 9, 1, 9, 9}));
//        System.out.println(findMajority(new int[]{2, 2, 1, 1, 1, 2, 2}));
//        System.out.println(findMajority(new int[]{3, 2, 3}));
        System.out.println(findMajority(new int[]{3, 3, 4}));
    }
}
