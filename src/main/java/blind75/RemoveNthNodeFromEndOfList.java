package blind75;

public class RemoveNthNodeFromEndOfList {
    private static class ListNode {
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

    public static void traverse(ListNode listNode) {
        ListNode p = listNode;

        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }

        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast;
        ListNode dummy = new ListNode();
        dummy.next = head;
        fast = dummy;
        slow = dummy;

//        dummy -> 1 -> 2 -> 3 ->  4 -> 5 ->
//

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        traverse(listNode);
        ListNode removedListNode = removeNthFromEnd(listNode, 5);
        traverse(removedListNode);
    }
}
