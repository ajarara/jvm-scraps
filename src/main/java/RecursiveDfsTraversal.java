import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class RecursiveDfsTraversal {

    public static List<DfsTraversal.TreeNode> recursiveDfs(
            final DfsTraversal.TreeNode root,
            final Predicate<DfsTraversal.TreeNode> predicate,
            @Nullable Step previous
    ) {
        // System.out.println("I've been visited");
        if (predicate.test(root)) {
            final List<DfsTraversal.TreeNode> out = new ArrayList<>();
            out.add(root);
            while (previous != null) {
                out.add(previous.node);
                previous = previous.previous;
            }
            return out;
        } else {
            final Step current = new Step(previous, root);
            return root.children.stream()
                    .map(child -> recursiveDfs(child, predicate, current))
                    .filter(ls -> !ls.isEmpty())
                    .findFirst()
                    .orElse(Collections.emptyList());
        }
    }

    private static class Step {
        @Nullable
        final Step previous;
        @NotNull
        final DfsTraversal.TreeNode node;

        Step(@Nullable Step previous, @NotNull DfsTraversal.TreeNode node) {
            this.previous = previous;
            this.node = node;
        }
    }
}
