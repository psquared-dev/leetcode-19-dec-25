package designguru01;

import java.util.PriorityQueue;

public class FindtheMedianofaNumberStream {
    public static class Solution {
        PriorityQueue<Integer> smallQueue;
        PriorityQueue<Integer> largeQueue;

        public Solution() {
            smallQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            largeQueue = new PriorityQueue<>();
        }

        public void insertNum(int num) {
            smallQueue.add(num);

            if (!smallQueue.isEmpty() && !largeQueue.isEmpty()) {
                if (smallQueue.peek() > largeQueue.peek()) {
                    largeQueue.add(smallQueue.poll());
                }
            }

            if (Math.abs(smallQueue.size() - largeQueue.size()) > 1) {
                if (smallQueue.size() > largeQueue.size()) {
                    largeQueue.add(smallQueue.poll());
                } else {
                    smallQueue.add(largeQueue.poll());
                }
            }
        }

        public double findMedian() {
            if (smallQueue.isEmpty() && largeQueue.isEmpty()) {
                throw new IllegalArgumentException("both queue empty");
            }

            if (smallQueue.isEmpty()) {
                return largeQueue.peek();
            }

            if (largeQueue.isEmpty()) {
                return smallQueue.peek();
            }

            if (smallQueue.size() == largeQueue.size()) {
                return (smallQueue.peek() + largeQueue.peek()) / 2.0;
            } else if (smallQueue.size() > largeQueue.size()) {
                return smallQueue.peek();
            } else {
                return largeQueue.peek();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.insertNum(3);
//        solution.insertNum(2);
//        solution.insertNum(7);
//        solution.insertNum(4);

        System.out.println(solution.findMedian());
    }
}
