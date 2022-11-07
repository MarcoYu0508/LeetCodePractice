package Tree;

import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PathSumIITest {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        Stack<Integer> path = new Stack<>();
        pathSumInner(root, targetSum, path);
        return result;
    }

    private void pathSumInner(TreeNode root, int targetSum, Stack<Integer> path) {
        path.push(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) result.add(new ArrayList<>(path));
        if (root.left != null) pathSumInner(root.left, targetSum - root.val, path);
        if (root.right != null) pathSumInner(root.right, targetSum - root.val, path);
        path.pop();
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.create(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        Assert.assertEquals(List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5)), pathSum(root, 22));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.create(new Integer[]{1, 2, 3});
        Assert.assertEquals(Collections.emptyList(), pathSum(root, 22));
    }
}
