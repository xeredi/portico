package xeredi.argo.http.controller.action.item;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.gis.vo.MapVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemGisAction.
 *
 * @param <C>
 *            the generic type
 * @param <E>
 *            the element type
 * @param <I>
 *            the generic type
 */
public abstract class ItemGisAction<C extends ItemCriterioVO, E extends AbstractEntidadDetailVO, I extends ItemVO>
extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5802281348269531835L;

    /** The criterio. */
    @Setter
    protected C criterio;

    /** The item list. */
    @Getter
    protected Map<Long, I> itemMap;

    /** The enti map. */
    @Getter
    protected Map<Long, E> entiMap;

    /** The mapinfo. */
    @Getter
    protected MapVO map;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(criterio);

        doList();
    }

    /**
     * Do list.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected abstract void doList() throws ApplicationException;
}
