package xeredi.integra.model.bo.util.pdf;

import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.bo.facturacion.ValoracionImpresionVO;

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
     * @throws DRException
     *             the DR exception
     */
    public void imprimir(final List<ValoracionImpresionVO> vos, final OutputStream os) throws DRException {
        Preconditions.checkNotNull(vos);
        Preconditions.checkArgument(!vos.isEmpty());
        Preconditions.checkNotNull(os);
    }

}
