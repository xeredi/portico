package xeredi.argo.http.controller.action.item;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoHtml;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemFilterAction.
 *
 * @param <C>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemFilterAction<C extends ItemCriterioVO, E extends AbstractEntidadDetailVO>
		extends GridFilterAction<C> implements ProtectedItemAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8917073535249583222L;

	/** The enti. */
	@Getter
	protected E enti;

	/** The label values map. */
	@Getter
	protected Map<Long, List<LabelValueVO>> labelValuesMap;

	@Inject
	private ParametroService prmtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doPrepareFilter() throws ApplicationException {
		Preconditions.checkNotNull(model.getEntiId());

		doSpecificPrepareFilter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doLoadDependencies() throws ApplicationException {
		Preconditions.checkNotNull(enti);

		if (enti.getEntdList() != null) {
			labelValuesMap = new HashMap<Long, List<LabelValueVO>>();

			final Set<Long> tpprIds = new HashSet<>();

			for (final Long tpdtId : enti.getEntdList()) {
				final EntidadTipoDatoVO entd = enti.getEntdMap().get(tpdtId);

				if (entd.getFiltrable() && entd.getTpdt().getTpht() != TipoHtml.F && entd.getTpdt().getEnti() != null
						&& entd.getTpdt().getEnti().getId() != null) {
					tpprIds.add(entd.getTpdt().getEnti().getId());
				}
			}

			if (!tpprIds.isEmpty()) {
				labelValuesMap.putAll(prmtService.selectLabelValues(tpprIds, getFechaVigencia(), getIdioma()));
			}
		}

		doSpecificLoadDependencies();
	}

	/**
	 * Do specific prepare filter.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doSpecificPrepareFilter() throws ApplicationException;

	/**
	 * Do load dependencies.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doSpecificLoadDependencies() throws ApplicationException;

	/**
	 * Gets the fecha vigencia.
	 *
	 * @return the fecha vigencia
	 */
	public abstract Date getFechaVigencia();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long getEntiId() {
		return model.getEntiId();
	}
}
