package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.seguridad.vo.AccionCodigo;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadEditAction.
 */
public final class EntidadEntidadEditAction extends CrudEditAction<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9070801193229242374L;

    /** The tppr list. */
    @Getter
    private List<TipoSubservicioVO> tpssList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiPadreId());

        if (accion == AccionCodigo.edit) {
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
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.enen;
    }
}
