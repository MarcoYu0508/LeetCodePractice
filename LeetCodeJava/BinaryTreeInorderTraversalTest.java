import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeInorderTraversalTest {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            traversal(node.left, result);
            result.add(node.val);
            traversal(node.right, result);
        }
    }

    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(1, 3, 2), inorderTraversal(treeNode));
    }

    @Test
    public void test2() {
        Assert.assertEquals(Collections.emptyList(), inorderTraversal(null));
    }

    @Test
    public void test3() {
        TreeNode treeNode = new TreeNode(1);
        Assert.assertEquals(Collections.singletonList(1), inorderTraversal(treeNode));
    }
}
