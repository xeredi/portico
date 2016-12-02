package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.CargoTipo;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoEditAction.
 */
@Data
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
        if (accion != AccionCodigo.create) {
            final CargoBO crgoBO = new CargoBO();

            model = crgoBO.select(model.getId(), model.getFref(), getIdioma());
            i18nMap = I18nUtilBO.selectMap(model);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            tpsrList = TipoServicioProxy.selectLabelValues();
        }

        tipos = CargoTipo.values();
    }
}
