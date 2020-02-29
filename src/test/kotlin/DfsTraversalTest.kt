import org.junit.Test

class DfsTraversalTest {

    @Test
    fun `paths work trivially`() {
        val node = DfsTraversal.TreeNode(5, listOf())
        val path = DfsTraversal.getPath(node) { it == node }

        assert(path.size == 1)
        assert(path.first() == node)
    }

    @Test
    fun `degenerate treenodes behave well in a dfs`() {
        var root = DfsTraversal.TreeNode(1_000_000, listOf())
        repeat(100_000) {
            root = DfsTraversal.TreeNode(it, listOf(root))
        }
        val found = DfsTraversal.getPath(root) { it.value == 1_000_000 }
        assert(found.size == 100_001)
        assert(found.first().value == 1_000_000)
    }

    // need a way to measure this..
    @Test
    fun `high branch treenodes behave well in this dfs`() {
        val b = sequence {
            yield(5)
            yieldAll(listOf(100, 200))
        }

        val bigTree = bigTree(8_000_000)
        val now = System.currentTimeMillis();
        val path = DfsTraversal.getPath(bigTree) { it.children.isEmpty() }
        println("Finished searching ${System.currentTimeMillis() - now}")
        println("Path size: ${path.size}")
    }


    // need a way to measure this..
    @Test
    fun `high branch treenodes behave well in recursive dfs`() {
        val bigTree = bigTree(8_000_000)
        val now = System.currentTimeMillis();
        val path = RecursiveDfsTraversal.recursiveDfs(bigTree, { it.children.isEmpty() }, null)
        println("Finished searching ${System.currentTimeMillis() - now}")
        println("Path size: ${path.size}")
    }

    private fun bigTree(size: Int): DfsTraversal.TreeNode? {
        return when(size) {
            0 -> null
            1 -> DfsTraversal.TreeNode(1, listOf())
            else -> DfsTraversal.TreeNode(size, listOf(bigTree(size / 2), bigTree(size / 2)))
        }
    }
}