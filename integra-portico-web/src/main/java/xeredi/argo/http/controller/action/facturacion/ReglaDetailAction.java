package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaDetailAction.
 */
public final class ReglaDetailAction extends CrudDetailAction<ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -830320171753668738L;

    /** The i18n map. */
    @Getter
    private Map<String, I18nVO> i18nMap;

    /** The rgin list. */
    @Getter
    private List<ReglaIncompatibleVO> rginList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

        rglaCriterio.setId(model.getId());
        rglaCriterio.setFechaVigencia(model.getFref());

        model = rglaBO.selectObject(rglaCriterio);
        i18nMap = I18nBO.selectMap(I18nPrefix.rglv, model.getVersion().getId());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgla1Id(model.getId());
        rginCriterioVO.setFechaVigencia(model.getFref());

        rginList = rginBO.selectList(rginCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.rgla;
    }
}
