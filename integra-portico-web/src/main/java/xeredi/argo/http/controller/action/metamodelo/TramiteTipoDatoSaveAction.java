package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

@Data
public final class TramiteTipoDatoSaveAction extends CrudSaveAction<TramiteTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6877738229315027201L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.trtd;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();

		switch (accion) {
		case create:
			trtdBO.insert(model);

			break;
		case edit:
			trtdBO.update(model);

			break;
		default:
			throw new Error("Accion no contemplada: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getTrmtId());

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.tpdt, model.getEntd());

			if (!hasErrors()) {
				FieldValidator.validateRequired(this, MessageI18nKey.tpdt, model.getEntd().getTpdt());

				if (!hasErrors()) {
					FieldValidator.validateRequired(this, MessageI18nKey.tpdt, model.getEntd().getTpdt().getId());
				}
			}
		} else {
			Preconditions.checkNotNull(model.getEntd());
			Preconditions.checkNotNull(model.getEntd().getTpdt());
			Preconditions.checkNotNull(model.getEntd().getTpdt().getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.trtd_obligatorio, model.getObligatorio());
	}
}
