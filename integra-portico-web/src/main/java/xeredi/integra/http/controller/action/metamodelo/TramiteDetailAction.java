package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TramiteBO;
import xeredi.integra.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteDetailAction.
 */
public final class TramiteDetailAction extends CrudDetailAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8184203973522067742L;

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

        i18nMap = I18nBO.selectMap(I18nPrefix.trmt, model.getId());

        final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();
        final TramiteTipoDatoCriterioVO trtdCriterio = new TramiteTipoDatoCriterioVO();

        trtdCriterio.setTrmtId(model.getId());
        trtdCriterio.setIdioma(idioma);

        trtdList = trtdBO.selectList(trtdCriterio);

        final EntidadBO entiBO = new EntidadBO();

        enti = entiBO.select(model.getEntiId(), getIdioma());
    }

    /**
     * Gets the trtd list.
     *
     * @return the trtd list
     */
    public List<TramiteTipoDatoVO> getTrtdList() {
        return trtdList;
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public EntidadVO getEnti() {
        return enti;
    }
}
