package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoTipo;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoEditAction.
 */
@Data
public final class CargoEditAction extends CrudEditAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7135315858700353650L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.crgo;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    /** The tipos. */
    @Getter
    private CargoTipo[] tipos;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion != AccionCodigo.create) {
            Preconditions.checkNotNull(model.getId());

            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setId(model.getId());
            crgoCriterio.setFechaVigencia(model.getFref());
            crgoCriterio.setIdioma(idioma);

            model = crgoBO.selectObject(crgoCriterio);
            i18nMap = I18nBO.selectMap(ClassPrefix.crgv, model.getVersion().getId());
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
