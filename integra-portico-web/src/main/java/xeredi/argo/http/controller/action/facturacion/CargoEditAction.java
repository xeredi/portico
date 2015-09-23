package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoTipo;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoEditAction.
 */
public final class CargoEditAction extends CrudEditAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7135315858700353650L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    /** The tipos. */
    private CargoTipo[] tipos;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());

            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setId(model.getId());
            crgoCriterio.setFechaVigencia(model.getFref());
            crgoCriterio.setIdioma(idioma);

            model = crgoBO.selectObject(crgoCriterio);
            i18nMap = I18nBO.selectMap(I18nPrefix.crgv, model.getVersion().getId());
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

        tipos = CargoTipo.values();
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
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the tipos.
     *
     * @return the tipos
     */
    public CargoTipo[] getTipos() {
        return tipos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.crgo;
    }
}
