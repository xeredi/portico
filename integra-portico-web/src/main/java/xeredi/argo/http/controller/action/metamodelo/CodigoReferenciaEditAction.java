package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

/**
 * Edición de un Código de Referencia.
 */
public final class CodigoReferenciaEditAction extends CrudEditAction<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2714107460618528962L;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getTpdtId());
        } else {
            Preconditions.checkNotNull(model.getId());

            final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

            model = cdrfBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(I18nPrefix.cdrf, model.getId());
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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.cdrf;
    }
}
