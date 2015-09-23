package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoDetailAction.
 */
public final class EntidadTipoDatoDetailAction extends CrudDetailAction<EntidadTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6085148921599533885L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        model = entdBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.entd, model.getId());
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
        return AccionPrefix.entd;
    }
}
