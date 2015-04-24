package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadListadoAction.
 */
public final class EntidadListadoAction extends BaseAction implements ModelDriven<EntidadCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1250990272188228335L;

    /** The entis. */
    private List<EntidadVO> entiList;

    /** The enti criterio form. */
    private EntidadCriterioVO model;

    /**
     * Instantiates a new entidad listado action.
     */
    public EntidadListadoAction() {
        super();

        model = new EntidadCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("enti-hija-list-content")
    public String hijaListado() {
        final EntidadBO entiBO = new EntidadBO();

        if (model.getEntiPadreId() == null) {
            throw new Error("No se ha proporcionado una entidad padre");
        }

        entiList = entiBO.selectList(model);

        return SUCCESS;
    }

    /**
     * Padre listado.
     *
     * @return the string
     */
    @Action("enti-padre-list-content")
    public String padreListado() {
        final EntidadBO entiBO = new EntidadBO();

        if (model.getEntiHijaId() == null) {
            throw new Error("No se ha proporcionado una entidad hija");
        }

        entiList.addAll(entiBO.selectList(model));

        return SUCCESS;
    }

    // get/set
    /**
     * Gets the list.
     *
     * @return the list
     */
    public List<EntidadVO> getEntiList() {
        return entiList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntidadCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final EntidadCriterioVO value) {
        model = value;
    }

}
