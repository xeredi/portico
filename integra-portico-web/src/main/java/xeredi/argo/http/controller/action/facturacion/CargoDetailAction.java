package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

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
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoDetailAction.
 */
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
        Preconditions.checkNotNull(model.getId());

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

        crgoCriterio.setId(model.getId());
        crgoCriterio.setFechaVigencia(model.getFref());
        crgoCriterio.setIdioma(getIdioma());

        model = crgoBO.selectObject(crgoCriterio);
        i18nMap = I18nBO.selectMap(I18nPrefix.crgv, model.getVersion().getId());

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setCrgoId(model.getId());
        rglaCriterioVO.setFechaVigencia(model.getFref());

        rglaList = rglaBO.selectList(rglaCriterioVO);
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
     * Gets the rgla list.
     *
     * @return the rgla list
     */
    public List<ReglaVO> getRglaList() {
        return rglaList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.crgo;
    }
}
