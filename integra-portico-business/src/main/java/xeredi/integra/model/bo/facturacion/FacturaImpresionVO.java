package xeredi.integra.model.bo.facturacion;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.facturacion.FacturaCargoVO;
import xeredi.integra.model.vo.facturacion.FacturaImpuestoVO;
import xeredi.integra.model.vo.facturacion.FacturaLineaVO;
import xeredi.integra.model.vo.facturacion.FacturaServicioVO;
import xeredi.integra.model.vo.facturacion.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaImpresionVO.
 */
public final class FacturaImpresionVO {

    /** The fctr. */
    private final transient FacturaVO fctr;

    /** The fctg list. */
    private final transient List<FacturaCargoVO> fctgList;

    /** The fcti list. */
    private final transient List<FacturaImpuestoVO> fctiList;

    /** The fctl list. */
    private final transient List<FacturaLineaVO> fctlList;

    /** The fcts map. */
    private final transient Map<Long, FacturaServicioVO> fctsMap;

    /**
     * The Constructor.
     *
     * @param afctr
     *            the afctr
     * @param afctgList
     *            the afctg list
     * @param afctiList
     *            the afcti list
     * @param afctlList
     *            the afctl list
     * @param afctsMap
     *            the afcts map
     */
    public FacturaImpresionVO(final FacturaVO afctr, final List<FacturaCargoVO> afctgList,
            final List<FacturaImpuestoVO> afctiList, final List<FacturaLineaVO> afctlList,
            final Map<Long, FacturaServicioVO> afctsMap) {
        super();
        fctr = afctr;
        fctgList = afctgList;
        fctiList = afctiList;
        fctlList = afctlList;
        fctsMap = afctsMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the fctr.
     *
     * @return the fctr
     */
    public FacturaVO getFctr() {
        return fctr;
    }

    /**
     * Gets the fctg list.
     *
     * @return the fctg list
     */
    public List<FacturaCargoVO> getFctgList() {
        return fctgList;
    }

    /**
     * Gets the fcti list.
     *
     * @return the fcti list
     */
    public List<FacturaImpuestoVO> getFctiList() {
        return fctiList;
    }

    /**
     * Gets the fctl list.
     *
     * @return the fctl list
     */
    public List<FacturaLineaVO> getFctlList() {
        return fctlList;
    }

    /**
     * Gets the fcts map.
     *
     * @return the fcts map
     */
    public Map<Long, FacturaServicioVO> getFctsMap() {
        return fctsMap;
    }

}
