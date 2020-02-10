package strings

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.stream.Collectors.toList
import kotlin.streams.toList

class SubstringsTest {

    @Test
    fun `substrings of foo are f, fo, foo, oo, o`() {
        val subs = Substrings.enumerate("foo")

        assertThat(subs)
            .isEqualTo(listOf(
                "f",
                "fo",
                "foo",
                "o",
                "oo",
                "o"
            ))
    }
}