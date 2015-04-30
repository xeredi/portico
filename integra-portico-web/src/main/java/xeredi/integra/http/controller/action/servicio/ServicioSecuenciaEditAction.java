package xeredi.integra.http.controller.action.servicio;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaEditAction.
 */
public final class ServicioSecuenciaEditAction extends CrudEditAction<ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7265649887754786022L;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /** The tpsr list. */
    private List<TipoServicioVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getPrto());
            Preconditions.checkNotNull(model.getPrto().getId());
            Preconditions.checkNotNull(model.getTpsr());
            Preconditions.checkNotNull(model.getTpsr().getId());
            Preconditions.checkNotNull(model.getAnno());

            final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();
            final ServicioSecuenciaCriterioVO srscCriterio = new ServicioSecuenciaCriterioVO();

            srscCriterio.setPrtoId(model.getPrto().getId());
            srscCriterio.setTpsrId(model.getTpsr().getId());
            srscCriterio.setAnno(model.getAnno());
            srscCriterio.setIdioma(getIdioma());

            model = srscBO.select(srscCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());
        prtoCriterio.setSprtId(getSprtId());

        prtoList = prtoBO.selectList(prtoCriterio);

        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

        tpsrCriterio.setIdioma(getIdioma());

        tpsrList = tpsrBO.selectList(tpsrCriterio);
    }

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<TipoServicioVO> getTpsrList() {
        return tpsrList;
    }
}
