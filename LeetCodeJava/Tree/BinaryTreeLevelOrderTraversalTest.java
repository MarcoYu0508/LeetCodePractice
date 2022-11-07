package Tree;

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
        TreeNode treeNode = TreeNode.create(new Integer[]{3, 9, 20, null, null, 15, 7});
        Assert.assertEquals(List.of(Collections.singletonList(3), List.of(9, 20), List.of(15, 7)), levelOrder(treeNode));
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
