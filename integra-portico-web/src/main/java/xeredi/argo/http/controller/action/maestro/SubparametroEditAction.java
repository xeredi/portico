package xeredi.argo.http.controller.action.maestro;

import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroEditAction.
 */
public final class SubparametroEditAction extends ItemEditAction<SubparametroVO, TipoSubparametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6767667432126657718L;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getPrmtId());

        enti = TipoSubparametroProxy.select(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(enti.getEnti().getTpprId());

            final ParametroVO prmt = prmtBO.select(model.getPrmtId(), idioma, model.getFref());

            if (prmt.getPrto() != null) {
                model.setPrtoId(prmt.getPrto().getId());
            }
        } else {
            final SubparametroBO itemBO = SubparametroBOFactory.newInstance(model.getEntiId());

            model = itemBO.selectObject(model.getId(), getIdioma(), model.getFref());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadSpecificDependencies() throws ApplicationException {
        if (enti.getEnti().getTpprAsociado().isPuerto()) {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(getSprtId());
            prtoCriterio.setIdioma(getIdioma());

            prtoList = prtoBO.selectList(prtoCriterio);
        }
    }

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }
}