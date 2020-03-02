package traversals;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class TreeNode {
    public final int value;
    @Nullable
    public final TreeNode left;
    @Nullable
    public final TreeNode right;

    public TreeNode(
            final int value,
            @Nullable final TreeNode left,
            @Nullable final TreeNode right
    ) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static TreeNode leaf(final int value) {
        return new TreeNode(value, null, null);
    }

    public static TreeNode from(final List<Integer> complete) {
        if (complete.isEmpty()) {
            throw new IllegalArgumentException("Complete cannot be empty");
        }
        TreeNode[] byPosition = new TreeNode[complete.size()];

        for (int i = complete.size() - 1; i >= 0; i--) {
            Integer nodeValue = complete.get(i);
            if (nodeValue != null) {
                final int leftChild = (2 * i) + 1;
                final int rightChild = (2 * i) + 2;
                byPosition[i] = new TreeNode(
                        nodeValue,
                        leftChild >= byPosition.length ? null : byPosition[leftChild],
                        rightChild >= byPosition.length ? null : byPosition[rightChild]
                );
            }
        }
        return byPosition[0];
    }
}
