package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import xeredi.integra.http.controller.action.item.ItemEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
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
    private Map<Long, LabelValueVO> itemPadresMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        enti = TipoSubservicioProxy.select(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            if (model.getSrvc() != null && model.getSrvc().getId() != null) {
                final ServicioBO srvcBO = ServicioBOFactory.newInstance(enti.getEnti().getTpsrId());

                model.setSrvc(srvcBO.select(model.getSrvc().getId(), idioma));
                model.setFref(model.getSrvc().getFref());
            } else {
                model.setFref(Calendar.getInstance().getTime());
            }
        } else {
            Preconditions.checkNotNull(model.getSrvc());
            Preconditions.checkNotNull(model.getSrvc().getId());

            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

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
        }

        fechaVigencia = model.getFref();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadSpecificDependencies() throws ApplicationException {
        // noop
    }

    /**
     * Gets the item padres map.
     *
     * @return the item padres map
     */
    public Map<Long, LabelValueVO> getItemPadresMap() {
        return itemPadresMap;
    }
}
