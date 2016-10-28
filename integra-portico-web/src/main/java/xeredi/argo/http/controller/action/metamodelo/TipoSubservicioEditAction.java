package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioEditAction.
 */
public final class TipoSubservicioEditAction extends EntidadEditAction<TipoSubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5529476683109631764L;

    /** The tpdt estado list. */
    @Getter
    private List<LabelValueVO> tpdtEstadoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            Preconditions.checkNotNull(model.getTpsrId());
        } else {
            final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

            model = tpssBO.select(model.getId(), idioma);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificLoadDependencies() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

        tpdtCriterio.setTipoElemento(TipoElemento.CR);
        tpdtCriterio.setIdioma(idioma);

        tpdtEstadoList = tpdtBO.selectLabelValues(tpdtCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpss;
    }
}
