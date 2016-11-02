package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoDetailAction.
 */
@Data
public final class PuertoDetailAction extends CrudDetailAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8390167251326279336L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final PuertoBO prtoBO = new PuertoBO();

        model = prtoBO.select(model.getId(), idioma);
        i18nMap = I18nUtilBO.selectMap(model);
    }
}
