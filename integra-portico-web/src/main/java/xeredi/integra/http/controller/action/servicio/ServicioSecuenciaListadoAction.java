package xeredi.integra.http.controller.action.servicio;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaListadoAction.
 */
public final class ServicioSecuenciaListadoAction extends PaginableAction implements
ModelDriven<ServicioSecuenciaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -573213374260081652L;

    /** The srsc criterio. */
    private ServicioSecuenciaCriterioVO model;

    /** The srsc list. */
    private PaginatedList<ServicioSecuenciaVO> srscList;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /** The tpsr list. */
    private List<TipoServicioVO> tpsrList;

    /**
     * Filter.
     *
     * @return the string
     */
    @Action("srsc-filter")
    public String filter() {
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());
        prtoCriterio.setSprtId(getSprtId());

        prtoList = prtoBO.selectList(prtoCriterio);

        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

        tpsrCriterio.setIdioma(getIdioma());

        tpsrList = tpsrBO.selectList(tpsrCriterio);

        return SUCCESS;
    }

    /**
     * List.
     *
     * @return the string
     */
    @Action("srsc-list")
    public String list() {
        if (model == null) {
            model = new ServicioSecuenciaCriterioVO();
        }

        model.setIdioma(getIdioma());

        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();

        srscList = srscBO.selectList(model, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioSecuenciaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final ServicioSecuenciaCriterioVO value) {
        model = value;
    }

    /**
     * Gets the srsc list.
     *
     * @return the srsc list
     */
    public PaginatedList<ServicioSecuenciaVO> getSrscList() {
        return srscList;
    }

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<TipoServicioVO> getTpsrList() {
        return tpsrList;
    }

}
