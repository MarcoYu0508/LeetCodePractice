package Tree;

import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    int preorderIdx = 0;
    HashMap<Integer, Integer> inorderIdxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIdx++];
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, left, inorderIdxMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inorderIdxMap.get(rootVal) + 1, right);
        return root;
    }

    @Test
    public void basicTest() {
        Assert.assertEquals(Arrays.asList(3, 9, 20, 15, 7), buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).levelOrderList());
    }
}
