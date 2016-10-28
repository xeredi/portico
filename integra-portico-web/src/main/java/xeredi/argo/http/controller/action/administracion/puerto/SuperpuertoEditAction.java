package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoEditAction.
 */
@Data
public final class SuperpuertoEditAction extends CrudEditAction<SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2952897387558260349L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.sprt;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.edit) {
            final SuperpuertoBO sprtBO = new SuperpuertoBO();

            model = sprtBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(ClassPrefix.sprt, model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }
}
