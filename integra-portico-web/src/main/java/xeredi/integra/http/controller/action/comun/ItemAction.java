package xeredi.integra.http.controller.action.comun;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.integra.model.vo.comun.ItemVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemAction.
 */
public abstract class ItemAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6333242573443367864L;

	/** The Constant ROWS. */
	protected static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

	/** The accion. */
	protected ACCION_EDICION accion;

	/** The label values map. */
	protected Map<Long, List<LabelValueVO>> labelValuesMap;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	// get / set

	/**
	 * Gets the fecha vigencia.
	 * 
	 * @return the fecha vigencia
	 */
	public abstract Date getFechaVigencia();

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
	 */
	protected final void loadLabelValuesMap() {
		if (labelValuesMap == null) {
			labelValuesMap = new HashMap<>();

			// Carga de los labelValues (Si los hay)
			final Set<Long> tpprIds = new HashSet<>();

			for (final EntidadTipoDatoVO entdVO : getEnti().getEntdMap().values()) {
				if (entdVO.getTpdt().getTpht() != TipoHtml.F && entdVO.getTpdt().getEnti() != null
						&& entdVO.getTpdt().getEnti().getId() != null) {
					tpprIds.add(entdVO.getTpdt().getEnti().getId());
				}
			}

			if (!tpprIds.isEmpty()) {
				final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);

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
	 * Gets the enti.
	 * 
	 * @return the enti
	 */
	public abstract EntidadVO getEnti();

	/**
	 * Gets the item.
	 * 
	 * @return the item
	 */
	public abstract ItemVO getItem();

}
