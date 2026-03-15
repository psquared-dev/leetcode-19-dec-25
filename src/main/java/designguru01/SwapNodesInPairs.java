package designguru01;

public class SwapNodesInPairs {
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

    public static ListNode swapPairs(ListNode head) {
        // TODO: Write your code here

        ListNode ptr = head;

        while (ptr != null) {
            if (ptr.next != null) {
                int tmp = ptr.val;
                ptr.val = ptr.next.val;
                ptr.next.val = tmp;

                ptr = ptr.next.next;
            } else {
                ptr = ptr.next;
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
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode l1 = new ListNode(1);
        ListNode l2 = swapPairs(l1);
        display(l2);
    }
}
