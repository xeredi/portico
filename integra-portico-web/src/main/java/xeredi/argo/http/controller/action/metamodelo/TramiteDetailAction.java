package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteDetailAction.
 */
@Data
public final class TramiteDetailAction extends CrudDetailAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8184203973522067742L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.trmt;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The enti. */
    private EntidadVO enti;

    /** The trtd list. */
    private List<TramiteTipoDatoVO> trtdList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TramiteBO trmtBO = new TramiteBO();

        model = trmtBO.select(model.getId(), idioma);

        i18nMap = I18nBO.selectMap(ClassPrefix.trmt, model.getId());

        final EntidadBO entiBO = new EntidadBO();

        enti = entiBO.select(model.getEntiId(), getIdioma());

        final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();
        final TramiteTipoDatoCriterioVO trtdCriterio = new TramiteTipoDatoCriterioVO();

        trtdCriterio.setTrmtId(model.getId());
        trtdCriterio.setIdioma(idioma);

        trtdList = trtdBO.selectList(trtdCriterio);
    }
}
