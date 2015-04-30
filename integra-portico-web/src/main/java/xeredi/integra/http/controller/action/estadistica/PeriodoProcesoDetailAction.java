package xeredi.integra.http.controller.action.estadistica;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoDetailAction.
 */
public final class PeriodoProcesoDetailAction extends CrudDetailAction<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4868698080267704484L;

    /** The tpes list. */
    private List<LabelValueVO> tpesList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        model = peprBO.select(model.getId());
        tpesList = TipoEstadisticaProxy.selectLabelValues();
    }

    /**
     * Gets the tpes list.
     *
     * @return the tpes list
     */
    public List<LabelValueVO> getTpesList() {
        return tpesList;
    }

}
