package practice;

public class DecimaltoBinaryConversion {

    /*
           4 % 2 = 0
           4 / 2 = 2

           2 % 2 = 0
           2 / 2 = 1

           1 % 2 = 1
           1 / 2 = 0
     */

    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        int n = num;

        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(18));
    }
}
