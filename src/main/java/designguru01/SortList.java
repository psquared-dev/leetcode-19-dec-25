package designguru01;

public class SortList {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode node) {
            val = x;
            this.next = node;
        }
    }

    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            // even length
            return prev;
        } else {
            // odd length
            return slow;
        }
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-100);
        ListNode ptr = dummy;

        while (p1 != null && p2 != null) {
            ListNode newNode;

            if (p1.val < p2.val) {
                newNode = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                newNode = new ListNode(p2.val);
                p2 = p2.next;
            }

            ptr.next = newNode;
            ptr = ptr.next;
        }

        ListNode rest = p1 == null ? p2 : p1;

        while (rest != null) {
            ptr.next = new ListNode(rest.val);
            rest = rest.next;
            ptr = ptr.next;
        }

        return dummy.next;
    }

    public static void display(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println();
    }

    public static ListNode sortList(ListNode left) {
        if (left == null || left.next == null) {
            return left;
        }

        ListNode mid = findMid(left);

        ListNode right = mid.next;
        mid.next = null;

        ListNode leftList = sortList(left);
        ListNode rightList = sortList(right);

        return merge(leftList, rightList);
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode l1 = new ListNode(1, new ListNode(8, new ListNode(15)));
//        ListNode l2 = new ListNode(5);

//        System.out.println(findMid(l1).val);

//        ListNode l3 = merge(l1, l2);
//        display(l3);

        ListNode l1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        display(l1);
        ListNode sorted = sortList(l1);
        display(sorted);
    }
}
