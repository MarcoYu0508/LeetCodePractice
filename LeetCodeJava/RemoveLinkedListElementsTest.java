import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class RemoveLinkedListElementsTest {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode node = head;

        while (node.next != null) {
            if (node.next.val == val) node.next = node.next.next;
            else node = node.next;
        }
        if (head.val == val) head = head.next;
        return head;
    }

    @Test
    public void test1() {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 6, 3, 4, 5, 6}, 0);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), ListNode.toList(removeElements(node, 6)));
    }

    @Test
    public void test2() {
        Assert.assertEquals(Collections.emptyList(), ListNode.toList(removeElements(null, 1)));
    }

    @Test
    public void test3() {
        ListNode node = ListNode.createListNode(new int[]{7, 7, 7, 7}, 0);
        Assert.assertEquals(Collections.emptyList(), ListNode.toList(removeElements(node, 7)));
    }

    @Test
    public void test4() {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 2, 1}, 0);
        Assert.assertEquals(Arrays.asList(1, 1), ListNode.toList(removeElements(node, 2)));
    }
}
