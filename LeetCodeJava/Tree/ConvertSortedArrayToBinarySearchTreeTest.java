package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConvertSortedArrayToBinarySearchTreeTest {
    public TreeNode sortedArrayToBST(int[] numbs) {
        if (numbs.length == 0) return null;
        return getNode(numbs, 0, numbs.length - 1);
    }

    private TreeNode getNode(int[] numbs, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(numbs[mid]);
        root.left = getNode(numbs, start, mid - 1);
        root.right = getNode(numbs, mid + 1, end);
        return root;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(List.of(0, -10, 5, -3, 9), sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).levelOrderList());
        Assert.assertEquals(List.of(1, 3), sortedArrayToBST(new int[]{1, 3}).levelOrderList());
    }
}
