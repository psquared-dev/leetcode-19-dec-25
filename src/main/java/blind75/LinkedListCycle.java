package blind75;

import java.util.HashSet;
import java.util.Objects;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int i) {
            val = i;
            next = null;
        }


        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ListNode listNode)) return false;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    // approach 2
    public static boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // approach 1
    public static boolean hasCycle1(ListNode head) {
        ListNode p1 = head;
        HashSet<ListNode> hashSet = new HashSet<>();

        while (p1 != null) {
            hashSet.add(p1);
            p1 = p1.next;

            if (hashSet.contains(p1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        ListNode list1 = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
//        list1.next = list1.next.next;

        ListNode list1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))));

        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

//        System.out.println(hasCycle2(list1));
        System.out.println(hasCycle2(list2));
    }
}
