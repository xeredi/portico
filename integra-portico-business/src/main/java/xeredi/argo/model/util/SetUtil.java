package xeredi.argo.model.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;

import lombok.NonNull;

// TODO: Auto-generated Javadoc
/**
 * The Class SetUtil.
 */
public final class SetUtil {

    /**
     * Instantiates a new sets the util.
     */
    private SetUtil() {
        super();
    }

    /**
     * Divide.
     *
     * @param set
     *            the set
     * @param size
     *            the size
     * @return the list
     */
    public static List<Set<Long>> divide(final @NonNull Collection<Long> set, final int size) {
        Preconditions.checkArgument(size > 0);

        final List<Set<Long>> dividedSet = new ArrayList<>();
        int i = 0;

        for (final Long elem : set) {
            if (dividedSet.isEmpty()) {
                dividedSet.add(new HashSet<>());
            }

            if (dividedSet.get(i).size() >= size) {
                dividedSet.add(new HashSet<>());

                i++;
            }

            dividedSet.get(i).add(elem);
        }

        return dividedSet;
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final int size = 1234;
        final int segmentSize = 500;

        final Set<Long> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            set.add((long) i);
        }

        final List<Set<Long>> setDivided = divide(set, segmentSize);

        final int expectedSize = Math.floorDiv(size, segmentSize) + (Math.floorMod(size, segmentSize) > 0 ? 1 : 0);

        Preconditions.checkArgument(setDivided.size() == expectedSize);

        for (final Set<Long> segment : setDivided) {
            Preconditions.checkArgument(segment.size() <= segmentSize);
        }
    }
}
