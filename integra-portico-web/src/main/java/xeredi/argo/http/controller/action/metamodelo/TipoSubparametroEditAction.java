package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroEditAction.
 */
@Data
public final class TipoSubparametroEditAction extends EntidadEditAction<TipoSubparametroVO> {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7770071461552035741L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpsp;

    /** The tppr list. */
    private List<LabelValueVO> tpprList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
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
    public void doSpecificLoadDependencies() throws ApplicationException {
        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

        entiCriterioVO.setTipo(TipoEntidad.P);
        entiCriterioVO.setIdioma(idioma);

        tpprList = entiBO.selectLabelValues(entiCriterioVO);
    }
}
