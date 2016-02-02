package xeredi.argo.http.controller.action.comun;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionCodigo;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class GridFilterAction.
 *
 * @param <C>
 *            the generic type
 */
public abstract class GridFilterAction<C extends BaseCriterioVO> extends BaseAction implements ModelDriven<C>,
ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -777906795137481254L;

    /** The valid rows per page. */
    public static final int[] VALID_ROWS_PER_PAGE = new int[] { 10, 20, 50, 100, 200, 500 };

    /** The model. */
    @Getter
    @Setter
    protected C model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        model.setIdioma(idioma);

        doPrepareFilter();
        doLoadDependencies();
    }

    /**
     * Do prepare filter.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doPrepareFilter() throws ApplicationException;

    /**
     * Do load dependencies.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doLoadDependencies() throws ApplicationException;

    /**
     * Gets the limits.
     *
     * @return the limits
     */
    public final int[] getLimits() {
        return VALID_ROWS_PER_PAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final AccionCodigo getAccion() {
        return AccionCodigo.list;
    }
}
