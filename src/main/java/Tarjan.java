import org.intellij.lang.annotations.Flow;

import java.util.*;

// too complex for a whiteboard.
public class Tarjan {

    public static <T> List<List<T>> scc(final Map<T, List<T>> adj) {
        final Map<T, Info> encountered = new LinkedHashMap<>();
        final List<List<T>> sccs = new ArrayList<>();
        for (T node : adj.keySet()) {
            if (!encountered.containsKey(node)) {
                strongConnect(node, encountered, adj)
                        .ifPresent(sccs::add);
            }
        }
        return sccs;
    }

    private static <T> Optional<List<T>> strongConnect(
            final T node,
            final Map<T, Info> encountered,
            final Map<T, List<T>> adj
    ) {
        final Info nodeInfo = new Info(encountered.size());
        encountered.put(node, nodeInfo);
        for (T child : adj.get(node)) {
            final Info childInfo = encountered.get(child);
            if (childInfo == null) {
                strongConnect(child, encountered, adj);
            } else if (childInfo.onStack) {
                nodeInfo.lowlink = Math.min(nodeInfo.lowlink, childInfo.index);
            }
        }

        if (nodeInfo.lowlink == nodeInfo.index) {
            List<T> nodes = new ArrayList<>();
            Iterator<Map.Entry<T, Info>> stack = encountered.entrySet().iterator();
            while (stack.hasNext()) {
                Map.Entry<T, Info> data = stack.next();

            }
        }
        throw new IllegalStateException("SUre");
    }

    private static final class Info {
        final int index;
        int lowlink;
        boolean onStack;

        public Info(int index) {
            this.index = index;
            this.lowlink = index;
            this.onStack = true;
        }
    }
}
