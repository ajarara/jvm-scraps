package kt

import sorting.adaptiveMergeSort
import org.junit.Test
import kotlin.random.Random

class AdaptiveMergeSortKtTest {

    @Test
    fun `adaptive merge sort performs well enough`() {
        val shuffled = List(1_000_000) { Random.nextInt() }
        val sorted = adaptiveMergeSort(shuffled)
        val timSorted = shuffled.sorted()

        assert(sorted == timSorted)
    }
}