package xeredi.integra.http.controller.action.item;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.proxy.TramiteDetailVO;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemStatechangeEditAction.
 *
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemStatechangeEditAction<I extends ItemVO, E extends AbstractEntidadDetailVO> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3803526996899147874L;

    /** The trmt id. */
    protected Long trmtId;

    /** The trmt. */
    protected TramiteDetailVO trmt;

    /** The item. */
    protected I item;

    /** The enti. */
    protected E enti;

    /** The label values map. */
    private HashMap<Long, List<LabelValueVO>> labelValuesMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(trmtId);

        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        trmt = TramiteProxy.select(trmtId);

        doStatechangeEdit();

        doLoadDependencies();
    }

    /**
     * Do load dependencies.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private final void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(enti);

        labelValuesMap = new HashMap<Long, List<LabelValueVO>>();

        final Set<Long> tpprIds = new HashSet<>();

        for (final TramiteTipoDatoVO trtd : trmt.getTrtdMap().values()) {
            if (trtd.getEntd().getTpdt().getTpht() != TipoHtml.F && trtd.getEntd().getTpdt().getEnti() != null
                    && trtd.getEntd().getTpdt().getEnti().getId() != null) {
                tpprIds.add(trtd.getEntd().getTpdt().getEnti().getId());
            }
        }

        if (!tpprIds.isEmpty()) {
            final ParametroBO prmtBO = new DefaultParametroBO();

            labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), idioma));
        }
    }

    /**
     * Do statechange edit.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doStatechangeEdit() throws ApplicationException;

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public abstract Date getFechaVigencia();

    /**
     * Gets the prto id.
     *
     * @return the prto id
     */
    public abstract Long getPrtoId();

    /**
     * Gets the trmt.
     *
     * @return the trmt
     */
    public final TramiteDetailVO getTrmt() {
        return trmt;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public final I getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setItem(final I value) {
        this.item = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final E getEnti() {
        return enti;
    }

    /**
     * Gets the trmt id.
     *
     * @return the trmt id
     */
    public final Long getTrmtId() {
        return trmtId;
    }

    /**
     * Sets the trmt id.
     *
     * @param value
     *            the new trmt id
     */
    public final void setTrmtId(final Long value) {
        this.trmtId = value;
    }

    /**
     * Gets the label values map.
     *
     * @return the label values map
     */
    public final HashMap<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }
}
