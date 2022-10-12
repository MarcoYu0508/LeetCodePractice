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
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        Assert.assertTrue(isValidBST(treeNode));
    }

    @Test
    public void test2() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        Assert.assertFalse(isValidBST(treeNode));
    }
}
