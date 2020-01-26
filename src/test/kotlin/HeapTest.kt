import org.junit.Test
import java.util.*
import kotlin.Comparator
import kotlin.random.Random

class HeapTest {

    @Test
    fun `a priority queue behaves like our heap`() {
        val intComparison = Comparator<Int> { x, y -> x.compareTo(y) }
        assertPrioritySortEquivalence(listOf(1, 3, 5), intComparison)
        assertPrioritySortEquivalence(listOf(-2, 5, 66, 1800, -532, -686), intComparison)
        assertPrioritySortEquivalence(
            generateSequence { Random.nextInt() }
                .take(300)
                .toList(),
            intComparison
        )
    }

    private fun <T> assertPrioritySortEquivalence(ls: List<T>, cmp: Comparator<T>) {
        val heap = Heap<T>(cmp)
        val pq = PriorityQueue<T>(cmp)

        ls.forEach {
            heap.add(it)
            pq.add(it)
        }
        val heapList = List(heap.size()) { heap.remove() }
        val pqList = List(pq.size) { pq.remove() }//.reversed()
        assert(heapList == pqList) {
            """
                heapList: ${heapList.joinToString()}
                pqList: ${pqList.joinToString()}
            """.trimIndent()
        }
    }

    @Test
    fun `an in order heap sort sorts`() {
        val ourList = mutableListOf(-2, 5, 66, 1800, -532, -686)
        val timSort = ourList.sorted()

        Heap.inPlaceSort(ourList) { x, y -> x.compareTo(y) }

        assert(timSort == ourList) {
            """
                ourList: ${ourList.joinToString()}
                timSort: ${timSort.joinToString()}
            """.trimIndent()
        }
    }
}