package xeredi.argo.http.controller.action.maestro;

import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroDetailAction.
 */
public final class ParametroDetailAction extends ItemDetailAction<ParametroVO, TipoParametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6639690925171727021L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        enti = TipoParametroProxy.select(model.getEntiId());

        final ParametroBO itemBO = ParametroBOFactory.newInstance(model.getEntiId());

        model = itemBO.select(model.getId(), idioma, model.getFref());

        if (enti.getEnti().isI18n()) {
            i18nMap = I18nBO.selectMap(I18nPrefix.prvr, model.getVersion().getId());
        }
    }
}
