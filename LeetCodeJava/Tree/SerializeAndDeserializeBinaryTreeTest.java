package Tree;

import Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SerializeAndDeserializeBinaryTreeTest {
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder builder = new StringBuilder();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    builder.append(node.val).append(" ");
                    queue.add(node.left);
                    queue.add(node.right);
                } else builder.append("null ");
            }

            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (Objects.equals(data, "")) return null;

            Queue<TreeNode> queue = new LinkedList<>();

            String[] values = data.split(" ");

            TreeNode root = new TreeNode(Integer.parseInt(values[0]));

            queue.add(root);

            for (int i = 1; i < values.length; i++) {
                TreeNode parent = queue.poll();
                if (parent != null) {
                    if (!values[i].equals("null")) {
                        TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                        parent.left = left;
                        queue.add(left);
                    }
                    if (!values[++i].equals("null")) {
                        TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                        parent.right = right;
                        queue.add(right);
                    }
                }
            }
            return root;
        }
    }

    @Test
    public void basicTest() {
        Codec codec = new Codec();
        TreeNode root = TreeNode.create(new Integer[]{1, 2, 3, null, null, 4, 5});
        TreeNode ans = codec.deserialize(codec.serialize(root));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), ans.levelOrderList());
    }
}
