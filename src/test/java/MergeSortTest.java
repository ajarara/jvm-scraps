import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    @Test
    public void canSortLargeInputs() {
        List<Double> unsorted = Stream.generate(Math::random)
                .limit(10)
                .collect(toList());
        int b = 3;
        for (; b < 4; b++) {
            System.out.println(b);
        }

        List<Double> sorted = MergeSort.sort(unsorted);
        unsorted.sort(Double::compareTo);
        assertThat(sorted)
                .isEqualTo(unsorted);
    }
}