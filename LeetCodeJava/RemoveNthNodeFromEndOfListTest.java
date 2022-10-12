import org.junit.Assert;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        ListNode slow = node;
        ListNode fast = node;
        node.next = head;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }

    @Test
    public void test1() {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 3, 4, 5}, 0);
        ListNode answer = ListNode.createListNode(new int[]{1, 2, 3, 5}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(removeNthFromEnd(node, 2)));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.createListNode(new int[]{1}, 0);
        ListNode answer = ListNode.createListNode(new int[]{}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(removeNthFromEnd(node, 1)));
    }

    @Test
    public void test3() {
        ListNode node = ListNode.createListNode(new int[]{1, 2}, 0);
        ListNode answer = ListNode.createListNode(new int[]{1}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(removeNthFromEnd(node, 1)));
    }
}
