package traversals

import java.util.*

fun TreeNode.toCompleteForm(): List<Int?> {
    val out = mutableListOf<Int?>()
    val queue = LinkedList<Peg>()
    queue.add(Peg(0, this))
    out.add(this.value)
    var lastSeenLevel = -1
    var addedChildren = true
    while (queue.isNotEmpty()) {
        val polled = queue.remove()
        if (polled.level > lastSeenLevel) {
            if (addedChildren) {
                lastSeenLevel = polled.level
                addedChildren = false
            } else {
                return out
            }
        }

        if (polled.treeNode == null) {
            repeat(2) {
                out.add(null)
                queue.add(Peg(polled.level + 1, null))
            }
        } else {
            listOf(polled.treeNode.left, polled.treeNode.right).forEach {
                when (it) {
                    null -> {
                        out.add(null)
                        queue.add(Peg(polled.level + 1, null))
                    }
                    else -> {
                        addedChildren = true
                        out.add(it.value)
                        queue.add(Peg(polled.level + 1, it))
                    }
                }
            }
        }
    }

    error("Shouldn't have got here")
}

private class Peg(val level: Int, val treeNode: TreeNode?)

fun TreeNode.toCompleteForm2(): List<Int?> {
    val q = LinkedList<List<TreeNode?>>()
    q.add(listOf(this))
    val out = mutableListOf<Int?>(this.value)
    while (q.isNotEmpty()) {
        val removed = q.remove()
        val children = removed.flatMap {
            listOf(it?.left, it?.right)
        }
        out.addAll(children.map { it?.value })

        if (children.any { it != null }) {
            q.add(children)
        }
    }
    return out
}