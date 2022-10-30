package LinkedList;

import LinkedList.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class SwapNodesInPairsTest {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;

        while (head.next != null && head.next.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head.next.next;
            head.next.next = temp;
            head = head.next.next;
        }
        return newHead;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4}, 0);
        Assert.assertEquals(Arrays.asList(2, 1, 4, 3), ListNode.toList(swapPairs(head)));
    }

    @Test
    public void test2() {
        Assert.assertEquals(Collections.emptyList(), ListNode.toList(swapPairs(null)));
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        Assert.assertEquals(Collections.singletonList(1), ListNode.toList(swapPairs(head)));
    }
}
