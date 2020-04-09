package trees

import traversals.TreeNode
import java.util.*

fun bstOf(treeNode: TreeNode): Sequence<TreeNode> {
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    queue.add(treeNode)
    return sequence {
        while(queue.isNotEmpty()) {
            val removed = queue.remove()
            removed.left?.let { queue.add(it) }
            removed.right?.let { queue.add(it) }
            yield(removed)
        }
    }
}


fun inOrderOf(treeNode: TreeNode): Sequence<TreeNode> {
    return sequence {
        treeNode.left?.let {
            yieldAll(inOrderOf(it))
        }
        yield(treeNode)
        treeNode.right?.let {
            yieldAll(inOrderOf(it))
        }
    }
}

fun preOrderOf(treeNode: TreeNode): Sequence<TreeNode> {
    return sequence {
        yield(treeNode)
        treeNode.left?.let {
            yieldAll(preOrderOf(it))
        }
        treeNode.right?.let {
            yieldAll(preOrderOf(it))
        }
    }
}

fun postOrderOf(treeNode: TreeNode): Sequence<TreeNode> {
    return sequence {
        treeNode.left?.let {
            yieldAll(postOrderOf(it))
        }
        treeNode.right?.let {
            yieldAll(postOrderOf(it))
        }
        yield(treeNode)
    }
}