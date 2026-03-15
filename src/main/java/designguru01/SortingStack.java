package designguru01;

import java.util.Collections;
import java.util.Stack;
import java.util.List;

public class SortingStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> tmpStack = new Stack<>();
        // ToDo: Write Your Code Here.

        inputStack.addAll(input);

        while (!inputStack.isEmpty()) {
            Integer polled = inputStack.pop();
            if (tmpStack.isEmpty() || tmpStack.peek() < polled) {
                tmpStack.push(polled);
            } else {
                while (!tmpStack.isEmpty() && tmpStack.peek() > polled) {
                    Integer polledTmp = tmpStack.pop();
                    inputStack.push(polledTmp);
                }
                tmpStack.push(polled);
            }
        }

        return tmpStack;
    }

    public static void main(String[] args) {
//        System.out.println(sortStack(new Stack<>(List.of(1, 5, 2, 6))));
        Stack<Integer> s1 = new Stack<>();
        s1.push(6);
        s1.push(2);
        s1.push(5);
        s1.push(1);

//        System.out.println(s1);
        System.out.println(sortStack(s1));
    }
}
