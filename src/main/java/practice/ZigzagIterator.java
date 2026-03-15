package practice;

import java.util.*;

public class ZigzagIterator {
    public static class Solution {
        List<Integer> l1;
        List<Integer> l2;
        Iterator<Integer> iter1;
        Iterator<Integer> iter2;
        Queue<Iterator<Integer>> queue;

        public Solution(List<Integer> l1, List<Integer> l2) {
            this.l1 = l1;
            this.l2 = l2;

            iter1 = l1.iterator();
            iter2 = l2.iterator();


            queue = new ArrayDeque<>();

            queue.add(iter1);
            queue.add(iter2);
        }

        public int next() {
            if (queue.isEmpty()) {
                throw new NoSuchElementException();
            }
            Iterator<Integer> iter = queue.poll();
            int next = iter.next();

            if (iter.hasNext()) {
                queue.add(iter);
            }

            return next;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution(List.of(1, 10, 20), List.of(5, 15, 100));

        while (solution.hasNext()){
            System.out.println(solution.next());
        }
    }
}
