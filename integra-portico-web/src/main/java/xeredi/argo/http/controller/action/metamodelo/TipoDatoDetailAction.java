package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

import com.google.common.base.Preconditions;

/**
 * The Class TipoDatoDetailAction.
 */
public final class TipoDatoDetailAction extends CrudDetailAction<TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6843746887292732660L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        model = tpdtBO.select(model.getId(), idioma);
        i18nMap = I18nBO.selectMap(I18nPrefix.tpdt, model.getId());
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }
}
