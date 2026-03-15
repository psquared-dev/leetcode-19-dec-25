package designguru01;

public class FindDoublyLinkedListIsAPalindrome {
    public static class DLNode {
        int val;
        DLNode next, prev;

        DLNode(int val) {
            this.val = val;
        }
    }


    public static boolean isPalindrome(DLNode head) {
        // ToDo: Write your code here.
        DLNode end = null,
                headPtr = head,
                endPtr = null;

        int len = 0;
        int midPoint;

        while (headPtr != null) {
            end = headPtr;
            headPtr = headPtr.next;
            len++;
        }

        headPtr = head;
        endPtr = end;
        midPoint = (int) Math.ceil((double) len / 2);

        for (int i = 0; i < midPoint; i++) {
            if (headPtr.val != endPtr.val) {
                return false;
            }

            headPtr = headPtr.next;
            endPtr = endPtr.prev;
        }

        return true;
    }

    public static void main(String[] args) {
        DLNode n1 = new DLNode(1);
        DLNode n2 = new DLNode(2);
        DLNode n3 = new DLNode(3);
        DLNode n4 = new DLNode(2);
        DLNode n5 = new DLNode(1);

        // Forward links
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Backward links
        n2.prev = n1;
        n3.prev = n2;
        n4.prev = n3;
        n5.prev = n4;

        System.out.println(isPalindrome(n1));
    }
}
