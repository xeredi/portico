package xeredi.integra.http.controller.action.maestro;

import java.util.Map;

import xeredi.integra.http.controller.action.item.ItemDetailAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroDetailAction.
 */
public final class ParametroDetailAction extends ItemDetailAction<ParametroVO, TipoParametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6639690925171727021L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final ParametroBO itemBO = ParametroBOFactory.newInstance(model.getEntiId());

        model = itemBO.select(model.getId(), idioma, fechaVigencia);
        enti = TipoParametroProxy.select(model.getEntiId());

        if (enti.getEnti().isI18n()) {
            i18nMap = I18nBO.selectMap(I18nPrefix.prvr, model.getVersion().getId());
        }
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
