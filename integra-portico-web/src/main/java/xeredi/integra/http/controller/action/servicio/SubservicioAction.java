package xeredi.integra.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.bo.servicio.Subservicio;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.integra.model.vo.servicio.ServicioCriterioVO;
import xeredi.integra.model.vo.servicio.SubservicioCriterioVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;
import xeredi.util.struts.PropertyValidator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioAction.
 */
// @ParentPackage("json-default")
// @Result(name="success", type="json")
public final class SubservicioAction extends ItemAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9210521463729954776L;

	/** The srvc form. */
	private SubservicioVO item;

	/** The tpsr. */
	private TipoSubservicioVO enti;

	/** The tpss list. */
	private List<TipoSubservicioVO> entiHijasList;

	/** The ssrv map. */
	private Map<Long, PaginatedList<SubservicioVO>> itemHijosMap;

	/** The fecha vigencia. */
	private final Date fechaVigencia;

	/**
	 * Instantiates a new servicio action.
	 */
	public SubservicioAction() {
		super();

		fechaVigencia = new Date();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	// Acciones web
	/**
	 * Detalle.
	 *
	 * @return the string
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	@Actions({
		@Action(value = "ssrv-detalle"),
		@Action(value = "ssrv-detalle-json", results = { @Result(name = "success", type = "json", params = {
				"excludeNullProperties", "true", "ignoreHierarchy", "false" }) }) })
	public String detalle() throws InstanceNotFoundException {
		final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);

		accion = ACCION_EDICION.modificar;
		item = ssrvBO.select(item.getId(), getIdioma());
		enti = TipoSubservicioProxy.select(item.getEntiId());
		entiHijasList = new ArrayList<>();
		itemHijosMap = new HashMap<>();

		if (enti.getEntiHijasList() != null) {
			for (final Long entiId : enti.getEntiHijasList()) {
				final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
				final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

				srvcCriterioVO.setId(item.getSrvc().getId());

				ssrvCriterioVO.setSrvc(srvcCriterioVO);
				ssrvCriterioVO.setPadreId(item.getId());
				ssrvCriterioVO.setEntiId(entiId);
				ssrvCriterioVO.setIdioma(getIdioma());

				itemHijosMap.put(entiId, ssrvBO.selectList(ssrvCriterioVO,
						PaginatedList.getOffset(PaginatedList.FIRST_PAGE, ROWS), ROWS));
				entiHijasList.add(TipoSubservicioProxy.select(entiId));
			}
		}

		LOG.info("Fin de la accion");
		// LOG.info(this);

		return SUCCESS;
	}

	/**
	 * Alta.
	 *
	 * @return the string
	 */
	@Action(value = "ssrv-alta", results = { @Result(name = "success", location = "ssrv-edicion.jsp") })
	public String alta() {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getEntiId());

		accion = ACCION_EDICION.alta;
		enti = TipoSubservicioProxy.select(item.getEntiId());
		item = SubservicioVO.newInstance(enti);

		loadLabelValuesMap();

		return SUCCESS;
	}

	/**
	 * Modificar.
	 *
	 * @return the string
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	@Action(value = "ssrv-modificar", results = { @Result(name = "success", location = "ssrv-edicion.jsp") })
	public String modificar() throws InstanceNotFoundException {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getId());

		accion = ACCION_EDICION.modificar;

		final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);

		item = ssrvBO.select(item.getId(), getIdioma());
		enti = TipoSubservicioProxy.select(item.getEntiId());

		loadLabelValuesMap();

		return SUCCESS;
	}

	/**
	 * Duplicar.
	 *
	 * @return the string
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	@Action(value = "ssrv-duplicar", results = { @Result(name = "success", location = "ssrv-edicion.jsp") })
	public String duplicar() throws InstanceNotFoundException {
		accion = ACCION_EDICION.duplicar;

		final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);

		item = ssrvBO.select(item.getId(), getIdioma());
		enti = TipoSubservicioProxy.select(item.getEntiId());

		loadLabelValuesMap();

		return SUCCESS;
	}

	/**
	 * Guardar.
	 *
	 * @return the string
	 */
	@Action(value = "ssrv-guardar", results = {
			@Result(name = "success", type = "redirectAction", params = { "actionName", "ssrv-detalle", "item.id",
			"%{item.id}" }), @Result(name = "input", location = "ssrv-edicion.jsp") })
	public String guardar() {
		enti = TipoSubservicioProxy.select(item.getEntiId());

		if (accion == ACCION_EDICION.alta) {
			PropertyValidator.validateRequired(this, "item.numero", item.getNumero());
		}

		ItemDatoValidator.validate(this, enti, item);

		if (hasErrors()) {
			return INPUT;
		}

		final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);

		if (accion == ACCION_EDICION.alta) {
			try {
				ssrvBO.insert(item, null);
			} catch (final DuplicateInstanceException ex) {
				addActionError("error.ssrv.duplicado");
			}
		} else {
			try {
				ssrvBO.update(item);
			} catch (final InstanceNotFoundException ex) {
				addActionError("error.ssrv.noencontrado");
			}
		}

		if (hasErrors()) {
			return INPUT;
		}

		return SUCCESS;
	}

	// get / set

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final SubservicioVO getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param value
	 *            the new item
	 */
	public final void setItem(final SubservicioVO value) {
		item = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TipoSubservicioVO getEnti() {
		return enti;
	}

	/**
	 * Gets the enti hijas list.
	 *
	 * @return the enti hijas list
	 */
	public final List<TipoSubservicioVO> getEntiHijasList() {
		return entiHijasList;
	}

	/**
	 * Gets the item hijos map.
	 *
	 * @return the item hijos map
	 */
	public final Map<Long, PaginatedList<SubservicioVO>> getItemHijosMap() {
		return itemHijosMap;
	}

}
