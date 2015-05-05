package xeredi.integra.http.controller.action.servicio;

import java.util.List;

import xeredi.integra.http.controller.action.item.ItemDetailAction;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.bo.ServicioTramiteBO;
import xeredi.integra.model.servicio.vo.ServicioTramiteCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioDetailAction.
 */
public final class ServicioDetailAction extends ItemDetailAction<ServicioVO, TipoServicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8504526234230863854L;

    /** The arin list. */
    private List<ArchivoInfoVO> arinList;

    /** The srtr list. */
    private List<ServicioTramiteVO> srtrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        enti = TipoServicioProxy.select(model.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        model = srvcBO.select(model.getId(), getIdioma());
        fechaVigencia = model.getFref();

        final ArchivoBO archBO = new ArchivoBO();
        final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

        archCriterio.setSrvcId(model.getId());

        arinList = archBO.selectList(archCriterio);

        if (enti.getEnti().getTpdtEstado() != null) {
            final ServicioTramiteBO srtrBO = new ServicioTramiteBO();
            final ServicioTramiteCriterioVO srtrCriterio = new ServicioTramiteCriterioVO();

            srtrCriterio.setSrvcId(model.getId());
            srtrCriterio.setIdioma(idioma);

            srtrList = srtrBO.selectList(srtrCriterio);
        }
    }

    /**
     * Gets the arin list.
     *
     * @return the arin list
     */
    public List<ArchivoInfoVO> getArinList() {
        return arinList;
    }

    /**
     * Gets the srtr list.
     *
     * @return the srtr list
     */
    public List<ServicioTramiteVO> getSrtrList() {
        return srtrList;
    }
}
