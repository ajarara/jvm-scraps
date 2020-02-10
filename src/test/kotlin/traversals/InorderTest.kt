package traversals

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InorderTest {

    @Test
    fun `iterative - simple inorder traversal`() {
        val traversal = Inorder.iterative(TreeNodeTest.simpleTreeNode)

        assertThat(traversal).isEqualTo(listOf(5, 10))
    }

    @Test
    fun `iterative - more complex inorder traversal`() {
        val traversal = Inorder.iterative(TreeNodeTest.lessSimple)

        assertThat(traversal)
            .isEqualTo(listOf(15, 26, 5, 86))
    }

    @Test
    fun `recursive - simple inorder traversal`() {
        val traversal = Inorder.recursive(TreeNodeTest.simpleTreeNode)

        assertThat(traversal).isEqualTo(listOf(5, 10))
    }

    @Test
    fun `recursive - more complex inorder traversal`() {
        val traversal = Inorder.recursive(TreeNodeTest.lessSimple)

        assertThat(traversal).isEqualTo(listOf(15, 26, 5, 86))
    }
}