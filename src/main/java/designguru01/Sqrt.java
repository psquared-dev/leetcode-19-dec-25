package designguru01;

public class Sqrt {
    public static int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1, right = x / 2;
        double prev = 1;

        while (left <= right) {
            double mid = (int) ((left + right) / 2);

            if (mid * mid <= x) {
                prev = mid;
            }

            if (mid * mid > x) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }

        return (int) prev;
    }

    public static int mySqrt1(int x) {
        double i = 0;
        while (true) {
            if (i * i > x) {
                return (int) (i - 1);
            }
            i++;
        }
    }

    public static void main(String[] args) {
//        System.out.println(mySqrt1(9));
//        System.out.println(mySqrt1(7));
//        System.out.println(mySqrt1(8));
//        System.out.println(mySqrt1(1));
//        System.out.println(mySqrt1(2147395600));

        System.out.println(mySqrt2(37));
//        System.out.println(mySqrt2(7));
//        System.out.println(mySqrt2(8));
//        System.out.println(mySqrt2(1));
//        System.out.println(mySqrt2(2147395600));
    }
}
