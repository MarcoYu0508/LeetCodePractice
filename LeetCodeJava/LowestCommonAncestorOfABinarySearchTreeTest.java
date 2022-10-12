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
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.right.left = new TreeNode(3);
        treeNode.left.right.right = new TreeNode(5);
        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(9);
        Assert.assertEquals(6, lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(8)).val);
        Assert.assertEquals(2, lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4)).val);
    }
}
