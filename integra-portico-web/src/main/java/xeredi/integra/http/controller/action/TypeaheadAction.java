package xeredi.integra.http.controller.action;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.TypeaheadCriterioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TypeaheadAction.
 *
 * @param <C>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public abstract class TypeaheadAction<C extends TypeaheadCriterioVO, R> extends BaseAction implements ModelDriven<C> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2890042689865301209L;

    /** The model. */
    protected C model;

    /** The result list. */
    protected List<R> resultList;

    /** The limit. */
    protected int limit = 5;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String execute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        model.setIdioma(getIdioma());

        doTypeahead();

        return SUCCESS;
    }

    /**
     * Do execute.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doTypeahead() throws ApplicationException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final C getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public final void setModel(final C value) {
        this.model = value;
    }

    /**
     * Gets the result list.
     *
     * @return the result list
     */
    public final List<R> getResultList() {
        return resultList;
    }

    /**
     * Sets the limit.
     *
     * @param limit
     *            the new limit
     */
    public final void setLimit(final int limit) {
        this.limit = limit;
    }

}
