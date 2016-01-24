package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioEditAction.
 */
public final class SubservicioEditAction extends ItemEditAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3286199992331373729L;

    /** The item padres map. */
    @Getter
    private Map<Long, LabelValueVO> itemPadresMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        switch (accion) {
        case create:
            if (model.getSrvc() != null && model.getSrvc().getId() != null) {
                final ServicioBO srvcBO = ServicioBOFactory.newInstance(enti.getEnti().getTpsrId());

                model.setSrvc(srvcBO.select(model.getSrvc().getId(), idioma));
                model.setFref(model.getSrvc().getFref());
            } else {
                model.setFref(Calendar.getInstance().getTime());
            }

            model.setEstado(enti.getEnti().getEstadoDef());

            break;
        case duplicate:
            Preconditions.checkNotNull(model.getSrvc());
            Preconditions.checkNotNull(model.getSrvc().getId());

            model = ssrvBO.select(model.getId(), getIdioma());
            model.setEstado(enti.getEnti().getEstadoDef());

            if (enti.getEntiPadresList() != null) {
                itemPadresMap = new HashMap<Long, LabelValueVO>();

                for (final Long entiId : enti.getEntiPadresList()) {
                    if (!enti.getEnti().getTpsrId().equals(entiId)) {
                        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                        ssrvCriterioVO.setHijoId(model.getId());
                        ssrvCriterioVO.setEntiId(entiId);

                        itemPadresMap.put(entiId, ssrvBO.selectLabelValueObject(ssrvCriterioVO));
                    }
                }
            }

            break;
        case edit:
            Preconditions.checkNotNull(model.getSrvc());
            Preconditions.checkNotNull(model.getSrvc().getId());

            model = ssrvBO.select(model.getId(), getIdioma());

            if (enti.getEntiPadresList() != null) {
                itemPadresMap = new HashMap<Long, LabelValueVO>();

                for (final Long entiId : enti.getEntiPadresList()) {
                    if (!enti.getEnti().getTpsrId().equals(entiId)) {
                        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                        ssrvCriterioVO.setHijoId(model.getId());
                        ssrvCriterioVO.setEntiId(entiId);

                        itemPadresMap.put(entiId, ssrvBO.selectLabelValueObject(ssrvCriterioVO));
                    }
                }
            }

            break;
        default:
            throw new Error("Invalid action: " + accion.name());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadSpecificDependencies() throws ApplicationException {
        // noop
    }
}
