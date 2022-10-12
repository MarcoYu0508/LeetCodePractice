import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TwoSumIVInputIsABSTTest {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (set.contains(k - current.val)) return true;
            else set.add(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return false;
    }


    @Test
    public void basicTest() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        Assert.assertTrue(findTarget(treeNode, 9));
        Assert.assertFalse(findTarget(treeNode, 28));
    }
}
