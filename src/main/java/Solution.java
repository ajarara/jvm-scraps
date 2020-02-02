import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    private static final class WildcardTrie {
        private final Map<Character, WildcardTrie> backed = new HashMap<>();
        private boolean isWord = false;

        public void add(String word, int idx) {
            if (word.length() == idx) {
                isWord = true;
            } else {
                backed.computeIfAbsent(word.charAt(idx), (ch) -> new WildcardTrie())
                        .add(word, idx + 1);
            }
        }

        public boolean get(String word, int idx) {
            if (word.length() == idx) {
                return isWord;
            }
            final char lookingAt = word.charAt(idx);
            if (lookingAt == '.') {
                return backed.values()
                        .stream()
                        .anyMatch(it -> it.get(word, idx + 1));
            } else {
                WildcardTrie delegate = backed.get(lookingAt);
                if (delegate == null) {
                    return false;
                } else {
                    return delegate.get(word, idx + 1);
                }
            }
        }
    }
}