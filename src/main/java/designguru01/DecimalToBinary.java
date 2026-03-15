package designguru01;

import java.util.LinkedList;

public class DecimalToBinary {
    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        // ToDo: Write Your Code Here.

        LinkedList<Integer> stack = new LinkedList<>();
        int factor = 2;
        int n = num;

        while (n != 0){
            int rem = n % factor;
            stack.push(rem);
            n = n / factor;
        }

        while (!stack.isEmpty()){
            sb.append(stack.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(4));
    }
}
