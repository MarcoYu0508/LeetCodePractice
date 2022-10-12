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
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        TreeNode result = searchBST(node, 2);
        Assert.assertEquals(node.left.levelOrderList(), result != null ? result.levelOrderList() : Collections.emptyList());
    }

    @Test
    public void test2() {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        TreeNode result = searchBST(node, 5);
        Assert.assertEquals(Collections.emptyList(), result != null ? result.levelOrderList() : Collections.emptyList());
    }
}
