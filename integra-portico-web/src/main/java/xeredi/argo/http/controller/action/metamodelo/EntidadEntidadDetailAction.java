package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadDetailAction.
 */
public final class EntidadEntidadDetailAction extends CrudDetailAction<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6250400972687447880L;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.enen;
    }
}
