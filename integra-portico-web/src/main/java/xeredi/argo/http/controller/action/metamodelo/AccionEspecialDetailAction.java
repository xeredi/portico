package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEspecialDetailAction extends CrudDetailAction<AccionEspecialVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1040277417429457339L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final AccionEspecialBO acesBO = new AccionEspecialBO();

        model = acesBO.select(model.getId(), getIdioma());
        i18nMap = I18nUtilBO.selectMap(model);
    }
}
