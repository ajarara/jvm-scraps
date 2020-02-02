package leetcode

import org.junit.Test
import java.util.*

class WordDfsTest {

    @Test
    fun `word dfs works on single node`() {
        val computed = WordDfs.smallestFromLeaf(
            WordDfs.TreeNode(0)
        )

        assert(computed == "a") {
            "Expected 'a', got '$computed'"
        }
    }

    @Test
    fun `word dfs works on node with left and right`() {
        val tree = WordDfs.TreeNode(5)
        tree.left = WordDfs.TreeNode(3);
        tree.right = WordDfs.TreeNode(0);

        val q = ArrayDeque<Int>();
        q.poll()
    }
}