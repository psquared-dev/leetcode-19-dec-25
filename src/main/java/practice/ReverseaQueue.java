package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseaQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        System.out.println(q);

        LinkedList<Integer> stack = new LinkedList<>();

        while (!q.isEmpty()) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.add(stack.poll());
        }

        return q;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3));
        System.out.println(reverseQueue(list));
    }
}
