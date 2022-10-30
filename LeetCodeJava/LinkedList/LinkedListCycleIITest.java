package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleIITest {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    @Test
    public void test1() {
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(2);
        first.next = second;
        first.next.next = new ListNode(0);
        first.next.next.next = new ListNode(-4);
        first.next.next.next.next = second;
        Assert.assertEquals(second, detectCycle(first));
    }

    @Test
    public void test2() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = first;
        Assert.assertEquals(first, detectCycle(first));
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(0);
        Assert.assertNull(detectCycle(head));
    }
}
