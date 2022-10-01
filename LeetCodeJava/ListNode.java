import java.util.ArrayList;
import java.util.List;

public class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNode(int[] numbs, int index) {
        if (index < numbs.length)
            return new ListNode(numbs[index], createListNode(numbs, ++index));
        else {
            return null;
        }
    }

    public static List<Integer> toList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
