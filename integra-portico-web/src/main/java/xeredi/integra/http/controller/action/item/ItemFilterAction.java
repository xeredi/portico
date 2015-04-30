package xeredi.integra.http.controller.action.item;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeredi.integra.http.controller.action.comun.GridFilterAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemFilterAction.
 *
 * @param <C>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemFilterAction<C extends ItemCriterioVO, E extends AbstractEntidadDetailVO> extends
        GridFilterAction<C> {

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

            for (final EntidadTipoDatoVO entdVO : enti.getEntdList()) {
                if (entdVO.getFiltrable() && entdVO.getTpdt().getTpht() != TipoHtml.F
                        && entdVO.getTpdt().getEnti() != null && entdVO.getTpdt().getEnti().getId() != null) {
                    tpprIds.add(entdVO.getTpdt().getEnti().getId());
                }
            }

            if (!tpprIds.isEmpty()) {
                final ParametroBO prmtBO = new DefaultParametroBO();

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
}
