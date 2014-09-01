package xeredi.util.tapestry;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.util.AbstractSelectModel;

// TODO: Auto-generated Javadoc
/**
 * The Class LabelValueSelectModel.
 */
public final class LabelValueSelectModel extends AbstractSelectModel implements
ValueEncoder<LabelValueVO> {

    /** The list. */
    private final transient List<LabelValueVO> list;

    /**
     * Instantiates a new label value select model.
     * 
     * @param alist
     *            the list
     */
    public LabelValueSelectModel(final List<LabelValueVO> alist) {
        super();

        list = alist;
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

        for (final LabelValueVO obj : list) {
            optionModelList.add(new OptionModelImpl(obj.getLabel(), obj.getValue()));
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
    public String toClient(final LabelValueVO obj) {
        return obj.getValue().toString();
    }

    /**
     * To value.
     * 
     * @param string
     *            the string
     * @return the label value vo
     * @see org.apache.tapestry5.ValueEncoder#toValue(java.lang.String)
     */
    @Override
    public LabelValueVO toValue(final String string) {
        for (final LabelValueVO obj : list) {
            if (string.equals(obj.getValue().toString())) {
                return obj;
            }
        }

        return null;
    }
}
