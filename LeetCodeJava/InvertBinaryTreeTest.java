import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InvertBinaryTreeTest {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp;
        temp = root.right;
        root.right = root.left;
        root.left = temp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    @Test
    public void test1() {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);
        Assert.assertEquals(Arrays.asList(4, 7, 2, 9, 6, 3, 1), invertTree(node).levelOrderList());
    }

    @Test
    public void test2() {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(2, 3, 1), invertTree(node).levelOrderList());
    }
}
