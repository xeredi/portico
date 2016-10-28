package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
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
    @Getter
    private List<LabelValueVO> tpdtNombreList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        if (accion == AccionCodigo.edit) {
            final TipoParametroBO tpprBO = new TipoParametroBO();

            model = tpprBO.select(model.getId(), idioma);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificLoadDependencies() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

        tpdtCriterio.setTipoElemento(TipoElemento.TX);
        tpdtCriterio.setIdioma(idioma);

        tpdtNombreList = tpdtBO.selectLabelValues(tpdtCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tppr;
    }
}
