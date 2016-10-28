package xeredi.argo.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEditAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class EntidadEditAction<T extends EntidadVO> extends CrudEditAction<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3928988946180134293L;

    /** The i18n map. */
    @Getter
    protected Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            i18nMap = new HashMap<>();
        } else {
            Preconditions.checkNotNull(model.getId());

            i18nMap = I18nBO.selectMap(ClassPrefix.enti, model.getId());
        }

        doSpecificEdit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doLoadDependencies() throws ApplicationException {
        doSpecificLoadDependencies();
    }

    /**
     * Do specific edit.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificEdit() throws ApplicationException;

    /**
     * Do specific load dependencies.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificLoadDependencies() throws ApplicationException;
}
