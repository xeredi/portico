package xeredi.integra.http.controller.action.seguridad;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.bo.UsuarioBO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;
import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAction.
 */
public final class UsuarioAction extends ItemAction implements ModelDriven<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4159907306437348737L;

    /** The model. */
    private UsuarioVO model;

    /** The accn list. */
    private List<AccionVO> accnList;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("usro-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final UsuarioBO usroBO = new UsuarioBO();
        final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

        usroCriterio.setId(model.getId());

        model = usroBO.selectObject(usroCriterio);

        {
            final GrupoBO grpoBO = new GrupoBO();
            final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

            grpoCriterio.setUsroId(model.getId());

            grpoList = grpoBO.selectList(grpoCriterio);
        }

        {
            final AccionBO accnBO = new AccionBO();
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setUsroId(model.getId());

            accnList = accnBO.selectList(accnCriterio);
        }

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("usro-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (ACCION_EDICION.edit == getAccion()) {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            final UsuarioBO usroBO = new UsuarioBO();
            final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

            usroCriterio.setId(model.getId());

            model = usroBO.selectObject(usroCriterio);
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("usro-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (model == null) {
            model = new UsuarioVO();
        }

        if (ACCION_EDICION.edit == getAccion()) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.usro, model.getLogin());
        FieldValidator.validateRequired(this, MessageI18nKey.usro, model.getContrasenia());

        if (hasErrors()) {
            return SUCCESS;
        }

        final UsuarioBO usroBO = new UsuarioBO();

        switch (getAccion()) {
        case create:
            usroBO.insert(model);

            break;
        case edit:
            usroBO.update(model);

            break;
        default:
            throw new Error("Accion no valida: " + getAccion());
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("usro-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final UsuarioBO usroBO = new UsuarioBO();

        usroBO.delete(model);

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final UsuarioVO value) {
        model = value;
    }

    /**
     * Gets the accn list.
     *
     * @return the accn list
     */
    public List<AccionVO> getAccnList() {
        return accnList;
    }

    /**
     * Gets the grpo list.
     *
     * @return the grpo list
     */
    public List<GrupoVO> getGrpoList() {
        return grpoList;
    }

}
