package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoEditAction.
 */
public final class EntidadGrupoDatoEditAction extends CrudEditAction<EntidadGrupoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1801325748314233476L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());

            final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

            model = engdBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.engd, model.getId());
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
        return AccionPrefix.engd;
    }
}
