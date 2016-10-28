package xeredi.argo.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

/**
 * Edición de un Código de Referencia.
 */
@Data
public final class CodigoReferenciaEditAction extends CrudEditAction<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2714107460618528962L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.cdrf;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            Preconditions.checkNotNull(model.getTpdtId());

            i18nMap = new HashMap<>();
        } else {
            Preconditions.checkNotNull(model.getId());

            final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

            model = cdrfBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(ClassPrefix.cdrf, model.getId());
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
