package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.AccionTramiteBO;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteDetailAction.
 */
public final class TramiteDetailAction extends CrudDetailAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8184203973522067742L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /** The enti. */
    @Getter
    private EntidadVO enti;

    /** The trtd list. */
    @Getter
    private List<TramiteTipoDatoVO> trtdList;

    /** The actr list. */
    @Getter
    private List<AccionTramiteVO> actrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TramiteBO trmtBO = new TramiteBO();

        model = trmtBO.select(model.getId(), idioma);

        i18nMap = I18nBO.selectMap(I18nPrefix.trmt, model.getId());

        final EntidadBO entiBO = new EntidadBO();

        enti = entiBO.select(model.getEntiId(), getIdioma());

        final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();
        final TramiteTipoDatoCriterioVO trtdCriterio = new TramiteTipoDatoCriterioVO();

        trtdCriterio.setTrmtId(model.getId());
        trtdCriterio.setIdioma(idioma);

        trtdList = trtdBO.selectList(trtdCriterio);

        final AccionTramiteBO actrBO = new AccionTramiteBO();
        final AccionTramiteCriterioVO actrCriterio = new AccionTramiteCriterioVO();

        actrCriterio.setTrmtId(model.getId());
        actrCriterio.setIdioma(getIdioma());

        actrList = actrBO.selectList(actrCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.trmt;
    }
}
