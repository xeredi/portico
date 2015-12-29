package xeredi.argo.model.facturacion.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionGrupoCriterioVO.
 */
public final class ValoracionGrupoCriterioVO extends BaseCriterioVO {

    /**
     * The Enum GrupoTipo.
     */
    enum GrupoTipo {

        /** The p. */
        P,
        /** The t. */
        T,
        /** The s. */
        S;
    }

    /** The grupo tipo. */
    private GrupoTipo grupoTipo;

    /** The prto. */
    private PuertoVO prto;

    /** The pagador. */
    private ParametroVO pagador;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The srvc. */
    private ServicioVO srvc;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /**
     * Gets the grupo tipo.
     *
     * @return the grupo tipo
     */
    public GrupoTipo getGrupoTipo() {
        return grupoTipo;
    }

    /**
     * Sets the grupo tipo.
     *
     * @param value
     *            the new grupo tipo
     */
    public void setGrupoTipo(GrupoTipo value) {
        this.grupoTipo = value;
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
     * @param value
     *            the new pagador
     */
    public void setPagador(ParametroVO value) {
        this.pagador = value;
    }

    /**
     * Gets the tpsr.
     *
     * @return the tpsr
     */
    public TipoServicioVO getTpsr() {
        return tpsr;
    }

    /**
     * Sets the tpsr.
     *
     * @param value
     *            the new tpsr
     */
    public void setTpsr(TipoServicioVO value) {
        this.tpsr = value;
    }

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the new srvc
     */
    public void setSrvc(ServicioVO value) {
        this.srvc = value;
    }

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    public ValoracionVO getVlrc() {
        return vlrc;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the new vlrc
     */
    public void setVlrc(ValoracionVO value) {
        this.vlrc = value;
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(PuertoVO value) {
        this.prto = value;
    }

}
