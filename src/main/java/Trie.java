import java.util.*;

public final class Trie<T> {
    private boolean sentinel = false;
    private final Map<T, Trie<T>> children = new HashMap<>();

    public boolean isBoundary() {
        return sentinel;
    }

    public boolean isWord(List<T> candidate) {

        if (candidate.isEmpty()) {
            return isBoundary();
        } else if (children.containsKey(candidate.get(0))) {
            return children.get(candidate.get(0))
                    .isWord(candidate.subList(1, candidate.size()));
        } else {
            return false;
        }
    }

    // consumes the iterator
    private void add(Iterator<T> elements) {
        if (elements.hasNext()) {
            T key = elements.next();
            children.computeIfAbsent(key, (unused) -> new Trie<>())
                    .add(elements);
        } else {
            sentinel = true;
        }
    }

    private static <T> Trie<T> of(Iterable<Iterable<T>> words) {
        final Trie<T> out = new Trie<>();
        for (Iterable<T> word : words) {
            out.add(word.iterator());
        }
        return out;
    }
}
