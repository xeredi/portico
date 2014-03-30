package xeredi.integra.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.proxy.metamodelo.TipoServicioProxy;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListadoAction.
 */
public final class TipoServicioListadoAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5523514529976849793L;

	/** The tpsrs. */
	private List<LabelValueVO> tpsrs;

	/** {@link Map} de tipos de subservicio indexados por id de tipo de servicio. */
	private Map<Long, List<LabelValueVO>> tpssMap;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	// Acciones web
	/**
	 * Listado.
	 * 
	 * @return the string
	 */
	@Actions({
		@Action(value = "tpsr-listado"),
		@Action(value = "tpsr-listado-json", results = { @Result(name = "success", type = "json") }) })
	public String listado() {
		tpsrs = TipoServicioProxy.selectLabelValues();
		tpssMap = new HashMap<>();

		for (final TipoSubservicioVO vo : TipoSubservicioProxy.selectMap()
				.values()) {
			if (!tpssMap.containsKey(vo.getTpsr().getId())) {
				tpssMap.put(vo.getTpsr().getId(), new ArrayList<LabelValueVO>());
			}

			tpssMap.get(vo.getTpsr().getId()).add(
					new LabelValueVO(vo.getNombre(), vo.getId()));
		}

		return SUCCESS;
	}

	// get/set

	/**
	 * Gets the tpsrs.
	 * 
	 * @return the tpsrs
	 */
	public List<LabelValueVO> getTpsrs() {
		return tpsrs;
	}

	/**
	 * Gets the tpss map.
	 * 
	 * @return the tpss map
	 */
	public final Map<Long, List<LabelValueVO>> getTpssMap() {
		return tpssMap;
	}

}
