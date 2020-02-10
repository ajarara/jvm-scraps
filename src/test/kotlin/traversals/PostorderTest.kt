package traversals

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PostorderTest {

    @Test
    fun `recursive - simple`() {
        val traversed = Postorder.recursive(TreeNodeTest.simpleTreeNode)

        assertThat(traversed).isEqualTo(listOf(5, 10))
    }

    @Test
    fun `recursive - more complex`() {
        val traversed = Postorder.recursive(TreeNodeTest.lessSimple)

        assertThat(traversed).isEqualTo(listOf(26, 15, 86, 5))
    }

    @Test
    fun `iterative - simple`() {
        val traversed = Postorder.iterative(TreeNodeTest.simpleTreeNode)

        assertThat(traversed).isEqualTo(listOf(5, 10))
    }

    @Test
    fun `iterative - more complex`() {
        val traversed = Postorder.iterative(TreeNodeTest.lessSimple)

        assertThat(traversed).isEqualTo(listOf(26, 15, 86, 5))
    }
}