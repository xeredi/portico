package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoDetailAction.
 */
public final class CargoDetailAction extends CrudDetailAction<CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 731400411604425450L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /** The rgla list. */
    @Getter
    private List<ReglaVO> rglaList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

        crgoCriterio.setId(model.getId());
        crgoCriterio.setFechaVigencia(model.getFref());
        crgoCriterio.setIdioma(getIdioma());

        model = crgoBO.selectObject(crgoCriterio);
        i18nMap = I18nBO.selectMap(I18nPrefix.crgv, model.getVersion().getId());

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

        rglaCriterio.setCrgoId(model.getId());
        rglaCriterio.setFechaVigencia(model.getFref());
        rglaCriterio.setIdioma(getIdioma());

        rglaList = rglaBO.selectList(rglaCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.crgo;
    }
}
