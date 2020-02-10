import org.junit.Test

class UnionFindTest {

    @Test
    fun `union find identifies roots`() {
        val roots = UnionFind.roots(mapOf(
            'b' to setOf('c','d'),
            'c' to setOf('e'),
            'd' to setOf(),
            'e' to setOf()
        ))

        assert(roots == setOf('e', 'd')) { "$roots" }
    }

    @Test
    fun `union identifies roots in a more complex graph`() {
        val roots = UnionFind.roots(mapOf(
            0 to setOf(7),
            1 to setOf(3, 4, 5),
            2 to setOf(3, 5),
            3 to setOf(4),
            4 to setOf(5),
            5 to setOf(6),
            6 to setOf(0),
            7 to setOf()
        ))

        assert(roots == setOf(7)) { "$roots" }
    }
}