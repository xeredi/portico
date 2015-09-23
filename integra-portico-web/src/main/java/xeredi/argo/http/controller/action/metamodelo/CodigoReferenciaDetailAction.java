package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Visualización de un Código de Referencia.
 */
public final class CodigoReferenciaDetailAction extends CrudDetailAction<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2272224842467117453L;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        model = cdrfBO.select(model.getId(), idioma);
        i18nMap = I18nBO.selectMap(I18nPrefix.cdrf, model.getId());
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
