package designguru01;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    static class Solution {
        List<Integer> v1;
        List<Integer> v2;
        Queue<Iterator<Integer>> queue;
        Iterator<Integer> iter1;
        Iterator<Integer> iter2;

        public Solution(List<Integer> v1, List<Integer> v2) {
            // ToDo: Write Your Code Here.
            this.v1 = v1;
            this.v2 = v2;

            queue = new ArrayDeque<>();
            iter1 = v1.iterator();
            iter2 = v2.iterator();
            queue.add(iter1);
            queue.add(iter2);
        }

        public int next() {
            // ToDo: Write Your Code Here.
            while (iter1.hasNext() || iter2.hasNext()){
                Iterator<Integer> iter = queue.poll();
                int next = iter.next();

                if(iter.hasNext()){
                    queue.add(iter);
                }

                return next;
            }

            return -1;
        }

        public boolean hasNext() {
            // ToDo: Write Your Code Here.
            return iter1.hasNext() || iter2.hasNext();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution(List.of(1, 2), List.of(3, 4, 5, 6));

        while (solution.hasNext()){
            System.out.println(solution.next());
        }
    }
}
