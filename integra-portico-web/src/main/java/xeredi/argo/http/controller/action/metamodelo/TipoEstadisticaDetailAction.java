package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.argo.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoEstadisticaDetailAction extends EntidadDetailAction<TipoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8074035967447249323L;

    /** The cmag list. */
    private List<CampoAgregacionVO> cmagList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        model = tpesBO.select(model.getId(), idioma);

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();
        final CampoAgregacionCriterioVO cmagCriterio = new CampoAgregacionCriterioVO();

        cmagCriterio.setTpesId(model.getId());
        cmagCriterio.setIdioma(idioma);

        cmagList = cmagBO.selectList(cmagCriterio);
    }
}
