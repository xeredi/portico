package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaDetailAction.
 */
public final class ReglaDetailAction extends CrudDetailAction<ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -830320171753668738L;

    /** The rgin list. */
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

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgla1Id(model.getId());
        rginCriterioVO.setFechaVigencia(model.getFref());

        rginList = rginBO.selectList(rginCriterioVO);
    }

    /**
     * Gets the rgin list.
     *
     * @return the rgin list
     */
    public List<ReglaIncompatibleVO> getRginList() {
        return rginList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.rgla;
    }
}
