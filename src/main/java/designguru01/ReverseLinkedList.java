package designguru01;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        // TODO: Write your code here

        ListNode curr = head,
                prev = null,
                next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        display(l1);
        ListNode reversed = reverseList(l1);
        display(reversed);
    }
}
