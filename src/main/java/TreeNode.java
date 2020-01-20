import org.jetbrains.annotations.Nullable;

public final class TreeNode<T> {

    public final T elem;
    @Nullable
    public final TreeNode<T> left;
    @Nullable
    public final TreeNode<T> right;

    public TreeNode(
            T elem,
            @Nullable TreeNode<T> left,
            @Nullable TreeNode<T> right
    ) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TreeNode)) {
            return false;
        }
        TreeNode<?> casted = (TreeNode<?>) other;

        return elem == casted.elem
                && left == casted.left
                && right == casted.right;
    }

    public static <T> TreeNode<T> of(T elem, TreeNode<T> left, TreeNode<T> right) {
        return new TreeNode<>(elem, left, right);
    }

    public static <T> TreeNode<T> leaf(T elem) {
        return new TreeNode<>(elem, null, null);
    }
}
