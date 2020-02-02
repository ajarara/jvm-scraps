import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.*
import java.util.stream.Collectors.toList
import java.util.stream.IntStream

internal class SolutionTest {

    @Test
    fun `list returned by collector is mutable`() {
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