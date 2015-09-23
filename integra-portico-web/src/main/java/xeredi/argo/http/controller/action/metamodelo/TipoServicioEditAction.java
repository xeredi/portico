package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioEditAction.
 */
public final class TipoServicioEditAction extends EntidadEditAction<TipoServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7056943059440927593L;

    /** The tpdt estado list. */
    private List<LabelValueVO> tpdtEstadoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.edit) {
            final TipoServicioBO tpsrBO = new TipoServicioBO();

            model = tpsrBO.select(model.getId(), getIdioma());
        } else {
            model = new TipoServicioVO();
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
        return AccionPrefix.tpsr;
    }

}
