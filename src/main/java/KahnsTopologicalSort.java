import kotlin.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class KahnsTopologicalSort {

    public static <T> List<T> topoSort(Map<T, List<T>> adj) {
        final Map<T, Set<T>> inverted = adj.keySet()
                .stream()
                .collect(Collectors.toMap(x -> x, unused -> new HashSet<>()));

        adj.forEach((oldKey, value) ->
                value.forEach(newKey -> inverted.get(newKey).add(oldKey))
        );
        final List<T> topoSort = inverted.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isEmpty())
                .map(Map.Entry::getKey)
                .collect(toList());

        for (int i = 0; i < topoSort.size(); i++) {
            T freed = topoSort.get(i);
            adj.get(freed).forEach(dependent -> {
                Set<T> edges = inverted.get(dependent);
                edges.remove(freed);
                if (edges.isEmpty()) {
                    topoSort.add(dependent);
                }
            });
        }
        if (topoSort.size() != adj.size()) {
            throw new IllegalArgumentException("Graph has cycles");
        }
        return topoSort;
    }
}
