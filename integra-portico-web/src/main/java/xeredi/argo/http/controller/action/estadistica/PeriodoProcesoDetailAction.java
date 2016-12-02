package xeredi.argo.http.controller.action.estadistica;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.metamodelo.proxy.TipoEstadisticaProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoDetailAction.
 */
@Data
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

        model = peprBO.select(model.getId(), getIdioma());
        tpesList = TipoEstadisticaProxy.selectLabelValues();
    }
}
