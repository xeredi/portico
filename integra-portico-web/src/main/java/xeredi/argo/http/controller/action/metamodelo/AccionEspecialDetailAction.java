package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;

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

	@Inject
	private I18nService i18nService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final AccionEspecialBO acesBO = new AccionEspecialBO();

        model = acesBO.select(model.getId(), getIdioma());
        i18nMap = i18nService.selectMap(model);
    }
}
