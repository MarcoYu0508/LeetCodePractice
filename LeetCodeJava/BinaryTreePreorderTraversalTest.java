import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreePreorderTraversalTest {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            traversal(node.left, result);
            traversal(node.right, result);
        }
    }

    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(1, 2, 3), preorderTraversal(treeNode));
    }

    @Test
    public void test2() {
        Assert.assertEquals(Collections.emptyList(), preorderTraversal(null));
    }

    @Test
    public void test3() {
        TreeNode treeNode = new TreeNode(1);
        Assert.assertEquals(Collections.singletonList(1), preorderTraversal(treeNode));
    }
}
