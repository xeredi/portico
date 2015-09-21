package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadEditAction.
 */
public final class EntidadEntidadEditAction extends CrudEditAction<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9070801193229242374L;

    /** The tppr list. */
    private List<TipoSubservicioVO> tpssList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiPadreId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getEntiHija());
            Preconditions.checkNotNull(model.getEntiHija().getId());

            final EntidadEntidadBO enenBO = new EntidadEntidadBO();
            final EntidadEntidadCriterioVO enenCriterioVO = new EntidadEntidadCriterioVO();

            enenCriterioVO.setEntiPadreId(model.getEntiPadreId());
            enenCriterioVO.setEntiHijaId(model.getEntiHija().getId());

            model = enenBO.selectObject(enenCriterioVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final TipoSubservicioCriterioVO tpssCriterio = new TipoSubservicioCriterioVO();

        // FIXME Hay que buscar por el tipo de servicio, no por la entidad padre
        tpssCriterio.setIdioma(idioma);
        tpssCriterio.setTpsrId(model.getEntiPadreId());

        tpssList = tpssBO.selectList(tpssCriterio);
    }

    /**
     * Gets the tpss list.
     *
     * @return the tpss list
     */
    public List<TipoSubservicioVO> getTpssList() {
        return tpssList;
    }
}
