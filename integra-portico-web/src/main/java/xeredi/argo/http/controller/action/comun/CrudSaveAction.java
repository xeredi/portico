package xeredi.argo.http.controller.action.comun;

import com.google.common.base.Preconditions;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudSaveAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class CrudSaveAction<T> extends BaseAction implements ProtectedAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6571569363320765658L;

	/** The accion. */
	@Getter
	@Setter
	protected AccionCodigo accion;

	/** The model. */
	@Getter
	@Setter
	protected T model;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doExecute() throws ApplicationException {
		Preconditions.checkNotNull(accion);
		Preconditions.checkNotNull(model);

		doValidate();

		if (model instanceof Identifiable) {
			if (accion != AccionCodigo.create) {
				Preconditions.checkNotNull(((Identifiable) model).getId());
			}
		}

		if (model instanceof Versionable<?>) {
			Preconditions.checkNotNull(((Versionable<?>) model).getVersion());

			if (accion != AccionCodigo.create) {
				Preconditions.checkNotNull(((Versionable<?>) model).getVersion().getId());
			}

			FieldValidator.validateVersion(this, accion, (Versionable<?>) model);
		}

		if (!hasErrors()) {
			doSave();
		}
	}

	/**
	 * Do execute.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doSave() throws ApplicationException;

	/**
	 * Do validate.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doValidate() throws ApplicationException;
}
