package xeredi.argo.http.controller.action.servicio;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaEditAction.
 */
@Data
public final class ServicioSecuenciaEditAction extends CrudEditAction<ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7265649887754786022L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.srsc;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /** The tpsr list. */
    private List<TipoServicioVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.edit) {
            Preconditions.checkNotNull(model.getPrto());
            Preconditions.checkNotNull(model.getPrto().getId());
            Preconditions.checkNotNull(model.getTpsr());
            Preconditions.checkNotNull(model.getTpsr().getId());
            Preconditions.checkNotNull(model.getAnno());

            final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();
            final ServicioSecuenciaCriterioVO srscCriterio = new ServicioSecuenciaCriterioVO();

            srscCriterio.setPrtoId(model.getPrto().getId());
            srscCriterio.setTpsrId(model.getTpsr().getId());
            srscCriterio.setAnno(model.getAnno());
            srscCriterio.setIdioma(getIdioma());

            model = srscBO.select(srscCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());
        prtoCriterio.setSprtId(getSprtId());

        prtoList = prtoBO.selectList(prtoCriterio);

        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

        tpsrCriterio.setIdioma(getIdioma());

        tpsrList = tpsrBO.selectList(tpsrCriterio);
    }
}
