package xeredi.integra.model.comun.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessExceptionVO.
 */
public final class BusinessExceptionVO {

    /** The error code. */
    private final MessageI18nKey key;

    /** The error args. */
    private final Object[] errorArgs;

    /**
     * Instantiates a new business exception vo.
     *
     * @param aerrorCode
     *            the aerror code
     * @param aerrorArgs
     *            the aerror args
     */
    public BusinessExceptionVO(final MessageI18nKey akey, final Object[] aerrorArgs) {
        super();

        Preconditions.checkNotNull(akey);

        key = akey;
        errorArgs = aerrorArgs;
    }

    /**
     * Instantiates a new business exception vo.
     *
     * @param aerrorCode
     *            the aerror code
     */
    public BusinessExceptionVO(final MessageI18nKey akey) {
        this(akey, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public MessageI18nKey getKey() {
        return key;
    }

    /**
     * Gets the error args.
     *
     * @return the error args
     */
    public Object[] getErrorArgs() {
        return errorArgs;
    }

}
