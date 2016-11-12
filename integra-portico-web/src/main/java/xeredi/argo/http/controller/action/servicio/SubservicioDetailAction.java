package xeredi.argo.http.controller.action.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.bo.ItemTramiteBO;
import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioDetailAction.
 */
public final class SubservicioDetailAction extends ItemDetailAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2847090432750136391L;

    /** The item padres map. */
    @Getter
    private Map<Long, LabelValueVO> itemPadresMap;

    /** The sstr list. */
    @Getter
    private List<ItemTramiteVO> ittrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        {
            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId(), usroId);

            model = ssrvBO.select(model.getId(), idioma);
        }

        if (enti.getEntiPadresList() != null) {
            itemPadresMap = new HashMap<Long, LabelValueVO>();

            for (final Long entiId : enti.getEntiPadresList()) {
                if (!enti.getEnti().getTpsrId().equals(entiId)) {
                    final SubservicioBO ssrvPadreBO = SubservicioBOFactory.newInstance(entiId, usroId);
                    final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                    ssrvCriterioVO.setHijoId(model.getId());
                    ssrvCriterioVO.setEntiId(entiId);

                    itemPadresMap.put(entiId, ssrvPadreBO.selectLabelValueObject(ssrvCriterioVO));
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
}
