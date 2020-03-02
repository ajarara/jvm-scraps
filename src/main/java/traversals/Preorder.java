package traversals;

import java.util.*;
import java.util.stream.Stream;

public final class Preorder {

    public static List<Integer> iterative(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        final LinkedList<TreeNode> stack = new LinkedList<>();
        final List<Integer> out = new ArrayList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            out.add(curr.value);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return out;
    }

    public static List<Integer> recursive(TreeNode root) {
        final List<Integer> out = new ArrayList<>();
        descend(root, out);
        return out;
    }

    private static void descend(TreeNode root, List<Integer> out) {
        if (root == null) {
            return;
        }
        out.add(root.value);
        descend(root.left, out);
        descend(root.right, out);
    }

    private Preorder() {
        throw new IllegalStateException("cannot be instantiated");
    }
}
