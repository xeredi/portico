package xeredi.integra.http.controller.action.seguridad;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.seguridad.bo.UsuarioBO;
import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioListAction.
 */
public final class UsuarioListAction extends PaginableAction implements ModelDriven<UsuarioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3750518542645128408L;

    /** The model. */
    private UsuarioCriterioVO model;

    /** The usro list. */
    private PaginatedList<UsuarioVO> usroList;

    /**
     * Filter.
     *
     * @return the string
     */
    @Action("usro-filter")
    public String filter() {
        final UsuarioBO usroBO = new UsuarioBO();

        usroList = usroBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    /**
     * List.
     *
     * @return the string
     */
    @Action("usro-list")
    public String list() {
        final UsuarioBO usroBO = new UsuarioBO();

        usroList = usroBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final UsuarioCriterioVO value) {
        model = value;
    }

    /**
     * Gets the usro list.
     *
     * @return the usro list
     */
    public PaginatedList<UsuarioVO> getUsroList() {
        return usroList;
    }

}
