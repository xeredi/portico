package xeredi.argo.http.controller.action.comun;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * CrudVersionDetailAction.
 *
 * @param <T>
 *            the generic type
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class CrudVersionDetailAction<T extends Versionable<?>> extends BaseAction
        implements ModelDriven<T>, ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6472228019805163581L;

    /** The accion. */
    private final AccionCodigo accion = AccionCodigo.detail;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVersion());
        Preconditions.checkNotNull(model.getVersion().getId());

        doDetail();
    }

    /**
     * Do detail.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doDetail() throws ApplicationException;
}
