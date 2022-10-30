package Tree;

import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorOfABinarySearchTreeTest {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min, max;
        if (p.val < q.val) {
            min = p.val;
            max = q.val;
        } else {
            min = q.val;
            max = p.val;
        }

        for (; ; ) {
            if (max < root.val) {
                root = root.left;
            } else if (min > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    @Test
    public void basicTest() {
        TreeNode treeNode = TreeNode.create(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        Assert.assertEquals(6, lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(8)).val);
        Assert.assertEquals(2, lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4)).val);
    }
}
