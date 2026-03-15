package designguru01;

public class RemoveDuplicatesfromSortedList {

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

    public static ListNode deleteDuplicates(ListNode head) {
        // TODO: Write your code here

        ListNode prev = head,
                curr = head.next;

        while (curr != null) {
            if (prev.val == curr.val) {
                while (curr != null && prev.val == curr.val) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
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
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);
        l1.next.next.next.next.next = new ListNode(3);
        l1.next.next.next.next.next.next = new ListNode(4);

        display(l1);
        ListNode l2 = deleteDuplicates(l1);
        display(l2);
    }
}
