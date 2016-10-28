package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionFilterAction.
 */
public final class ValoracionFilterAction extends GridFilterAction<ValoracionCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3391977535580636697L;

    /** The tpdt cod exencion. */
    @Getter
    private TipoDatoVO tpdtCodExencion;

    /** The tpsr list. */
    @Getter
    private List<LabelValueVO> tpsrList;

    /** The prto list. */
    @Getter
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());

        prtoList = prtoBO.selectList(prtoCriterio);
        tpsrList = TipoServicioProxy.selectLabelValues();
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrc;
    }
}
