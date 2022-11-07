package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReverseNodesInKGroupTest {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count == k) {
            current = reverseKGroup(current, k);

            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5}, 0);
        ListNode answer = reverseKGroup(head, 2);
        Assert.assertEquals(List.of(2, 1, 4, 3, 5), ListNode.toList(answer));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5}, 0);
        ListNode answer = reverseKGroup(head, 3);
        Assert.assertEquals(List.of(3, 2, 1, 4, 5), ListNode.toList(answer));
    }
}
