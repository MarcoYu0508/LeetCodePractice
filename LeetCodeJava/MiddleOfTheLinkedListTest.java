import org.junit.Assert;
import org.junit.Test;

public class MiddleOfTheLinkedListTest {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void test1() {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 3, 4, 5}, 0);
        ListNode answer = ListNode.createListNode(new int[]{3, 4, 5}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(middleNode(node)));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6}, 0);
        ListNode answer = ListNode.createListNode(new int[]{4, 5, 6}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(middleNode(node)));
    }
}
