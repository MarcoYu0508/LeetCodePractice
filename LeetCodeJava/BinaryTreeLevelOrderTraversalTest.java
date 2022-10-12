import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BinaryTreeLevelOrderTraversalTest {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                result.add(res);
                if (queue.isEmpty()) return result;
                queue.add(null);
                res = new ArrayList<>();
            } else {
                res.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return result;
    }

    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Assert.assertEquals(Arrays.asList(Collections.singletonList(3), Arrays.asList(9,20),Arrays.asList(15,7)), levelOrder(treeNode));
    }

    @Test
    public void test2() {
        Assert.assertEquals(Collections.emptyList(), levelOrder(null));
    }

    @Test
    public void test3() {
        TreeNode treeNode = new TreeNode(1);
        Assert.assertEquals(Collections.singletonList(Collections.singletonList(1)), levelOrder(treeNode));
    }
}
