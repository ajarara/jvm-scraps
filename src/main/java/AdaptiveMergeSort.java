import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AdaptiveMergeSort {

    public static <T extends Comparable<T>> List<T> sort(List<T> input) {
        if (input == null || input.size() < 2) {
            return input;
        }

        return mergeRuns(computeRuns(input));
    }

    private static <T extends Comparable<T>> List<T> mergeRuns(List<List<T>> runs) {
        Queue<List<T>> queue = new ArrayDeque<>(runs);

        while (queue.size() > 1) {
            queue.add(merge(queue.remove(), queue.remove()));
        }
        return queue.remove();
    }

    private static <T extends Comparable<T>> List<List<T>> computeRuns(List<T> input) {
        final List<List<T>> out = new ArrayList<>();
        List<T> curr = new ArrayList<>();
        curr.add(input.get(0));
        for (T elem : input.subList(1, input.size())) {
            boolean preservesOrdering = curr.get(curr.size() - 1).compareTo(elem) <= 0;
            if (preservesOrdering) {
                curr.add(elem);
            } else {
                out.add(curr);
                curr = new ArrayList<>();
                curr.add(elem);
            }
        }
        out.add(curr);
        return out;
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> out = new ArrayList<>();
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
        } else {
            out.addAll(left.subList(leftIdx, left.size()));
        }
        return out;
    }
}
