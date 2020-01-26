import org.junit.Test
import java.util.*

class HeapTest {

    @Test
    fun `a priority queue behaves like our heap`() {
        val ourList = listOf(1, 3, 5)

        val heap = Heap<Int> { x, y -> x.compareTo(y) }
        val pq = PriorityQueue<Int>()

        ourList.forEach {
            heap.insert(it)
            pq.add(it)
        }
        val heapList = List(heap.size()) { heap.remove() }
        val pqList = pq.toList()
        assert(heapList == pqList) {
            """
                heapList: ${heapList.joinToString()}
                pqList: ${pqList.joinToString()}
            """.trimIndent()
        }
    }
}