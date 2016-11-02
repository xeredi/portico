package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.ModuloBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloEditAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ModuloEditAction extends CrudEditAction<ModuloVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1589089304159063576L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            model = new ModuloVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final ModuloBO mdloBO = new ModuloBO();
            final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

            mdloCriterio.setId(model.getId());

            model = mdloBO.selectObject(mdloCriterio);
            i18nMap = I18nUtilBO.selectMap(model);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }
}
