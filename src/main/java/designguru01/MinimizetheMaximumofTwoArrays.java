package designguru01;

public class MinimizetheMaximumofTwoArrays {
    public static long minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long left = 1,
                right = Integer.MAX_VALUE,
                result = Integer.MAX_VALUE;

        while (left <= right) {
            long mid = (right + left) / 2;

            if (isPossible(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return (int) result;
    }

    public static boolean isPossible(long m, long divisor1, long divisor2, long uniqueCnt1, long uniqueCnt2) {



        long cnt1 = m - m / divisor1;
        long cnt2 = m - m / divisor2;
        long bothCnt = m - m / lcm(divisor1, divisor2);

        return uniqueCnt1 <= cnt1 &&
                uniqueCnt2 <= cnt2 &&
                uniqueCnt1 + uniqueCnt2 <= bothCnt;
    }

    public static long lcm(long a, long b) {
        long tmp, prod = a * b;

        if (a < b) {
            tmp = b;
            b = a;
            a = tmp;
        }

        while (b != 0) {
            long rem = a % b;
            a = b;
            b = rem;
        }

        return prod / a;
    }

    public static void main(String[] args) {
//        System.out.println(minimizeSet(2, 7, 1, 3));
//        System.out.println(minimizeSet(3, 5, 2, 1));
//        System.out.println(minimizeSet(2, 4, 8, 8));
//        System.out.println(minimizeSet(12, 3, 2, 10));
        System.out.println(minimizeSet(1, 1, 1, 1));
//        System.out.println(minimizeSet(1, 100, 1, 200));
//        System.out.println(lcm(6, 8));
//        System.out.println(lcm(8, 6));
    }
}
