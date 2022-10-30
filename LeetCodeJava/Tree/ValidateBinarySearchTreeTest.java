package Tree;

import org.junit.Assert;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {
    public boolean isValidBST(TreeNode root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBSTUtil(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return isBSTUtil(node.left, min, node.val) && isBSTUtil(node.right, node.val, max);
    }

    @Test
    public void test1() {
        TreeNode treeNode = TreeNode.create(new Integer[]{2, 1, 3});
        Assert.assertTrue(isValidBST(treeNode));
    }

    @Test
    public void test2() {
        TreeNode treeNode = TreeNode.create(new Integer[]{5, 1, 4, null, null, 3, 6});
        Assert.assertFalse(isValidBST(treeNode));
    }
}
