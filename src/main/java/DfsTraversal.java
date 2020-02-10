import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class DfsTraversal {
    private DfsTraversal() {
        throw new UnsupportedOperationException("Instantiation prohibited");
    }

    public static List<TreeNode> getPath(TreeNode root, Predicate<TreeNode> predicate) {
        final LinkedList<Path> stack = new LinkedList<>();
        stack.push(new Path(null, root));
        while(!stack.isEmpty()) {
            Path head = stack.pop();
            if (predicate.test(head.node)) {
                final List<TreeNode> out = new ArrayList<>();
                Path curr = head;
                while(curr != null) {
                    out.add(curr.node);
                    curr = curr.tail;
                }
                return out;
            } else {
                for (int i = head.node.children.size() - 1; i >= 0; i--) {
                    stack.push(new Path(head, head.node.children.get(i)));
                }
            }
        }
        return Collections.emptyList();
    }

    private static class Path {
        @Nullable
        final Path tail;
        @NotNull
        final TreeNode node;

        Path(@Nullable Path tail, @NotNull TreeNode node) {
            this.tail = tail;
            this.node = node;
        }
    }

    public static class TreeNode {
        final int value;
        final List<TreeNode> children;
        TreeNode(int value, @NotNull List<TreeNode> children) {
            this.value = value;
            this.children = children;
        }
    }
}
