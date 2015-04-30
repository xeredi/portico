package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

import com.google.common.base.Preconditions;

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
        rglaCriterio.setFechaVigencia(fechaVigencia);

        model = rglaBO.selectObject(rglaCriterio);

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgla1Id(model.getId());
        rginCriterioVO.setFechaVigencia(fechaVigencia);

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
}
