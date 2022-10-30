package Tree;

import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversalTest {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode node;
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            while (!s1.isEmpty()) {
                node = s1.pop();
                res.add(node.val);
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            result.add(res);
            res = new ArrayList<>();
            while (!s2.isEmpty()) {
                node = s2.pop();
                res.add(node.val);
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
            if (!res.isEmpty()) result.add(res);
        }
        return result;
    }

    @Test
    public void test1() {
        TreeNode treeNode = TreeNode.create(new Integer[]{3, 9, 20, null, null, 15, 7});
        Assert.assertEquals(Arrays.asList(Collections.singletonList(3), Arrays.asList(20, 9), Arrays.asList(15, 7)), zigzagLevelOrder(treeNode));
    }

    @Test
    public void test2() {
        TreeNode treeNode = TreeNode.create(new Integer[]{1, 2, 3, 4, null, null, 5});
        Assert.assertEquals(Arrays.asList(Collections.singletonList(1), Arrays.asList(3, 2), Arrays.asList(4, 5)), zigzagLevelOrder(treeNode));
    }

}
