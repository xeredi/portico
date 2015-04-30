package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoDetailAction.
 */
public final class EntidadGrupoDatoDetailAction extends CrudDetailAction<EntidadGrupoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5264232903029377024L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        model = engdBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.engd, model.getId());
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }
}
