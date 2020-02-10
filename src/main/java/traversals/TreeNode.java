package traversals;

import org.jetbrains.annotations.Nullable;

public final class TreeNode {
    final int value;
    @Nullable
    final TreeNode left;
    @Nullable
    final TreeNode right;

    public TreeNode(
            final int value,
            @Nullable final TreeNode left,
            @Nullable final TreeNode right
    ) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
