package xeredi.integra.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEditAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class EntidadEditAction<T extends EntidadVO> extends CrudEditAction<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3928988946180134293L;

    /** The i18n map. */
    protected Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            i18nMap = new HashMap<String, I18nVO>();
        } else {
            Preconditions.checkNotNull(model.getId());

            i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());
        }

        doSpecificEdit();

    }

    /**
     * Do specific edit.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificEdit() throws ApplicationException;

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public final Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }
}