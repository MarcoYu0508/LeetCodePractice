import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedListsTest {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode node = head;

        if (list2 == null) {
            node.next = list1;
        } else if (list1 == null) {
            node.next = list2;
        } else {
            while (list1 != null || list2 != null) {
                if (list1 == null) {
                    node.next = list2;
                    break;
                } else if (list2 == null) {
                    node.next = list1;
                    break;
                } else {
                    if (list1.val < list2.val) {
                        node.next = list1;
                        node = node.next;
                        list1 = list1.next;
                    } else if (list1.val > list2.val) {
                        node.next = list2;
                        node = node.next;
                        list2 = list2.next;
                    } else {
                        node.next = list1;
                        node = node.next;
                        list1 = list1.next;
                        node.next = list2;
                        node = node.next;
                        list2 = list2.next;
                    }
                }
            }
        }
        return head.next;
    }

    @Test
    public void test1() {
        ListNode list1 = ListNode.createListNode(new int[]{1, 2, 4}, 0);
        ListNode list2 = ListNode.createListNode(new int[]{1, 3, 4}, 0);
        ListNode answer = ListNode.createListNode(new int[]{1, 1, 2, 3, 4, 4}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(mergeTwoLists(list1, list2)));
    }

    @Test
    public void test2() {
        ListNode list1 = ListNode.createListNode(new int[]{}, 0);
        ListNode list2 = ListNode.createListNode(new int[]{}, 0);
        ListNode answer = ListNode.createListNode(new int[]{}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(mergeTwoLists(list1, list2)));
    }

    @Test
    public void test3() {
        ListNode list1 = ListNode.createListNode(new int[]{}, 0);
        ListNode list2 = ListNode.createListNode(new int[]{1}, 0);
        ListNode answer = ListNode.createListNode(new int[]{1}, 0);
        Assert.assertEquals(ListNode.toList(answer), ListNode.toList(mergeTwoLists(list1, list2)));
    }
}
