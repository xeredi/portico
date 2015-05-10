package xeredi.integra.http.controller.action.item;

import java.util.List;
import java.util.Map;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.gis.vo.MapVO;
import xeredi.integra.model.metamodelo.proxy.AbstractEntidadDetailVO;

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
    protected C criterio;

    /** The item list. */
    protected List<I> itemList;

    /** The enti map. */
    protected Map<Long, E> entiMap;

    /** The mapinfo. */
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

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public final List<I> getItemList() {
        return itemList;
    }

    /**
     * Sets the criterio.
     *
     * @param value
     *            the new criterio
     */
    public final void setCriterio(final C value) {
        this.criterio = value;
    }

    /**
     * Gets the enti map.
     *
     * @return the enti map
     */
    public final Map<Long, E> getEntiMap() {
        return entiMap;
    }

    /**
     * Gets the mapinfo.
     *
     * @return the mapinfo
     */
    public final MapVO getMap() {
        return map;
    }
}
