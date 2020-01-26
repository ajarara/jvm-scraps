import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.reducing;

public class MergeSort {

    public static <T extends Comparable<T>> List<T> sort(List<T> input) {
        return input.stream()
                .map(Collections::singletonList)
                .parallel()
                .reduce(new ArrayList<>(), MergeSort::merge);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        final List<T> out = new ArrayList<>();
        int leftIdx = 0;
        int rightIdx = 0;
        while(leftIdx < left.size() && rightIdx < right.size()) {
            T leftElem = left.get(leftIdx);
            T rightElem = right.get(rightIdx);
            if (leftElem.compareTo(rightElem) <= 0) {
                out.add(leftElem);
                leftIdx++;
            } else {
                out.add(rightElem);
                rightIdx++;
            }
        }
        if (leftIdx == left.size()) {
            out.addAll(right.subList(rightIdx, right.size()));
        } else if (rightIdx == right.size()) {
            out.addAll(left.subList(leftIdx, left.size()));
        } else {
            throw new IllegalStateException("Miscounted");
        }
        return out;
    }
}
