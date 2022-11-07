package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RemoveDuplicatesFromSortedListIITest {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);

        ListNode pred = sentinel;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred = pred.next;
            }

            head = head.next;
        }
        return sentinel.next;
    }

    @Test
    public void test1() {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 3, 4, 4, 5}, 0);
        Assert.assertEquals(List.of(1, 2, 5), ListNode.toList(deleteDuplicates(listNode)));
    }

    @Test
    public void test2() {
        ListNode listNode = ListNode.createListNode(new int[]{1, 1, 1, 2, 3}, 0);
        Assert.assertEquals(List.of(2, 3), ListNode.toList(deleteDuplicates(listNode)));
    }
}
