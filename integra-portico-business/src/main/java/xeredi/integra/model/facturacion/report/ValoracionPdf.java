package xeredi.integra.model.facturacion.report;

import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.report.BasePdf;
import xeredi.integra.model.facturacion.bo.ValoracionImpresionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionPdf.
 */
public final class ValoracionPdf extends BasePdf {

    /**
     * The Constructor.
     *
     * @param alocale
     *            the alocale
     */
    public ValoracionPdf(final Locale alocale) {
        super(alocale);
    }

    /**
     * Imprimir.
     *
     * @param vos
     *            the vos
     * @param os
     *            the os
     * @throws InternalErrorException
     *             the internal error exception
     */
    public void imprimir(final List<ValoracionImpresionVO> vos, final OutputStream os) throws InternalErrorException {
        Preconditions.checkNotNull(vos);
        Preconditions.checkArgument(!vos.isEmpty());
        Preconditions.checkNotNull(os);
    }

}
