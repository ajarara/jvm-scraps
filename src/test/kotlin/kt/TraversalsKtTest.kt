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


    companion object {
    }
}