package designguru01;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // TODO: Write your code here

        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            }
        }


        return dummyHead.next;
    }

    public static void display(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4)));

        ListNode l3 = mergeTwoLists(l1, l2);

        display(l3);

    }
}
