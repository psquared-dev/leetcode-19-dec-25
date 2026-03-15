package designguru01;


import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueue {
    static class Solution {
        // Constructor to initialize the queues
        Queue<Integer> queue;

        public Solution() {
            queue = new ArrayDeque<>();
            // ToDo: Write Your Code Here.
        }

        // Push element x onto the stack
        public void push(int x) {
            // ToDo: Write Your Code Here.
            ArrayDeque<Integer> tempQueue = new ArrayDeque<>();

            tempQueue.add(x);

            while (!queue.isEmpty()){
                tempQueue.add(queue.poll());
            }

            queue = tempQueue;
        }

        public int pop() {
            // ToDo: Write Your Code Here.
            return queue.remove();
        }

        public int top() {
            // ToDo: Write Your Code Here.
            return queue.peek();
        }

        public boolean empty() {
            // ToDo: Write Your Code Here.
            return queue.isEmpty();
        }

        @Override
        public String toString() {
            return "Solution{" +
                    "queue=" + queue +
                    '}';
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);

        System.out.println(solution);

        System.out.println(solution.pop());
        System.out.println(solution.top());

//        ArrayDeque<Integer> q1 = new ArrayDeque<>();
//        q1.add(1);
//        q1.add(2);
//        q1.add(3);
//
//        System.out.println(q1);
//        System.out.println(q1.peek());

    }
}
