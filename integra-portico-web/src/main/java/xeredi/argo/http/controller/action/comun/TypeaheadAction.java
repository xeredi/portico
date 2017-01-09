package xeredi.argo.http.controller.action.comun;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ConfigurationProxyService;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.Typeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class TypeaheadAction.
 *
 * @param <C>
 *            the generic type
 * @param <R>
 *            the generic type
 */
public abstract class TypeaheadAction<C extends Typeahead, R> extends BaseAction implements ModelDriven<C> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2890042689865301209L;

	/** The model. */
	@Getter
	@Setter
	protected C model;

	/** The result list. */
	@Getter
	protected List<R> resultList;

	/** The limit. */
	@Setter
	protected int limit;

	@Inject
	private ConfigurationProxyService confProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doExecute() throws ApplicationException {
		Preconditions.checkNotNull(model);

		model.setIdioma(getIdioma());

		limit = confProxy.getInt(ConfigurationKey.filter_limit);

		doTypeahead();
	}

	/**
	 * Do execute.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doTypeahead() throws ApplicationException;
}
