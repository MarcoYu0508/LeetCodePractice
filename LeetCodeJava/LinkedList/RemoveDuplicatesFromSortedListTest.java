package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedListTest {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode curr = head.next;
        ListNode prev = head;

        while (curr != null) {
            if (curr.val == prev.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    @Test
    public void test1() {
        ListNode node = ListNode.createListNode(new int[]{1, 1, 2}, 0);
        Assert.assertEquals(Arrays.asList(1, 2), ListNode.toList(deleteDuplicates(node)));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.createListNode(new int[]{1, 1, 2, 3, 3}, 0);
        Assert.assertEquals(Arrays.asList(1, 2, 3), ListNode.toList(deleteDuplicates(node)));
    }
}
