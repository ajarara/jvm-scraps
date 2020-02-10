import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Scratch {

    @Test
    public void stringReverse() {
        List<Character> chars = "".chars()
                .mapToObj(it -> (char) it)
                .collect(Collectors.toList());
        Collections.reverse(chars);

    }
    @Test
    public void toListReturnsMutableList() {
        List<Boolean> booleans = IntStream.range(0, 10)
                .mapToObj(unused -> false)
                .collect(Collectors.toList());
        booleans.set(0, true);
        assert booleans.get(0);
    }

    @Test
    public void streamUnderstanding() {
        Map<Integer, Long> count = "yes".chars()
                .boxed()
                .collect(Collectors.groupingBy(it -> it, Collectors.counting()));
        assert count.get((int) 'y').equals(1L);
    }

    @Test
    public void computeUnderstanding() {
        String str = "yyes";
        final Map<Character, Integer> out = new HashMap<>();
        for (char ch : str.toCharArray()) {
            out.compute(ch,
                    (unused, count) -> count == null ? 1 : count + 1
            );
        }
        assert out.get('y').equals(2);
    }

}
