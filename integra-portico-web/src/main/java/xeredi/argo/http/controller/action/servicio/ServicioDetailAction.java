package xeredi.argo.http.controller.action.servicio;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.bo.ArchivoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ArchivoCriterioVO;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.item.bo.ItemTramiteBO;
import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioDetailAction.
 */
public final class ServicioDetailAction extends ItemDetailAction<ServicioVO, TipoServicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8504526234230863854L;

    /** The arin list. */
    @Getter
    private List<ArchivoInfoVO> arinList;

    /** The srtr list. */
    @Getter
    private List<ItemTramiteVO> ittrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        enti = TipoServicioProxy.select(model.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId(), usroId);

        model = srvcBO.select(model.getId(), getIdioma());

        final ArchivoBO archBO = new ArchivoBO();
        final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

        archCriterio.setSrvcId(model.getId());

        arinList = archBO.selectList(archCriterio);

        if (enti.getEnti().getTpdtEstado() != null) {
            final ItemTramiteBO ittrBO = new ItemTramiteBO();
            final ItemTramiteCriterioVO ittrCriterio = new ItemTramiteCriterioVO();

            ittrCriterio.setItemId(model.getId());
            ittrCriterio.setIdioma(idioma);

            ittrList = ittrBO.selectList(ittrCriterio);
        }
    }
}
