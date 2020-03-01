package kt

import java.util.*
import kotlin.Comparator

fun <T : Comparable<T>> adaptiveMergeSort(list: List<T>) =
    adaptiveMergeSort(list, compareBy { it })

fun <T> adaptiveMergeSort(list: List<T>, cmp: Comparator<T>): List<T> {
    val runs = getRuns(list, cmp)

    return merge(runs, cmp)
}

private fun <T> getRuns(list: List<T>, cmp: Comparator<T>): List<List<T>> {
    if (list.isEmpty()) {
        return listOf()
    }

    val out = mutableListOf<List<T>>()
    var currRun = mutableListOf(list.first())
    for (inc in list.subList(1, list.size)) {
        if (cmp.compare(currRun.last(), inc) <= 0) {
            currRun.add(inc)
        } else {
            out.add(currRun)
            currRun = mutableListOf(inc)
        }
    }
    out.add(currRun)
    return out
}

private fun <T> merge(list: List<List<T>>, cmp: Comparator<T>): List<T> {
    if (list.isEmpty()) {
        return listOf()
    }
    val queue: Queue<List<T>> = ArrayDeque(list)

    while(queue.size > 1) {
        val merged = merge(queue.remove(), queue.remove(), cmp)

        queue.add(merged)
    }

    return queue.remove()
}

private fun <T> merge(a: List<T>, b: List<T>, cmp: Comparator<T>): List<T> {
    val out = mutableListOf<T>()
    var idxA = 0
    var idxB = 0
    while (idxA < a.size && idxB < b.size) {
        if (cmp.compare(a[idxA], b[idxB]) <= 0) {
            out.add(a[idxA])
            idxA++
        } else {
            out.add(b[idxB])
            idxB++
        }
    }
    if (idxA == a.size) {
        out.addAll(b.subList(idxB, b.size))
    } else {
        out.addAll(a.subList(idxA, a.size))
    }
    return out
}
