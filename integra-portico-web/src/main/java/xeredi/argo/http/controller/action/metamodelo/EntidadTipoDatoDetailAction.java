package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        model = entdBO.select(model.getId(), getIdioma());
        i18nMap = I18nUtilBO.selectMap(model);
    }
}
