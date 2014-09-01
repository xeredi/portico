package xeredi.util.tapestry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.ioc.services.PropertyAccess;
import org.apache.tapestry5.ioc.services.PropertyAdapter;
import org.apache.tapestry5.util.AbstractSelectModel;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericSelectModel.
 *
 * @param <T>
 *            the generic type
 */
public final class GenericSelectModel<T> extends AbstractSelectModel implements ValueEncoder<T> {

    /** The label field adapter. */
    private final transient PropertyAdapter labelFieldAdapter;

    /** The id field adapter. */
    private final transient PropertyAdapter idFieldAdapter;

    /** The list. */
    private final transient Collection<T> list;

    /**
     * Instantiates a new generic select model.
     *
     * @param alist
     *            the list
     * @param clazz
     *            the clazz
     * @param labelField
     *            the label field
     * @param idField
     *            the id field
     * @param access
     *            the access
     */
    public GenericSelectModel(final Collection<T> alist, final Class<T> clazz, final String labelField,
            final String idField, final PropertyAccess access) {
        super();

        this.list = alist;
        this.idFieldAdapter = access.getAdapter(clazz).getPropertyAdapter(idField);
        this.labelFieldAdapter = access.getAdapter(clazz).getPropertyAdapter(labelField);
    }

    /**
     * Gets the option groups.
     *
     * @return the option groups
     * @see org.apache.tapestry5.SelectModel#getOptionGroups()
     */
    @Override
    public List<OptionGroupModel> getOptionGroups() {
        return null;
    }

    /**
     * Gets the options.
     *
     * @return the options
     * @see org.apache.tapestry5.SelectModel#getOptions()
     */
    @Override
    public List<OptionModel> getOptions() {
        final List<OptionModel> optionModelList = new ArrayList<>();
        if (this.labelFieldAdapter == null) {
            for (final T obj : this.list) {
                optionModelList.add(new OptionModelImpl(this.nvl(obj)));
            }
        } else {
            for (final T obj : this.list) {
                optionModelList.add(new OptionModelImpl(this.nvl(this.labelFieldAdapter.get(obj)), obj));
            }
        }
        return optionModelList;
    }

    // ValueEncoder functions
    /**
     * To client.
     *
     * @param obj
     *            the obj
     * @return the string
     * @see org.apache.tapestry5.ValueEncoder#toClient(java.lang.Object)
     */
    @Override
    public String toClient(final T obj) {
        String value;

        if (this.idFieldAdapter == null) {
            value = obj + "";
        } else {
            value = this.idFieldAdapter.get(obj) + "";
        }

        return value;
    }

    /**
     * To value.
     *
     * @param string
     *            the string
     * @return the t
     * @see org.apache.tapestry5.ValueEncoder#toValue(java.lang.String)
     */
    @Override
    public T toValue(final String string) {
        if (this.idFieldAdapter == null) {
            for (final T obj : this.list) {
                if (this.nvl(obj).equals(string)) {
                    return obj;
                }
            }
        } else {
            for (final T obj : this.list) {
                if (this.nvl(this.idFieldAdapter.get(obj)).equals(string)) {
                    return obj;
                }
            }
        }
        return null;
    }

    /**
     * Nvl.
     *
     * @param o
     *            the o
     * @return the string
     */
    private String nvl(final Object o) {
        String value;

        if (o == null) {
            value = "";
        } else {
            value = o.toString();
        }

        return value;
    }
}
