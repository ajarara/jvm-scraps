package traversals;

import java.util.*;
import java.util.stream.Stream;

public class Postorder {

    public static List<Integer> recursive(TreeNode treeNode) {
        final List<Integer> out = new ArrayList<>();
        descend(treeNode, out);
        return out;
    }

    private static void descend(TreeNode root, List<Integer> out) {
        if (root == null) {
            return;
        }
        descend(root.left, out);
        descend(root.right, out);
        out.add(root.value);
    }

    public static List<Integer> iterative(TreeNode treeNode) {
        if (treeNode == null) {
            return Collections.emptyList();
        }
        final LinkedList<TreeNode> stack = new LinkedList<>();
        final List<Integer> out = new ArrayList<>();
        stack.push(treeNode);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            out.add(curr.value);
            Stream.of(curr.left, curr.right)
                    .filter(Objects::nonNull)
                    .forEach(stack::push);
        }
        Collections.reverse(out);  // lol.
        return out;
    }
}
