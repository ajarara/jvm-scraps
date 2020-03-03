package traversals;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

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

    // null _in_ values is expected, that's why we use the boxed Integer
    public static TreeNode from(Integer... values) {
        Objects.requireNonNull(values);

        if (values.length == 0) {
            throw new IllegalArgumentException("Complete cannot be empty");
        }
        TreeNode[] byPosition = new TreeNode[values.length];

        for (int i = values.length - 1; i >= 0; i--) {
            Integer nodeValue = values[i];
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
