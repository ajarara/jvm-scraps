import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.math.exp

class KahnsTopologicalSortTest {
    @Test
    fun `toposort works`() {
        val sorted = KahnsTopologicalSort.topoSort(mapOf(
            "a" to listOf("b", "c"),
            "b" to listOf("d"),
            "c" to listOf("d"),
            "d" to listOf()
        ))
        val expected = listOf("a", "b", "c", "d")
        assert(sorted == expected) {
            """
                sorted = $sorted
                expected = $expected
            """.trimIndent()
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun `cycle detection doesn't run forever`() {
        KahnsTopologicalSort.topoSort(mapOf(
            "a" to listOf("c"),
            "c" to listOf("a")
        ))
    }

    @Test
    fun `forests are topologically sorted`() {
        val sorted = KahnsTopologicalSort.topoSort(mapOf(
            "a" to listOf("c"),
            "c" to listOf(),
            "e" to listOf()
        ))

        assert(sorted == listOf("a", "e", "c")) {
            "$sorted"
        }
    }
}