import java.util.*;

public final class Heap<T> {

    private final List<T> list;
    private final Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this(comparator, new ArrayList<>());
    }

    private Heap(Comparator<T> comparator, List<T> list) {
        this.list = list;
        this.comparator = comparator;
    }

    public static <T> void inPlaceSort(List<T> things, Comparator<T> comparator) {
        Heap<T> heap = new Heap<>(comparator, things);
        heap.heapify();
        int heapThreshold = heap.list.size() - 1;
        while (heapThreshold >= 0) {
            heap.list.add(heap.pop(heapThreshold));
            heapThreshold -= 1;
        }
    }

    public void add(T element) {
        list.add(element);
        int currIdx = list.size() - 1;
        if (currIdx == 0) {
            return;
        }
        int parentIdx = (currIdx - 1) / 2;
        while (compares(parentIdx, currIdx)) {
            swap(currIdx, parentIdx);
            if (parentIdx != 0) {
                currIdx = parentIdx;
                parentIdx = (currIdx - 1) / 2;
            } else {
                break;
            }
        }
    }

    public T remove() {
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Remove called on an empty heap!");
        } else if (size == 1) {
            return list.remove(0);
        } else {
            return pop(size - 1);
        }
    }

    public int size() {
        return list.size();
    }

    private void heapify() {
        int heapSize = list.size();
        int heapThreshold = heapSize / 2;

        while (heapThreshold >= 0) {
            siftDown(heapThreshold, heapSize);
            heapThreshold -= 1;
        }
    }

    private T pop(int heapBound) {
        swap(0, heapBound);
        T returned = list.remove(heapBound);
        siftDown(0, heapBound);
        return returned;
    }

    private void siftDown(int toBeSifted, int heapBound) {
        int currIdx = toBeSifted;
        OptionalInt swapIdx = getSwapIndex(currIdx, heapBound);

        while (swapIdx.isPresent()) {
            int swapTarget = swapIdx.getAsInt();
            swap(currIdx, swapTarget);
            currIdx = swapTarget;
            swapIdx = getSwapIndex(currIdx, heapBound);
        }
    }

    private void swap(int idxA, int idxB) {
        T temp = list.get(idxA);
        list.set(idxA, list.get(idxB));
        list.set(idxB, temp);
    }

    private OptionalInt getSwapIndex(int parentIdx, int heapBound) {
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;

        if (leftIdx < heapBound) {
            if (compares(parentIdx, leftIdx)) {
                if (rightIdx < heapBound && compares(leftIdx, rightIdx)) {
                    return OptionalInt.of(rightIdx);
                }
                return OptionalInt.of(leftIdx);
            } else if (rightIdx < heapBound && compares(parentIdx, rightIdx)) {
                return OptionalInt.of(rightIdx);
            }
        }
        return OptionalInt.empty();
    }

    private boolean compares(int greaterIdx, int lesserIdx) {
        return comparator.compare(
                list.get(greaterIdx),
                list.get(lesserIdx)
        ) > 0;
    }
}
