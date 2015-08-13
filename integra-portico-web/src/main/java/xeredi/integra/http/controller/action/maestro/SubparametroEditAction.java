package xeredi.integra.http.controller.action.maestro;

import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.item.ItemEditAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroDetailVO;

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
        Preconditions.checkNotNull(fechaVigencia);
        Preconditions.checkNotNull(model.getPrmtId());

        enti = TipoSubparametroProxy.select(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(enti.getEnti().getTpprId());

            final ParametroVO prmt = prmtBO.select(model.getPrmtId(), idioma, getFechaVigencia());

            if (prmt.getPrto() != null) {
                model.setPrtoId(prmt.getPrto().getId());
            }
        } else {
            final SubparametroBO itemBO = new SubparametroBO();

            model = itemBO.selectObject(model.getId(), getIdioma(), getFechaVigencia());
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
