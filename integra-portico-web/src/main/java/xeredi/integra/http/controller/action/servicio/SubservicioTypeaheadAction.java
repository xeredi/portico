package xeredi.integra.http.controller.action.servicio;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.item.ItemTypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTypeaheadAction.
 */
public final class SubservicioTypeaheadAction extends ItemTypeaheadAction<SubservicioLupaCriterioVO, SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5330875855344902234L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificTypeahead() throws ApplicationException {
        Preconditions.checkNotNull(model.getSrvcId());

        model.setNumero(Integer.valueOf(model.getTextoBusqueda()));

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

        resultList = ssrvBO.selectLupaList(model, limit);
    }
}
