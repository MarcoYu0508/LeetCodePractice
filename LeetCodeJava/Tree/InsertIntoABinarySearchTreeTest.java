package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InsertIntoABinarySearchTreeTest {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        else {
            TreeNode node = new TreeNode(val);
            TreeNode parent = null;
            TreeNode current = root;
            while (current != null) {
                parent = current;
                if (val < current.val) current = current.left;
                else current = current.right;
            }
            if (val < parent.val) parent.left = node;
            else parent.right = node;
        }
        return root;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.create(new Integer[]{4, 2, 7, 1, 3});
        Assert.assertEquals(List.of(4, 2, 7, 1, 3, 5), insertIntoBST(root, 5).levelOrderList());
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.create(new Integer[]{40, 20, 60, 10, 30, 50, 70});
        Assert.assertEquals(List.of(40, 20, 60, 10, 30, 50, 70, 25), insertIntoBST(root, 25).levelOrderList());
    }
}
