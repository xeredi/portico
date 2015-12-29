package xeredi.argo.model.facturacion.vo;

import java.util.List;

import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * Agrupación de valoraciones que componen una factura.
 */
public final class ValoracionGrupoVO {

    /** The grupo id. */
    private Long vgrpId;

    /** The pagador. */
    private ParametroVO pagador;

    /** The vlrc list. */
    private List<ValoracionVO> vlrcList;

    /**
     * Gets the grupo id.
     *
     * @return the grupo id
     */
    public Long getVgrpId() {
        return vgrpId;
    }

    /**
     * Sets the grupo id.
     *
     * @param value the new grupo id
     */
    public void setVgrpId(Long value) {
        this.vgrpId = value;
    }

    /**
     * Gets the pagador.
     *
     * @return the pagador
     */
    public ParametroVO getPagador() {
        return pagador;
    }

    /**
     * Sets the pagador.
     *
     * @param value the new pagador
     */
    public void setPagador(ParametroVO value) {
        this.pagador = value;
    }

    /**
     * Gets the vlrc list.
     *
     * @return the vlrc list
     */
    public List<ValoracionVO> getVlrcList() {
        return vlrcList;
    }

    /**
     * Sets the vlrc list.
     *
     * @param value the new vlrc list
     */
    public void setVlrcList(List<ValoracionVO> value) {
        this.vlrcList = value;
    }


}
