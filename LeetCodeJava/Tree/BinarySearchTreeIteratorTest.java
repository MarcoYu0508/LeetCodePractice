package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BinarySearchTreeIteratorTest {
    static class BSTIterator {

        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode current = root;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            TreeNode current = node.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    @Test
    public void basicTest() {
        TreeNode root = TreeNode.create(new Integer[]{7, 3, 15, null, null, 9, 20});

        BSTIterator bstIterator = new BSTIterator(root);

        Assert.assertEquals(3, bstIterator.next());
        Assert.assertEquals(7, bstIterator.next());
        Assert.assertTrue(bstIterator.hasNext());
        Assert.assertEquals(9, bstIterator.next());
        Assert.assertTrue(bstIterator.hasNext());
        Assert.assertEquals(15, bstIterator.next());
        Assert.assertTrue(bstIterator.hasNext());
        Assert.assertEquals(20, bstIterator.next());
        Assert.assertFalse(bstIterator.hasNext());
    }
}
