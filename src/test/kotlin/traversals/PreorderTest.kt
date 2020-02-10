package traversals

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PreorderTest {

    @Test
    fun `recursive - simple`() {
        val traversal = Preorder.recursive(TreeNodeTest.simpleTreeNode)

        assertThat(traversal).isEqualTo(listOf(10, 5))
    }

    @Test
    fun `recursive - more complex`() {
        val traversal = Preorder.recursive(TreeNodeTest.lessSimple)

        assertThat(traversal).isEqualTo(listOf(5, 15, 26, 86))
    }

    @Test
    fun `iterative - simple`() {
        val traversal = Preorder.iterative(TreeNodeTest.simpleTreeNode)

        assertThat(traversal).isEqualTo(listOf(10, 5))
    }

    @Test
    fun `iterative - more complex`() {
        val traversal = Preorder.iterative(TreeNodeTest.lessSimple)

        assertThat(traversal).isEqualTo(listOf(5, 15, 26, 86))
    }
}