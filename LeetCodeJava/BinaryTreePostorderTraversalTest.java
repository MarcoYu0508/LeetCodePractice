import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreePostorderTraversalTest {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            traversal(node.left, result);
            traversal(node.right, result);
            result.add(node.val);
        }
    }

    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(3, 2, 1), postorderTraversal(treeNode));
    }

    @Test
    public void test2() {
        Assert.assertEquals(Collections.emptyList(), postorderTraversal(null));
    }

    @Test
    public void test3() {
        TreeNode treeNode = new TreeNode(1);
        Assert.assertEquals(Collections.singletonList(1), postorderTraversal(treeNode));
    }
}
