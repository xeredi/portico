package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoDetailAction.
 */
@Data
public final class CargoDetailAction extends CrudDetailAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 731400411604425450L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The rgla list. */
    private List<ReglaVO> rglaList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final CargoBO crgoBO = new CargoBO();

        model = crgoBO.select(model.getId(), model.getFref(), getIdioma());
        i18nMap = I18nUtilBO.selectMap(model);

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

        rglaCriterio.setCrgoId(model.getId());
        rglaCriterio.setFechaVigencia(model.getFref());
        rglaCriterio.setIdioma(getIdioma());

        rglaList = rglaBO.selectList(rglaCriterio);
    }
}
