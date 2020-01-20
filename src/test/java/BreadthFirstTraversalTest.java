import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BreadthFirstTraversalTest {
    @Test
    public void lonelyNodeAppearsOnlyOnce() {
        TreeNode<Integer> root = TreeNode.leaf(5);

        assertThat(iterateAndCollect(root)).containsExactly(root);
    }

    @Test
    public void leftNodeAppearsBeforeRight() {
        TreeNode<Integer> left = TreeNode.leaf(5);
        TreeNode<Integer> right = TreeNode.leaf(20);
        TreeNode<Integer> root = TreeNode.of(20, left, right);

        assertThat(iterateAndCollect(root)).containsExactly(
                root, left, right
        );
    }

    @Test
    public void rightMostNodeAppearsInIteration() {
        TreeNode<Integer> rightLevelTwo = TreeNode.leaf(15);
        TreeNode<Integer> rightLevelOne = TreeNode.of(10, null, rightLevelTwo);
        TreeNode<Integer> leftLevelOne = TreeNode.leaf(-1);
        TreeNode<Integer> root = TreeNode.of(9, leftLevelOne, rightLevelOne);

        assertThat(iterateAndCollect(root)).containsExactly(
                root, leftLevelOne, rightLevelOne, rightLevelTwo
        );
    }

    private <T> List<TreeNode<T>> iterateAndCollect(TreeNode<T> root) {
        List<TreeNode<T>> collected = new ArrayList<>();
        BreadthFirstTraversal.iterate(root)
                .forEachRemaining(collected::add);
        return collected;
    }
}