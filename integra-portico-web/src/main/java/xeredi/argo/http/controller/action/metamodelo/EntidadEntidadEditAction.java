package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadEditAction.
 */
@Data
public final class EntidadEntidadEditAction extends CrudEditAction<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9070801193229242374L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.enen;

    /** The tppr list. */
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
}
