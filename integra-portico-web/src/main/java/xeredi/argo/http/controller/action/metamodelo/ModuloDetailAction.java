package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.ModuloBO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloDetailAction.
 */
@Data
public final class ModuloDetailAction extends CrudDetailAction<ModuloVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 696320810765547190L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.mdlo;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ModuloBO mdloBO = new ModuloBO();
        final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

        mdloCriterio.setId(model.getId());

        model = mdloBO.selectObject(mdloCriterio);
        i18nMap = I18nBO.selectMap(ClassPrefix.mdlo, model.getId());
    }
}
