package LinkedList;

import LinkedList.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListTest {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    @Test
    public void test1() {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 3, 4, 5}, 0);
        ListNode answer = ListNode.createListNode(new int[]{5, 4, 3, 2, 1}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(reverseList(node)));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.createListNode(new int[]{1, 2}, 0);
        ListNode answer = ListNode.createListNode(new int[]{2, 1}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(reverseList(node)));
    }

    @Test
    public void test3() {
        ListNode node = ListNode.createListNode(new int[]{}, 0);
        ListNode answer = ListNode.createListNode(new int[]{}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(reverseList(node)));
    }
}
