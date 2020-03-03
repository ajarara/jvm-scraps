package traversals

import org.junit.Test

class TreeNodeExtensionsKtTest {

    @Test
    fun `toCompleteForm should start with result of static from factory`() {
        val completeForm = arrayOf(
            5,
            10, 25,
            15, null, 18, 25,
            5, 31, null, null, 13
        )
        val backAgain = TreeNode.from(*completeForm)
            .toCompleteForm()
            .subList(0, completeForm.size)

        assert(backAgain == completeForm.asList()) {
            backAgain.joinToString()
        }

    }
}