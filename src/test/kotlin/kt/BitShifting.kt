package kt

import org.junit.Test
import traversals.TreeNode

class BitShifting {

    @Test
    fun `shift to right`() {
        assert(one shl 1 == 2) {
            one shl 1
        }
    }

    @ExperimentalStdlibApi
    @Test
    fun `my impl of bit count`() {
        for (i in -1024 until 1024) {
            assert(bitCount(i) == Integer.bitCount(i)) {
                "i: $i, Jvm: ${Integer.bitCount(i)}, us: ${bitCount(i)}"
            }
        }
    }

    private companion object {
        private val one = Integer.valueOf("1")

        init {
            require(one == 1)
        }

        fun bitCount(num: Int): Int {
            return if (num < 0) {
                32 - bitCount(-num - 1)
            } else {
                var out = 0
                var curr = num
                while (curr > 0) {
                    out += curr and 1
                    curr = curr shr 1
                }
                out
            }
        }

        fun preorder(treeNode: TreeNode?): Sequence<TreeNode> = sequence<TreeNode> {
            if (treeNode != null) {
                yield(treeNode)
            }
        }
    }
}