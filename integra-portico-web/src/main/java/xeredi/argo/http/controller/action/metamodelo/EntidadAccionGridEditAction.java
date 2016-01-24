package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridEditAction.
 */
public final class EntidadAccionGridEditAction extends CrudEditAction<EntidadAccionGridVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5087374811626034724L;

    /** The cdri map. */
    @Getter
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

            final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

            model = enagBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enag, model.getId());
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
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.enag;
    }
}
