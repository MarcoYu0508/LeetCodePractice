package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReorderListTest {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode middle = p1;
        ListNode current = p1.next;

        while (current.next != null) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = middle.next;
            middle.next = temp;
        }

        p1 = head;
        p2 = middle.next;

        while (p1 != middle) {
            middle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = middle.next;
        }
    }

    @Test
    public void test1() {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4}, 0);
        reorderList(head);
        Assert.assertEquals(List.of(1, 4, 2, 3), ListNode.toList(head));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5}, 0);
        reorderList(head);
        Assert.assertEquals(List.of(1, 5, 2, 4, 3), ListNode.toList(head));
    }
}
