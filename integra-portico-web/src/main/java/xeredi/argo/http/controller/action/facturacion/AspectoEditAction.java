package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoEditAction.
 */
public final class AspectoEditAction extends CrudEditAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6065040172880726006L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The enti list. */
    private List<LabelValueVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());

            final AspectoBO aspcBO = new AspectoBO();
            final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

            aspcCriterio.setId(model.getId());
            aspcCriterio.setFechaVigencia(model.getFref());
            aspcCriterio.setIdioma(idioma);

            model = aspcBO.selectObject(aspcCriterio);
            i18nMap = I18nBO.selectMap(I18nPrefix.aspv, model.getVersion().getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            tpsrList = TipoServicioProxy.selectLabelValues();
        }
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
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
        return AccionPrefix.aspc;
    }
}