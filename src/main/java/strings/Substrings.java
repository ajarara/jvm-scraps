package strings;

import java.util.*;
import java.util.stream.Stream;

public final class Substrings {

    public static List<String> enumerate(String str) {
        final List<String> out = new ArrayList<>();
        final PriorityQueue<Integer> queue = null;
        queue.offer(5);

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                out.add(str.substring(i, j));
            }
        }
        return out;
    }
}
