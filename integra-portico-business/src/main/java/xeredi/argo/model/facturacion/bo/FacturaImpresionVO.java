package xeredi.argo.model.facturacion.bo;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NonNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaImpresionVO.
 */
@Data
public final class FacturaImpresionVO {

    /** The Constant FILENAME_FORMAT. */
    private static final String FILENAME_FORMAT = "{0}-{1}-{2}";

    /** The fctr. */
    private final transient FacturaVO fctr;

    /** The fctg list. */
    private final transient List<ValoracionCargoVO> vlrgList;

    /** The fcti list. */
    private final transient List<ValoracionImpuestoVO> vlriList;

    /** The fctl list. */
    private final transient List<ValoracionLineaVO> vlrlList;

    /** The fcts map. */
    private final transient Map<Long, ValoracionVO> vlrcMap;

    /**
     * The Constructor.
     *
     * @param afctr            the afctr
     * @param avlrgList the avlrg list
     * @param avlriList the avlri list
     * @param avlrlList the avlrl list
     * @param avlrcMap the avlrc map
     */
    public FacturaImpresionVO(@NonNull final FacturaVO afctr, @NonNull final List<ValoracionCargoVO> avlrgList,
            @NonNull final List<ValoracionImpuestoVO> avlriList, @NonNull final List<ValoracionLineaVO> avlrlList,
            @NonNull final Map<Long, ValoracionVO> avlrcMap) {
        super();

        Preconditions.checkArgument(!avlrgList.isEmpty());
        Preconditions.checkArgument(!avlriList.isEmpty());
        Preconditions.checkArgument(!avlrlList.isEmpty());
        Preconditions.checkArgument(!avlrcMap.isEmpty());

        fctr = afctr;
        vlrgList = avlrgList;
        vlriList = avlriList;
        vlrlList = avlrlList;
        vlrcMap = avlrcMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public String getFilename() {
        return fctr.getFcsr().getSerie() + "-" + fctr.getFcsr().getAnio() + "-" + fctr.getNumero();
    }
}
