package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfTwoLinkedListsTest {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0;
        int lenB = 0;

        while (nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        int diff = lenA - lenB;

        nodeA = headA;
        nodeB = headB;

        if (diff > 0) {
            while (diff > 0) {
                nodeA = nodeA.next;
                diff--;
            }
        } else {
            while (diff < 0) {
                nodeB = nodeB.next;
                diff++;
            }
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA != nodeB) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            } else {
                return nodeA;
            }
        }

        return null;
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.createListNode(new int[]{4, 1}, 0);
        ListNode l2 = ListNode.createListNode(new int[]{5, 6, 1}, 0);
        ListNode intersection = ListNode.createListNode(new int[]{8, 4, 5}, 0);
        if (l1 != null) {
            l1.next = intersection;
        }
        if (l2 != null) {
            l2.next = intersection;
        }
        Assert.assertEquals(intersection, getIntersectionNode(l1, l2));
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.createListNode(new int[]{1, 9, 1}, 0);
        ListNode l2 = new ListNode(3);
        ListNode intersection = ListNode.createListNode(new int[]{2, 4}, 0);
        if (l1 != null) {
            l1.next = intersection;
        }
        l2.next = intersection;
        Assert.assertEquals(intersection, getIntersectionNode(l1, l2));
    }

    @Test
    public void test3() {
        ListNode l1 = ListNode.createListNode(new int[]{2, 6, 4}, 0);
        ListNode l2 = ListNode.createListNode(new int[]{1, 5}, 0);
        Assert.assertNull(getIntersectionNode(l1, l2));
    }
}
