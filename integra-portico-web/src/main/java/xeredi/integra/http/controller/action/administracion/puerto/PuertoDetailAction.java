package xeredi.integra.http.controller.action.administracion.puerto;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.PuertoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoDetailAction.
 */
public final class PuertoDetailAction extends CrudDetailAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8390167251326279336L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final PuertoBO prtoBO = new PuertoBO();

        model = prtoBO.select(model.getId(), idioma);
        i18nMap = I18nBO.selectMap(I18nPrefix.prto, model.getId());
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public final Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }
}
