package xeredi.integra.http.controller.action;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.BaseCriterioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TypeaheadAction.
 *
 * @param <T>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public abstract class TypeaheadAction<T extends BaseCriterioVO, R> extends BaseAction implements ModelDriven<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2890042689865301209L;

    /** The model. */
    protected T model;

    /** The result list. */
    protected List<R> resultList;

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        model.setIdioma(getIdioma());

        doExecute();

        return SUCCESS;
    }

    /**
     * Do execute.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doExecute() throws ApplicationException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final T getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public final void setModel(final T value) {
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

}
