package xeredi.integra.model.bo.util.pdf;

import java.io.OutputStream;
import java.util.Locale;

import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.bo.facturacion.FacturaImpresionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaPdf.
 */
public final class FacturaPdf extends BasePdf {

    /**
     * Instantiates a new factura pdf.
     *
     * @param alocale
     *            the alocale
     */
    public FacturaPdf(final Locale alocale) {
        super(alocale);
    }

    /**
     * Imprimir.
     *
     * @param vo
     *            the vo
     * @param os
     *            the os
     * @throws DRException
     *             the DR exception
     */
    public void imprimir(final FacturaImpresionVO vo, final OutputStream os) throws DRException {
        Preconditions.checkNotNull(vo);
        Preconditions.checkNotNull(os);

    }
}
