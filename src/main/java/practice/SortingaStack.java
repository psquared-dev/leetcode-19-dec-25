package practice;

import java.util.Stack;

public class SortingaStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();

        System.out.println(input);

        while (!input.isEmpty()) {
            int popped = input.pop();

            while (!tmpStack.isEmpty() && tmpStack.peek() > popped) {
                input.push(tmpStack.pop());
            }

            tmpStack.push(popped);
        }

        return tmpStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(11);
        stack.push(14);
        stack.push(12);
        stack.push(10);
        System.out.println(sortStack(stack));
    }
}
