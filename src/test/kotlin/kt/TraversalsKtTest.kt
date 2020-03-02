package kt

import org.junit.Test
import traversals.TreeNode

class TraversalsKtTest {

    @Test
    fun `bst works`() {
        val root = TreeNode.from(listOf(
            10,
            3, 5,
            null, null, null, null,
            null, null, null, null, null, null, null, null
        ))

        val values = bstOf(root)
            .map { it.value }
            .toList()

        assert(values == listOf(10, 3, 5)) {
            values.joinToString()
        }
    }

    @Test
    fun `in order works`() {
        val root = TreeNode.from(listOf(
            8,
            null, 3,
            null, null, 5, 10,
            null, null, null, null, 1, 1, 3, 7
        ))

        val values = inOrderOf(root)
            .map { it.value }
            .toList()

        assert(values == listOf(8, 3, 5, 1, 1, 10, 3, 7)) {
            values.joinToString()
        }
    }

    @Test
    fun `pre order works`() {
        val root = TreeNode.from(listOf(
                1,
              2,   5,
            3, 4, 6, 7
        ))

        val values = preOrderOf(root)
            .map { it.value }
            .toList()

        assert(values == listOf(1, 2, 3, 4, 5, 6, 7)) {
            values.joinToString()
        }
    }

    @Test
    fun `post order works`() {
        val root = TreeNode.from(listOf(
                7,
             3,    6,
            1, 2, 4, 5
        ))

        val values = postOrderOf(root)
            .map { it.value }
            .toList()

        assert(values == listOf(1, 2, 3, 4, 5, 6, 7)) {
            values.joinToString()
        }
    }
}