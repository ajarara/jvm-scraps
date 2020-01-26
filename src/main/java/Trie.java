import java.util.HashSet;
import java.util.Set;

public class Trie<T> {
    boolean terminal = false;
    final Set<Trie<T>> children = new HashSet<>();
}
