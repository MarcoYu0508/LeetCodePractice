package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
        TreeNode node = TreeNode.create(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        Assert.assertEquals(List.of(4, 7, 2, 9, 6, 3, 1), invertTree(node).levelOrderList());
    }

    @Test
    public void test2() {
        TreeNode node = TreeNode.create(new Integer[]{2, 1, 3});
        Assert.assertEquals(List.of(2, 3, 1), invertTree(node).levelOrderList());
    }
}
