package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadAccionBO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionVO;

// TODO: Auto-generated Javadoc
/**
 * Edición de una Acción Específica de Entidad.
 */
public final class EntidadAccionEditAction extends CrudEditAction<EntidadAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9052582463315074870L;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getEntiId());
        } else {
            Preconditions.checkNotNull(model.getId());

            final EntidadAccionBO enacBO = new EntidadAccionBO();

            model = enacBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enac, model.getId());
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
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }
}
