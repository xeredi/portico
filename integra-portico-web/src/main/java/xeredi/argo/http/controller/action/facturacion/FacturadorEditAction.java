package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.facturacion.vo.FacturadorVO;
import xeredi.argo.model.facturacion.vo.ValoracionGrupoTipo;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorEditAction.
 */
@Data
public final class FacturadorEditAction extends CrudEditAction<FacturadorVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1389260062489112937L;

    /** The fcsr list. */
    private List<FacturaSerieVO> fcsrList;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    private ValoracionGrupoTipo[] grupoTipoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model);

        model.setFecha(Calendar.getInstance());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getFecha());

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();
        final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

        fcsrCriterio.setAnio(model.getFecha().get(Calendar.YEAR));

        fcsrList = fcsrBO.selectList(fcsrCriterio);

        grupoTipoList = ValoracionGrupoTipo.values();

        if (model.getVlrcId() == null) {
            tpsrList = TipoServicioProxy.selectLabelValues();

            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setIdioma(getIdioma());

            prtoList = prtoBO.selectList(prtoCriterio);
        }
    }
}
