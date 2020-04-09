package traversals

import org.junit.Test
import java.util.*

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

    @Test
    fun `toCompleteForm2 should be easy to implement`() {
        val completeForm = arrayOf(
            5,
            10, 25,
            15, null, 18, 25,
            5, 31, null, null, 13
        )

        val backAgain = TreeNode.from(*completeForm)
            .toCompleteForm2()
            .subList(0, completeForm.size)

        assert(backAgain == completeForm.asList()) {
            backAgain.joinToString()
        }
    }
}