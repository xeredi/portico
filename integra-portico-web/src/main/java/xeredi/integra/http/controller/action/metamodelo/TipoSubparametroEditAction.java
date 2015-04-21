package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

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
        Preconditions.checkNotNull(model.getTpprId());

        if (accion == ACCION_EDICION.edit) {
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
}
