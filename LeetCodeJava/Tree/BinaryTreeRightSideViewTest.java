package Tree;

import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeRightSideViewTest {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSide(root, result, 0);
        return result;
    }

    private void rightSide(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;

        if (depth == result.size()) result.add(root.val);

        rightSide(root.right, result, depth + 1);
        rightSide(root.left, result, depth + 1);
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.create(new Integer[]{1, 2, 3, null, 5, null, 4});
        Assert.assertEquals(Arrays.asList(1, 3, 4), rightSideView(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.create(new Integer[]{1, null, 3});
        Assert.assertEquals(Arrays.asList(1, 3), rightSideView(root));
    }
}
