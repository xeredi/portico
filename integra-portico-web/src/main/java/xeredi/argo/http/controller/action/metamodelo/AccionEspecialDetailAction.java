package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialDetailAction.
 */
public final class AccionEspecialDetailAction extends CrudDetailAction<AccionEspecialVO> {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1040277417429457339L;
	/** The i18n map. */

    @Getter
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionEspecialBO acesBO = new AccionEspecialBO();

        model = acesBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.aces, model.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.aces;
    }

}
