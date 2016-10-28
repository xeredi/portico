package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

/**
 * Grabación de un Código de Referencia.
 */
@Data
public final class CodigoReferenciaSaveAction extends CrudSaveAction<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8704360630485075850L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.cdrf;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        switch (accion) {
        case create:
            cdrfBO.insert(model, i18nMap);

            break;
        case edit:
            cdrfBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no implementada: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpdtId());
        Preconditions.checkNotNull(i18nMap);

        if (accion == AccionCodigo.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.cdrf_valor, model.getValor());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getValor());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.cdrf_orden, model.getOrden());
        FieldValidator.validateI18n(this, i18nMap);
    }
}
