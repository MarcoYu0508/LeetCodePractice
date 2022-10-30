package Tree;

import org.junit.Assert;
import org.junit.Test;

public class PathSumTest {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int sum = root.val;

        if (sum == targetSum && root.left == null && root.right == null) return true;

        return checkSum(root.left, sum, targetSum) || checkSum(root.right, sum, targetSum);
    }

    private boolean checkSum(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;
        sum += node.val;

        if (sum == targetSum && node.left == null && node.right == null) return true;

        return checkSum(node.left, sum, targetSum) || checkSum(node.right, sum, targetSum);
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.create(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        Assert.assertTrue(hasPathSum(root, 22));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.create(new Integer[]{1, 2, 3});
        Assert.assertFalse(hasPathSum(root, 5));
    }

    @Test
    public void test3() {
        TreeNode node = TreeNode.create(new Integer[]{-2, null, -3});
        Assert.assertTrue(hasPathSum(node, -5));
    }
}
