import java.util.*
import kotlin.Comparator
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sqrt

object GISMap {

    private fun centeredOn(root: Coordinate): Comparator<in Coordinate> {
        fun distanceFromRoot(other: Coordinate) =
            sqrt(
                (root.x - other.x).pow(2.0) + (root.y - other.y).pow(2.0)
            )
        // radian
        fun rotationFromRoot(other: Coordinate): Double {
            if ((0.0..0.000001).contains((other.x - root.x))) {
                return 0.0
            }
            return atan(
                (other.y - root.y) / (other.x - root.x)
            )
        }


        return compareBy(
            ::distanceFromRoot,
            ::rotationFromRoot
        )
    }
    fun of(root: Coordinate, coords: Collection<Coordinate>): NavigableSet<Coordinate> {
        return TreeSet(centeredOn(root)).apply {
            addAll(coords)
        }
    }
}

interface Coordinate {
    val x: Double
    val y: Double
}