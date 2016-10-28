package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoDetailAction.
 */
@Data
public final class SuperpuertoDetailAction extends CrudDetailAction<SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3768153475557841666L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.sprt;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();

        model = sprtBO.select(model.getId(), idioma);
        i18nMap = I18nBO.selectMap(ClassPrefix.sprt, model.getId());
    }
}
