package xeredi.util.pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ScrollableList.
 *
 * @param <E>
 *            the element type
 */
public final class ScrollableList<E> {
    /** The list. */
    private final transient List<E> list;

    /** The offset. */
    private final transient int offset;

    /** The limit. */
    private final transient int limit;

    /** The criterio. */
    private final transient Criterio criterio;

    /**
     * Instantiates a new scrollable list.
     *
     * @param alist
     *            the alist
     * @param aoffset
     *            the aoffset
     * @param alimit
     *            the alimit
     * @param acriterio
     *            the acriterio
     */
    public ScrollableList(final List<E> alist, final int aoffset, final int alimit, final Criterio acriterio) {
        super();
        this.list = alist;
        this.offset = aoffset;
        this.limit = alimit;
        this.criterio = acriterio;
    }

    /**
     * Instantiates a new scrollable list.
     *
     * @param alist
     *            the alist
     * @param aoffset
     *            the aoffset
     * @param alimit
     *            the alimit
     */
    public ScrollableList(final List<E> alist, final int aoffset, final int alimit) {
        this(alist, aoffset, alimit, null);
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, null, true);
    }

    /**
     * Checks if is checks for next.
     *
     * @return true, if is checks for next
     */
    public boolean isHasNext() {
        return limit <= list.size();
    }

    /**
     * Checks if is checks for previous.
     *
     * @return true, if is checks for previous
     */
    public boolean isHasPrevious() {
        return offset > 1;
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public List<E> getList() {
        return this.list;
    }

    /**
     * Gets the offset.
     *
     * @return the offset
     */
    public int getOffset() {
        return this.offset;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public int getLimit() {
        return this.limit;
    }

}
