import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertIntoABinarySearchTreeTest {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        else  {
            TreeNode node = new TreeNode(val);
            TreeNode parent = null;
            TreeNode current = root;
            while (current!= null) {
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
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        Assert.assertEquals(Arrays.asList(4, 2, 7, 1, 3, 5), insertIntoBST(node, 5).levelOrderList());
    }

    @Test
    public void test2() {
        TreeNode node = new TreeNode(40);
        node.left = new TreeNode(20);
        node.left.left = new TreeNode(10);
        node.left.right = new TreeNode(30);
        node.right = new TreeNode(60);
        node.right.left = new TreeNode(50);
        node.right.right = new TreeNode(70);
        Assert.assertEquals(Arrays.asList(40, 20, 60, 10, 30, 50, 70, 25), insertIntoBST(node, 25).levelOrderList());
    }
}
