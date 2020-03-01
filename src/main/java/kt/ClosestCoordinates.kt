package kt

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        require(points.size >= k)
        val heap = PriorityQueue<Proximity>(compareBy { it.proximity })

        points.map(::Proximity)
            .forEach { heap.add(it) }

        return Array(k) { heap.poll()!!.point }
    }
}

private class Proximity(val point: IntArray) {
    init {
        require(point.size == 2)
    }

    val proximity = sqrt(
        point[0].toDouble().pow(2.0) + point[1].toDouble().pow(2.0)
    )
}