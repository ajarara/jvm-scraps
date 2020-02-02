import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Scratch {
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
        // Stream.empty().anyMatch()
    }
}
