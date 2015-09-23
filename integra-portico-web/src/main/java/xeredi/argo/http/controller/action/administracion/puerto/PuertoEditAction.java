package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.List;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoEditAction.
 */
public final class PuertoEditAction extends CrudEditAction<PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2800418654791205407L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The sprt list. */
    private List<SuperpuertoVO> sprtList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final PuertoBO prtoBO = new PuertoBO();

            model = prtoBO.select(model.getId(), idioma);
            i18nMap = I18nBO.selectMap(I18nPrefix.prto, model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtCriterio.setIdioma(idioma);

        sprtList = sprtBO.selectList(sprtCriterio);
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public final Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Gets the sprt list.
     *
     * @return the sprt list
     */
    public final List<SuperpuertoVO> getSprtList() {
        return sprtList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.prto;
    }
}
