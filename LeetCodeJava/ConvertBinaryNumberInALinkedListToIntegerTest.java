import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ConvertBinaryNumberInALinkedListToIntegerTest {
    public int getDecimalValue(ListNode head) {
        int bit = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            res += ((int) Math.pow(2, bit++)) * stack.pop();
        }
        return res;
    }

    @Test
    public void test1() {
        ListNode listNode = ListNode.createListNode(new int[]{1, 0, 1}, 0);
        Assert.assertEquals(5, getDecimalValue(listNode));
    }

    @Test
    public void test2() {
        ListNode listNode = ListNode.createListNode(new int[]{0}, 0);
        Assert.assertEquals(0, getDecimalValue(listNode));
    }

}
