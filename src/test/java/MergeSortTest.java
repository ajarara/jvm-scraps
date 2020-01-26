import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    @Test
    public void canSortLargeInputs() {
        List<Double> unsorted = Stream.generate(Math::random)
                .limit(500_000)
                .collect(toList());

        List<Double> sorted = MergeSort.sort(unsorted);
        unsorted.sort(Double::compareTo);
        assertThat(sorted)
                .isEqualTo(unsorted);
    }
}