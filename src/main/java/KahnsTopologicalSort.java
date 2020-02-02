import kotlin.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class KahnsTopologicalSort {
    public static <T> List<T> topoSort(Map<T, List<T>> adj) {
        final Map<T, Set<T>> inverted = adj.keySet()
                .stream()
                .collect(Collectors.toMap(x -> x, unused -> new HashSet<>()));

        adj.forEach((oldKey, value) ->
                value.forEach(newKey -> inverted.get(newKey).add(oldKey))
        );
        final List<T> topoSort = new ArrayList<>();
        final Queue<T> pending = new ArrayDeque<>();
        inverted.forEach((key, value) -> {
            if (value.size() == 0) {
                pending.add(key);
            }
        });
        while(!pending.isEmpty()) {
            T freed = pending.remove();
            adj.get(freed).forEach(dependent -> {
                Set<T> edges = inverted.get(dependent);
                edges.remove(freed);
                if (edges.size() == 0) {
                    pending.add(dependent);
                }
            });
            topoSort.add(freed);
        }
        if (topoSort.size() != adj.size()) {
            throw new IllegalArgumentException("Graph has cycles");
        }
        return topoSort;
    }
}
