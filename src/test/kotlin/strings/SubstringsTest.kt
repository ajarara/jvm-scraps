package strings

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

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