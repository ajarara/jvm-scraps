package traversals;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inorder {
    @NotNull
    public static List<Integer> iterative(@NotNull TreeNode root) {
        final LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }

        final List<Integer> out = new ArrayList<>();
        while(!stack.isEmpty()) {
            TreeNode t = stack.pop();
            out.add(t.value);
            t = t.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
        }
        return out;
    }

    @NotNull
    public static List<Integer> recursive(@NotNull TreeNode root) {
        final List<Integer> out = new ArrayList<>();
        descend(root, out);
        return out;
    }

    private static void descend(TreeNode root, @NotNull List<Integer> out) {
        if (root == null) {
            return;
        }
        descend(root.left, out);
        out.add(root.value);
        descend(root.right, out);
    }

    private Inorder() {
        throw new IllegalStateException("cannot be instantiated");
    }
}
