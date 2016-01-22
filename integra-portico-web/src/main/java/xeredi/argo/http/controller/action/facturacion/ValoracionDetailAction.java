package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetailAction.
 */
public final class ValoracionDetailAction extends CrudDetailAction<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8955027989386166332L;

    /** The aspc. */
    private AspectoVO aspc;

    /** The vlrg list. */
    private List<ValoracionCargoVO> vlrgList;

    /** The vlri list. */
    private List<ValoracionImpuestoVO> vlriList;

    /** The tpdt cod exencion. */
    private TipoDatoVO tpdtCodExencion;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        model = vlrcBO.select(model.getId(), getIdioma());
        vlriList = vlrcBO.selectVlriList(model.getId(), getIdioma());
        vlrgList = vlrcBO.selectVlrgList(model.getId(), getIdioma());
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(model.getAspc().getId());
        aspcCriterio.setFechaVigencia(model.getFref());

        aspc = aspcBO.selectObject(aspcCriterio);
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }

    /**
     * Gets the vlrg list.
     *
     * @return the vlrg list
     */
    public List<ValoracionCargoVO> getVlrgList() {
        return vlrgList;
    }

    /**
     * Gets the vlri list.
     *
     * @return the vlri list
     */
    public List<ValoracionImpuestoVO> getVlriList() {
        return vlriList;
    }

    /**
     * Gets the tpdt cod exencion.
     *
     * @return the tpdt cod exencion
     */
    public TipoDatoVO getTpdtCodExencion() {
        return tpdtCodExencion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrc;
    }
}
