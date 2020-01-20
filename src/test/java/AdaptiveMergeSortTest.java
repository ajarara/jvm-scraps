import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AdaptiveMergeSortTest {

    @Test
    public void adaptiveMergeSortIsStable() {
        List<Data> data = Arrays.asList(
                new Data(1, 3),
                new Data(2, -1),
                new Data(2, 0),
                new Data(2, 5),
                new Data(1, 1),
                new Data(0, 15)
        );

        Assertions.assertThat(AdaptiveMergeSort.sort(data))
                .isEqualTo(Arrays.asList(
                        new Data(0, 15),
                        new Data(1, 3),
                        new Data(1, 1),
                        new Data(2, -1),
                        new Data(2, 0),
                        new Data(2, 5)
                ));
    }

    private static final class Data implements Comparable<Data> {

        public final int primary;
        public final int secondary;

        Data(final int primary, final int secondary) {
            this.primary = primary;
            this.secondary = secondary;
        }

        @Override
        public int compareTo(@NotNull Data o) {
            return Integer.compare(primary, o.primary);
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Data)) {
                return false;
            }

            Data casted = (Data) other;
            return primary == casted.primary
                    && secondary == casted.secondary;
        }
    }
}