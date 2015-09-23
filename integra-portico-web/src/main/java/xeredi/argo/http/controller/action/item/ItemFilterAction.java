package xeredi.argo.http.controller.action.item;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemCriterioVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

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
    protected E enti;

    /** The label values map. */
    protected Map<Long, List<LabelValueVO>> labelValuesMap;

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
                final ParametroBO prmtBO = ParametroBOFactory.newDefaultInstance();

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), idioma));
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
     * Gets the enti.
     *
     * @return the enti
     */
    public final E getEnti() {
        return enti;
    }

    /**
     * Gets the label values map.
     *
     * @return the label values map
     */
    public final Map<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        return model.getEntiId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final AccionPrefix getAccnPrefix() {
        return AccionPrefix.item;
    }
}
