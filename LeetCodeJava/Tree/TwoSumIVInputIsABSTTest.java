package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
        TreeNode treeNode = TreeNode.create(new Integer[]{5, 3, 6, 2, 4, null, 7});
        Assert.assertTrue(findTarget(treeNode, 9));
        Assert.assertFalse(findTarget(treeNode, 28));
    }
}
