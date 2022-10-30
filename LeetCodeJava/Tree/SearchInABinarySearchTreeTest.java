package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class SearchInABinarySearchTreeTest {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.create(new Integer[]{4, 2, 7, 1, 3});
        TreeNode result = searchBST(root, 2);
        assert root != null;
        Assert.assertEquals(root.left.levelOrderList(), result != null ? result.levelOrderList() : Collections.emptyList());
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.create(new Integer[]{4, 2, 7, 1, 3});
        TreeNode result = searchBST(root, 5);
        assert root != null;
        Assert.assertEquals(Collections.emptyList(), result != null ? result.levelOrderList() : Collections.emptyList());
    }
}
