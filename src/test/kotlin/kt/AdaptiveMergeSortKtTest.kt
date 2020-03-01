package kt

import org.junit.Test
import kotlin.random.Random

class AdaptiveMergeSortKtTest {

    @Test
    fun `adaptive merge sort performs well`() {
        val shuffled = List(5_000_000) { Random.nextInt() }
        val sorted = adaptiveMergeSort(shuffled)
        val timSorted = shuffled.sorted()

        assert(sorted == timSorted)
    }
}