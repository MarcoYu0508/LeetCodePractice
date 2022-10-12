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
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        Assert.assertTrue(hasPathSum(node, 22));
    }

    @Test
    public void test2() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        Assert.assertFalse(hasPathSum(node, 5));
    }

    @Test
    public void test3() {
        TreeNode node = new TreeNode(-2);
        node.right = new TreeNode(-3);
        Assert.assertTrue(hasPathSum(node, -5));
    }
}
