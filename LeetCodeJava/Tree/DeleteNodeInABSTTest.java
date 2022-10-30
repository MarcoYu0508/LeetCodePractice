package Tree;

import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DeleteNodeInABSTTest {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.create(new Integer[]{5, 3, 6, 2, 4, null, 7});
        Assert.assertEquals(Arrays.asList(5, 4, 6, 2, 7), deleteNode(root, 3).levelOrderList());
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.create(new Integer[]{5, 3, 6, 2, 4, null, 7});
        Assert.assertEquals(Arrays.asList(5, 3, 6, 2, 4, 7), deleteNode(root, 0).levelOrderList());
    }

}
