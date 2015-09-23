package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroEditAction.
 */
public final class TipoSubparametroEditAction extends EntidadEditAction<TipoSubparametroVO> {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7770071461552035741L;

    /** The tppr list. */
    private List<LabelValueVO> tpprList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getTpprId());
        } else {
            Preconditions.checkNotNull(model.getId());

            final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

            model = tpspBO.select(model.getId(), getIdioma());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

        entiCriterioVO.setTipo(TipoEntidad.P);
        entiCriterioVO.setIdioma(idioma);

        tpprList = entiBO.selectLabelValues(entiCriterioVO);
    }

    /**
     * Gets the tppr list.
     *
     * @return the tppr list
     */
    public List<LabelValueVO> getTpprList() {
        return tpprList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpsp;
    }
}
