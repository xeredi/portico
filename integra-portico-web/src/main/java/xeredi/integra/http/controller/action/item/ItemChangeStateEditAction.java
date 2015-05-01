package xeredi.integra.http.controller.action.item;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeredi.integra.http.controller.action.comun.CrudChangeStateEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemChangeStateEditAction.
 *
 * @param <M>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemChangeStateEditAction<M extends ItemVO, E extends AbstractEntidadDetailVO> extends
CrudChangeStateEditAction<M> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7178123998222331751L;

    /** The enti. */
    protected E enti;

    /** The label values map. */
    protected Map<Long, List<LabelValueVO>> labelValuesMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        doSpecificEdit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(enti);

        labelValuesMap = new HashMap<Long, List<LabelValueVO>>();

        if (enti.getEntdList() != null) {
            final Set<Long> tpprIds = new HashSet<>();

            for (final EntidadTipoDatoVO entdVO : enti.getEntdList()) {
                if (entdVO.getTpdt().getTpht() != TipoHtml.F && entdVO.getTpdt().getEnti() != null
                        && entdVO.getTpdt().getEnti().getId() != null) {
                    tpprIds.add(entdVO.getTpdt().getEnti().getId());
                }
            }

            if (!tpprIds.isEmpty()) {
                final ParametroBO prmtBO = new DefaultParametroBO();

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), idioma));
            }
        }

        doLoadSpecificDependencies();
    }

    /**
     * Do specific edit.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificEdit() throws ApplicationException;

    /**
     * Do load specific dependencies.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doLoadSpecificDependencies() throws ApplicationException;

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
