package practice;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImplementStackusingQueues {
    public static class Solution {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public Solution() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        // Push element x onto the stack
        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }

            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        public int pop() {
            Integer polled = q1.poll();
            if (polled == null) throw new NoSuchElementException();
            return polled;
        }

        public int top() {
            Integer peeked = q1.peek();
            if (peeked == null) throw new NoSuchElementException();
            return peeked;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(10);
        solution.push(20);
        solution.push(30);
        solution.push(40);
        System.out.println(solution.q1);

        System.out.println(solution.pop());
        System.out.println(solution.q1);
    }
}
