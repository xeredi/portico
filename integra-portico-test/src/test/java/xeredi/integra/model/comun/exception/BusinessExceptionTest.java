package xeredi.integra.model.comun.exception;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessExceptionTest.
 */
public final class BusinessExceptionTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(BusinessExceptionTest.class);

    /**
     * Test.
     */
    @Test
    public void test() {
        final BusinessExceptionVO exceptionVO = new BusinessExceptionVO(ErrorCode.E00000,
                new Object[] { "Error de prueba" });

        try {
            throw new BusinessException(exceptionVO);
        } catch (final BusinessException ex) {
            LOG.info(ex.toI18n(Locale.getDefault()));
        }

        try {
            final List<BusinessExceptionVO> list = Arrays.asList(new BusinessExceptionVO[] { exceptionVO, exceptionVO,
                    exceptionVO });

            throw new BusinessException(list);
        } catch (final BusinessException ex) {
            LOG.info(ex.toI18n(Locale.getDefault()));
        }
    }
}
