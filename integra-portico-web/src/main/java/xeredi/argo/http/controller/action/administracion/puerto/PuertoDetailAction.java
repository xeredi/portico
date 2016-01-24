package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoDetailAction.
 */
public final class PuertoDetailAction extends CrudDetailAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8390167251326279336L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final PuertoBO prtoBO = new PuertoBO();

        model = prtoBO.select(model.getId(), idioma);
        i18nMap = I18nBO.selectMap(I18nPrefix.prto, model.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.prto;
    }
}
