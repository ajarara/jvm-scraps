import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.*
import java.util.stream.Collectors.toList
import java.util.stream.IntStream
import java.util.stream.Stream

internal class SolutionTest {

    @Test
    fun `scratch test`() {
        Stream.builder<Int>()
            .add(5)
            .build()
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 5, 7),
            intArrayOf(6, 7, 9),
            intArrayOf(10, 15, 20)
        )
        for (column in 0 until matrix.size) {
            for (row in 0 until matrix[0].size) {
                println(matrix[column][row])
            }
        }
    }

    @Test
    fun `current solution`() {
        val s = Solution()
        val encoded = s.encode(listOf("aasdf", "bgiag", "", "|"))
        val decoded = s.decode(encoded)
        assert(decoded == listOf("aasdf", "bgiag", "", "|")) { "$decoded" }
    }

    @Test
    fun `serialization of map`() {
        val map = mapOf(
            1 to "example",
            2 to "sure"
        )

        val outputStream = ByteArrayOutputStream()
        ObjectOutputStream(outputStream)
            .writeObject(map)
        "".toByteArray()
        val serialized = Base64.getEncoder().encodeToString(outputStream.toByteArray())

        val deserialized = ObjectInputStream(
            ByteArrayInputStream(Base64.getDecoder().decode(serialized))
        ).readObject() as Map<*, *>

        assert(deserialized == map) {
            """
            original: $map
            deserialized: $deserialized
            """.trimIndent()
        }
    }
}