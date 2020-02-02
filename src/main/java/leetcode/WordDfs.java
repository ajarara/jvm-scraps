package leetcode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class WordDfs {
    private static final char base = 'a';

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static String smallestFromLeaf(TreeNode root) {
        if (isLeaf(root)) {
            return String.valueOf((char) (root.val + base));
        }

        Iterator<TreeNode> dfs = dfsOf(root);

        List<String> words = new ArrayList<>();
        Map<TreeNode, TreeNode> breadcrumbs = new HashMap<>();
        TreeNode curr = dfs.next();
        breadcrumbs.put(curr, null);
        while(dfs.hasNext()) {
            TreeNode visited = dfs.next();
            breadcrumbs.put(visited, curr);
            if (isLeaf(visited)) {
                words.add(rebuild(breadcrumbs, visited));
            }
        }
        return words.stream()
                .sorted()
                .findFirst()
                .get();
    }

    private static String rebuild(
            Map<TreeNode, TreeNode> breadcrumbs,
            TreeNode visited
    ) {
        StringBuilder out = new StringBuilder();
        TreeNode curr = visited;
        while(curr != null) {
            out.append((char) (curr.val + base));
            curr = breadcrumbs.get(curr);
        }
        return out.toString();
    }


    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static Iterator<TreeNode> dfsOf(TreeNode root) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        return new Iterator<TreeNode>() {
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            public TreeNode next() {
                TreeNode toBeReturned = stack.pop();
                if (toBeReturned.left != null) {
                    stack.push(toBeReturned.left);
                }
                if (toBeReturned.right != null) {
                    stack.push(toBeReturned.right);
                }
                return toBeReturned;
            }
        };
    }
}