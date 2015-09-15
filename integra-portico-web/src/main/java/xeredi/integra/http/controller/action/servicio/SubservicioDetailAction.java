package xeredi.integra.http.controller.action.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.item.ItemDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.item.bo.ItemTramiteBO;
import xeredi.integra.model.item.vo.ItemTramiteCriterioVO;
import xeredi.integra.model.item.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioDetailAction.
 */
public final class SubservicioDetailAction extends ItemDetailAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2847090432750136391L;

    /** The item padres map. */
    private Map<Long, LabelValueVO> itemPadresMap;

    /** The sstr list. */
    private List<ItemTramiteVO> ittrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

        model = ssrvBO.select(model.getId(), idioma);

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

        if (enti.getEnti().getTpdtEstado() != null) {
            final ItemTramiteBO ittrBO = new ItemTramiteBO();
            final ItemTramiteCriterioVO ittrCriterio = new ItemTramiteCriterioVO();

            ittrCriterio.setItemId(model.getId());

            ittrList = ittrBO.selectList(ittrCriterio);
        }
    }

    /**
     * Gets the item padres map.
     *
     * @return the item padres map
     */
    public Map<Long, LabelValueVO> getItemPadresMap() {
        return itemPadresMap;
    }

    /**
     * Gets the sstr list.
     *
     * @return the sstr list
     */
    public List<ItemTramiteVO> getIttrList() {
        return ittrList;
    }
}
