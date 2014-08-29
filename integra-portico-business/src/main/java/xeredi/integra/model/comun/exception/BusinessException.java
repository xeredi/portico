package xeredi.integra.model.comun.exception;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.util.GlobalNames;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessException.
 */
public final class BusinessException extends Exception {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6118722522068737576L;

    /** The list. */
    private final List<BusinessExceptionVO> list;

    /**
     * Instantiates a new business exception.
     *
     * @param vo
     *            the vo
     */
    public BusinessException(final BusinessExceptionVO vo) {
        super();

        list = Arrays.asList(new BusinessExceptionVO[] { vo });
    }

    /**
     * Instantiates a new business exception.
     *
     * @param alist
     *            the alist
     */
    public BusinessException(final List<BusinessExceptionVO> alist) {
        super();

        list = alist;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public List<BusinessExceptionVO> getList() {
        return list;
    }

    /**
     * To i18n.
     *
     * @return the list
     */
    public List<String> toI18n(final Locale locale) {
        final ResourceBundle bundle = ResourceBundle.getBundle(GlobalNames.MESSAGES, locale);
        final List<String> messages = new ArrayList<>();

        Preconditions.checkNotNull(bundle);

        for (final BusinessExceptionVO vo : list) {
            final String message = vo.getErrorCode().name() + " - " + bundle.getString(vo.getErrorCode().name());

            Preconditions.checkNotNull(message);

            messages.add(MessageFormat.format(message, vo.getErrorArgs()));
        }

        return messages;
    }

}
