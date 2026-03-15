package designguru01;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        // ToDo: Write Your Code Here.
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayDeque<Integer> result = new ArrayDeque<>();

        while (!q.isEmpty()){
            stack.push(q.poll());
        }

        while (!stack.isEmpty()){
            result.add(stack.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        q1.add(3);
        q1.add(5);
        q1.add(2);
        System.out.println(reverseQueue(q1));
    }
}
