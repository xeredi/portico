package xeredi.integra.model.bo.facturacion;

import java.util.List;
import java.util.Map;

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
    public FacturaImpresionVO(FacturaVO afctr, List<FacturaCargoVO> afctgList, List<FacturaImpuestoVO> afctiList,
            List<FacturaLineaVO> afctlList, Map<Long, FacturaServicioVO> afctsMap) {
        super();
        this.fctr = afctr;
        this.fctgList = afctgList;
        this.fctiList = afctiList;
        this.fctlList = afctlList;
        this.fctsMap = afctsMap;
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
