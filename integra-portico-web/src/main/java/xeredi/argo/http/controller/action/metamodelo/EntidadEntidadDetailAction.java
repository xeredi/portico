package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadDetailAction.
 */
@Data
public final class EntidadEntidadDetailAction extends CrudDetailAction<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6250400972687447880L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.enen;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiPadreId());
        Preconditions.checkNotNull(model.getEntiHija());
        Preconditions.checkNotNull(model.getEntiHija().getId());

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();
        final EntidadEntidadCriterioVO enenCriterioVO = new EntidadEntidadCriterioVO();

        enenCriterioVO.setEntiPadreId(model.getEntiPadreId());
        enenCriterioVO.setEntiHijaId(model.getEntiHija().getId());

        model = enenBO.selectObject(enenCriterioVO);
    }
}
