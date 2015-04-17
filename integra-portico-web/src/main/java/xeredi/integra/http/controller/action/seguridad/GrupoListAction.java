package xeredi.integra.http.controller.action.seguridad;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoListAction.
 */
public final class GrupoListAction extends PaginableAction implements ModelDriven<GrupoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5074804383452913721L;

    /** The model. */
    private GrupoCriterioVO model;

    /** The grpo list. */
    private PaginatedList<GrupoVO> grpoList;

    /**
     * Filter.
     *
     * @return the string
     */
    @Action("grpo-filter")
    public String filter() {
        return SUCCESS;
    }

    /**
     * List.
     *
     * @return the string
     */
    @Action("grpo-list")
    public String list() {
        if (model == null) {
            model = new GrupoCriterioVO();
        }

        final GrupoBO grpoBO = new GrupoBO();

        grpoList = grpoBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public GrupoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final GrupoCriterioVO value) {
        model = value;
    }

    /**
     * Gets the grpo list.
     *
     * @return the grpo list
     */
    public PaginatedList<GrupoVO> getGrpoList() {
        return grpoList;
    }

}
