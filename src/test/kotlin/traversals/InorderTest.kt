package traversals

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InorderTest {

    @Test
    fun `iterative - simple inorder traversal`() {
        val traversal = Inorder.iterative(TreeNode.from(10, 5))

        assertThat(traversal).isEqualTo(listOf(5, 10))
    }

    @Test
    fun `iterative - more complex inorder traversal`() {
        val traversal = Inorder.iterative(TreeNode.from(
            5,
            15, 86,
            null, 26, null, null
        ))

        assertThat(traversal)
            .isEqualTo(listOf(15, 26, 5, 86))
    }

    @Test
    fun `recursive - simple inorder traversal`() {
        val traversal = Inorder.recursive(TreeNode.from(10, 5))

        assertThat(traversal).isEqualTo(listOf(5, 10))
    }

    @Test
    fun `recursive - more complex inorder traversal`() {
        val traversal = Inorder.recursive(TreeNodeTest.lessSimple)

        assertThat(traversal).isEqualTo(listOf(15, 26, 5, 86))
    }
}