package xeredi.integra.http.controller.action.comun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemAction.
 */
public abstract class ItemAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6333242573443367864L;

    /** The accion. */
    protected ACCION_EDICION accion;

    /** The label values map. */
    protected Map<Long, List<LabelValueVO>> labelValuesMap;

    // get / set

    /**
     * Gets the label values map.
     *
     * @return the label values map
     */
    public final Map<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }

    /**
     * Load label values map.
     *
     * @param enti
     *            the enti
     */
    protected final void loadLabelValuesMap(final EntidadVO enti) {
        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            // Carga de los labelValues (Si los hay)
            final Set<Long> tpprIds = new HashSet<>();

            if (enti.getEntdList() != null) {
                for (final EntidadTipoDatoVO entdVO : enti.getEntdList()) {
                    if (entdVO.getTpdt().getTpht() != TipoHtml.F && entdVO.getTpdt().getEnti() != null
                            && entdVO.getTpdt().getEnti().getId() != null) {
                        tpprIds.add(entdVO.getTpdt().getEnti().getId());
                    }
                }
            }

            if (!tpprIds.isEmpty()) {
                final ParametroBO prmtBO = new ParametroBO();

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), getIdioma()));
            }
        }
    }

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public final ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public final void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public abstract ItemVO getItem();

}
