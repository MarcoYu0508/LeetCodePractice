package Tree;

import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorOfABinaryTreeTest {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    @Test
    public void basicTest() {
        TreeNode root = TreeNode.create(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});

        assert root != null;
        Assert.assertEquals(root, lowestCommonAncestor(root, root.left, root.right));
        Assert.assertEquals(root.left, lowestCommonAncestor(root, root.left, root.left.right.right));
    }
}
