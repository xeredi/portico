package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
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

}
