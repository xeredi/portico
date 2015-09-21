package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroEditAction.
 */
public final class TipoParametroEditAction extends EntidadEditAction<TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8635600431187631918L;

    /** The tpdt nombre list. */
    private List<LabelValueVO> tpdtNombreList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.edit) {
            final TipoParametroBO tpprBO = new TipoParametroBO();

            model = tpprBO.select(model.getId(), idioma);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

        tpdtCriterio.setTipoElemento(TipoElemento.TX);
        tpdtCriterio.setIdioma(idioma);

        tpdtNombreList = tpdtBO.selectLabelValues(tpdtCriterio);
    }

    /**
     * Gets the tpdt nombre list.
     *
     * @return the tpdt nombre list
     */
    public List<LabelValueVO> getTpdtNombreList() {
        return tpdtNombreList;
    }
}
