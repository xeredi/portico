package xeredi.integra.http.controller.action.administracion.puerto;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoEditAction.
 */
public final class SuperpuertoEditAction extends CrudEditAction<SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2952897387558260349L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.edit) {
            final SuperpuertoBO sprtBO = new SuperpuertoBO();

            model = sprtBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(I18nPrefix.sprt, model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
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
