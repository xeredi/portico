package xeredi.integra.http.controller.action.item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemEditAction.
 *
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemEditAction<I extends ItemVO, E extends AbstractEntidadDetailVO> extends CrudEditAction<I> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4070230048819938799L;

    /** The enti. */
    protected E enti;

    /** The label values map. */
    protected Map<Long, List<LabelValueVO>> labelValuesMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());
        }

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

            for (final Long tpdtId : enti.getEntdList()) {
                final EntidadTipoDatoVO entd = enti.getEntdMap().get(tpdtId);

                if (entd.getTpdt().getTpht() != TipoHtml.F && entd.getTpdt().getEnti() != null
                        && entd.getTpdt().getEnti().getId() != null) {
                    tpprIds.add(entd.getTpdt().getEnti().getId());
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
     * Gets the label values map.
     *
     * @return the label values map
     */
    public final Map<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final E getEnti() {
        return enti;
    }
}
