package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoEditAction.
 */
public final class TramiteTipoDatoEditAction extends CrudEditAction<TramiteTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7651037788650883305L;

    /** The entd list. */
    private List<EntidadTipoDatoVO> entdList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getTrmtId());

        switch (accion) {
        case edit:
            Preconditions.checkNotNull(model.getEntd().getTpdt().getId());

            final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();

            model = trtdBO.select(model.getTrmtId(), model.getEntd().getTpdt().getId(), getIdioma());

            break;
        default:
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model.getTrmtId());

        if (accion == ACCION_EDICION.create) {
            final TramiteBO trmtBO = new TramiteBO();

            final TramiteVO trmt = trmtBO.select(model.getTrmtId(), getIdioma());

            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();
            final EntidadTipoDatoCriterioVO entdCriterio = new EntidadTipoDatoCriterioVO();

            entdCriterio.setEntiId(trmt.getEntiId());
            entdCriterio.setIdioma(getIdioma());

            entdList = entdBO.selectList(entdCriterio);
        }
    }

    /**
     * Gets the entd list.
     *
     * @return the entd list
     */
    public List<EntidadTipoDatoVO> getEntdList() {
        return entdList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.trtd;
    }
}
