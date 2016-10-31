package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaDetailAction.
 */
@Data
public final class ReglaDetailAction extends CrudDetailAction<ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -830320171753668738L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.rgla;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The rgin list. */
    private List<ReglaIncompatibleVO> rginList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ReglaBO rglaBO = new ReglaBO();

        model = rglaBO.select(model.getId(), model.getFref(), getIdioma());
        i18nMap = I18nUtilBO.selectMap(model);

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgla1Id(model.getId());
        rginCriterioVO.setFechaVigencia(model.getFref());

        rginList = rginBO.selectList(rginCriterioVO);
    }
}
