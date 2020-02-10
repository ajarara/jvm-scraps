import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnionFind {

    public static <T> Set<T> roots(Map<T, Set<T>> adj) {
        int[] union = IntStream.range(0, adj.size()).toArray();
        Map<T, Integer> indices = new HashMap<>();
        adj.keySet().forEach(node -> indices.put(node, indices.size()));
        adj.forEach((node, children) ->
               children.forEach(child ->
                       union(union, indices.get(node), indices.get(child))
               )
        );


        Set<Integer> unionIndices = Arrays.stream(union)
                .map(it -> {
                    while (it != union[it]) {
                        it = union[it];
                    }
                    return it;
                })
                .boxed()
                .collect(Collectors.toSet());

        return  indices.entrySet()
                .stream()
                .filter(entry -> unionIndices.contains(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

    }

    private static void union(int[] union, int a, int b) {
        int rootA = find(union, a);
        int rootB = find(union, b);
        union[rootA] = rootB;
    }

    private static int find(int[] union, int n) {
        if (n != union[n]) {
            union[n] = find(union, union[n]);
        }
        return union[n];
    }
}
