package xeredi.argo.http.controller.action.item;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemCriterioVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemListAction.
 *
 * @param <C>
 *            the generic type
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemListAction<C extends ItemCriterioVO, I extends ItemVO, E extends AbstractEntidadDetailVO>
		extends GridListAction<C, I> implements ProtectedItemAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1634381107882001806L;

	/** The enti. */
	@Getter
	protected E enti;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doList() throws ApplicationException {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getEntiId());

		model.setSoloDatosGrid(true);
		model.setIdioma(getIdioma());

		doSpecificList();
	}

	/**
	 * Do specific list.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doSpecificList() throws ApplicationException;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long getEntiId() {
		return model.getEntiId();
	}
}
