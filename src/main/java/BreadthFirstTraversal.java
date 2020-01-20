import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Spliterator;

public class BreadthFirstTraversal {

    public static <T> Iterator<TreeNode<T>> iterate(TreeNode<T> root) {
        final Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);

        return new Iterator<TreeNode<T>>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public TreeNode<T> next() {
                TreeNode<T> toBeReturned = queue.remove();
                if (toBeReturned.left != null) {
                    queue.add(toBeReturned.left);
                }
                if (toBeReturned.right != null) {
                    queue.add(toBeReturned.right);
                }
                return toBeReturned;
            }
        };
    }
}
