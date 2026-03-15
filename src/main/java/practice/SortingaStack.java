import java.util.Stack;

public class SortingaStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();

        System.out.println(input);

        while (!input.isEmpty()) {

            while (!tmpStack.isEmpty() && tmpStack.peek() > input.peek()) {
                
            }

            tmpStack.push(input.pop());
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
