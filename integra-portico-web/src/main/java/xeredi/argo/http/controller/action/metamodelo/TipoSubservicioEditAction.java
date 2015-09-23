package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioEditAction.
 */
public final class TipoSubservicioEditAction extends EntidadEditAction<TipoSubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5529476683109631764L;

    /** The tpdt estado list. */
    private List<LabelValueVO> tpdtEstadoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
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
    public void doLoadDependencies() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

        tpdtCriterio.setTipoElemento(TipoElemento.CR);
        tpdtCriterio.setIdioma(idioma);

        tpdtEstadoList = tpdtBO.selectLabelValues(tpdtCriterio);
    }

    /**
     * Gets the tpdt estado list.
     *
     * @return the tpdt estado list
     */
    public List<LabelValueVO> getTpdtEstadoList() {
        return tpdtEstadoList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpss;
    }
}
