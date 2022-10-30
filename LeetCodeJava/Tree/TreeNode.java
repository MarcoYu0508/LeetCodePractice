package Tree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode create(Integer[] values) {
        if (values.length == 0) return null;

        if (values[0] == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(values[0]);

        queue.add(root);

        int size = values.length;
        for (int i = 1; i < size; i++) {
            TreeNode parent = queue.poll();
            if (parent != null) {
                if (values[i] != null) {
                    TreeNode left = new TreeNode(values[i]);
                    parent.left = left;
                    queue.add(left);
                }
                if (++i < size) {
                    if (values[i] != null) {
                        TreeNode right = new TreeNode(values[i]);
                        parent.right = right;
                        queue.add(right);
                    }
                }
            }
        }
        return root;
    }

    public List<Integer> levelOrderList() {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return result;
    }
}
