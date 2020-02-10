package traversals

object TreeNodeTest {
    val simpleTreeNode = run {
        val left = TreeNode(5, null, null)
        TreeNode(10, left, null)
    }

    val lessSimple = run {
        val right = TreeNode(26, null, null)
        val leftMiddle = TreeNode(15, null, right)
        val rightMiddle = TreeNode(86, null, null)
        TreeNode(5, leftMiddle, rightMiddle)
    }
}