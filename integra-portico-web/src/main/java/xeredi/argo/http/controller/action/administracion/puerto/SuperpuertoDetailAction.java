package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoDetailAction.
 */
public final class SuperpuertoDetailAction extends CrudDetailAction<SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3768153475557841666L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();

        model = sprtBO.select(model.getId(), idioma);
        i18nMap = I18nBO.selectMap(I18nPrefix.sprt, model.getId());
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public final Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.sprt;
    }
}
