package blind75;

public class ReverseALinkedList {
    static class ListNode {
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

    public static void traverse(ListNode node) {
        ListNode p = node;

        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }

        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        traverse(n1);
        ListNode reverseList = reverseList(n1);
        traverse(reverseList);
    }
}
