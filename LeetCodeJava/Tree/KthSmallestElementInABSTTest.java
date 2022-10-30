package Tree;

import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class KthSmallestElementInABSTTest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.create(new Integer[]{3, 1, 4, null, 2});
        Assert.assertEquals(1, kthSmallest(root, 1));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.create(new Integer[]{5, 3, 6, 2, 4, null, null, 1});

        Assert.assertEquals(3, kthSmallest(root, 3));
    }
}
