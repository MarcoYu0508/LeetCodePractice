package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.createListNode(new int[]{2, 4, 3}, 0);
        ListNode l2 = ListNode.createListNode(new int[]{5, 6, 4}, 0);
        ListNode answer = ListNode.createListNode(new int[]{7, 0, 8}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(addTwoNumbers(l1, l2)));
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.createListNode(new int[]{0}, 0);
        ListNode l2 = ListNode.createListNode(new int[]{0}, 0);
        ListNode answer = ListNode.createListNode(new int[]{0}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(addTwoNumbers(l1, l2)));
    }

    @Test
    public void test3() {
        ListNode l1 = ListNode.createListNode(new int[]{9, 9, 9, 9, 9, 9, 9}, 0);
        ListNode l2 = ListNode.createListNode(new int[]{9, 9, 9, 9}, 0);
        ListNode answer = ListNode.createListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(addTwoNumbers(l1, l2)));
    }
}
