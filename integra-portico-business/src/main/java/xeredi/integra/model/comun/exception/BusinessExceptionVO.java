package xeredi.integra.model.comun.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessExceptionVO.
 */
public final class BusinessExceptionVO {

    /** The error code. */
    private final ErrorCode errorCode;

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
    public BusinessExceptionVO(final ErrorCode aerrorCode, final Object[] aerrorArgs) {
        super();
        errorCode = aerrorCode;
        errorArgs = aerrorArgs;
    }

    /**
     * Instantiates a new business exception vo.
     *
     * @param aerrorCode
     *            the aerror code
     */
    public BusinessExceptionVO(final ErrorCode aerrorCode) {
        this(aerrorCode, null);
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
    public ErrorCode getErrorCode() {
        return errorCode;
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