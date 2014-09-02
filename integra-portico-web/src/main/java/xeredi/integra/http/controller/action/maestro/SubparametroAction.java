package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.Subparametro;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroAction.
 */
public final class SubparametroAction extends ItemAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2326503947837608186L;

	/** The item. */
	private SubparametroVO item;

	/** The enti. */
	private TipoSubparametroVO enti;

	/** The fecha vigencia. */
	private final Date fechaVigencia;

	/** The prmt asociado list. */
	private List<LabelValueVO> prmtAsociadoList;

	/**
	 * Instantiates a new subparametro action.
	 */
	public SubparametroAction() {
		super();
		fechaVigencia = Calendar.getInstance().getTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	// Acciones Web

	/**
	 * Alta.
	 *
	 * @return the string
	 */
	@Actions({ @Action(value = "sprm-alta", results = { @Result(name = "success", location = "sprm-edicion.jsp") }),
		@Action(value = "sprm-alta-popup", results = { @Result(name = "success", location = "sprm-edicion.jsp") }) })
	public String alta() {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getEntiId());
		Preconditions.checkNotNull(item.getPrmtId());

		accion = ACCION_EDICION.alta;
		enti = TipoSubparametroProxy.select(item.getEntiId());

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
	@Actions({
		@Action(value = "sprm-modificar", results = { @Result(name = "success", location = "sprm-edicion.jsp") }),
		@Action(value = "sprm-modificar-popup", results = { @Result(name = "success", location = "sprm-edicion.jsp") }) })
	public String modificar() throws InstanceNotFoundException {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getId());

		accion = ACCION_EDICION.modificar;

		final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);
		final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

		sprmCriterioVO.setId(item.getId());
		sprmCriterioVO.setFechaVigencia(fechaVigencia);
		sprmCriterioVO.setIdioma(getIdioma());

		item = sprmBO.selectObject(sprmCriterioVO);
		enti = TipoSubparametroProxy.select(item.getEntiId());

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
	@Actions({
		@Action(value = "sprm-duplicar", results = { @Result(name = "success", location = "sprm-edicion.jsp") }),
		@Action(value = "sprm-duplicar-popup", results = { @Result(name = "success", location = "sprm-edicion.jsp") }) })
	public String duplicar() throws InstanceNotFoundException {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getId());

		accion = ACCION_EDICION.duplicar;

		final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);
		final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

		sprmCriterioVO.setId(item.getId());
		sprmCriterioVO.setFechaVigencia(fechaVigencia);
		sprmCriterioVO.setIdioma(getIdioma());

		item = sprmBO.selectObject(sprmCriterioVO);
		enti = TipoSubparametroProxy.select(item.getEntiId());

		loadLabelValuesMap();

		return SUCCESS;
	}

	/**
	 * Guardar.
	 *
	 * @return the string
	 */
	@Action(value = "sprm-guardar", results = {
			@Result(name = "success", type = "redirectAction", params = { "actionName", "prmt-detalle", "item.id",
			"%{item.prmtId}" }), @Result(name = "input", location = "sprm-edicion.jsp") })
	public String guardar() {
		Preconditions.checkNotNull(item);

		final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);

		enti = TipoSubparametroProxy.select(item.getEntiId());

		// Validacion de Datos
		if (accion == ACCION_EDICION.alta) {
			PropertyValidator.validateRequired(this, "prmtAsociado", item.getPrmtAsociado());
		} else {
			PropertyValidator.validateRequired(this, "id", item.getId());
			PropertyValidator.validateRequired(this, "spvr.id", item.getSpvr().getId());
		}

		if (enti.isTempExp()) {
			PropertyValidator.validateRequired(this, "spvr.finicio", item.getSpvr().getFinicio());
		} else {
			if (accion == ACCION_EDICION.alta) {
				item.getSpvr().setFinicio(Calendar.getInstance().getTime());
			}
		}

		ItemDatoValidator.validate(this, enti, item);

		// Fin de validacion de datos

		if (hasErrors()) {
			return INPUT;
		}

		try {
			switch (accion) {
			case alta:
				sprmBO.insert(item, enti);

				break;
			case modificar:
				sprmBO.update(item, enti);

				break;
			case duplicar:
				sprmBO.duplicate(item, enti);

				break;

			default:
				throw new Error("Accion no valida: " + accion);
			}

			addActionMessage("Subparametro guardado correctamente!!");
		} catch (final DuplicateInstanceException ex) {
			addFieldError("prmt.parametro", getText("error.prmt.duplicate"));
		}

		if (hasErrors()) {
			return INPUT;
		}

		return SUCCESS;
	}

	/**
	 * Borrar.
	 *
	 * @return the string
	 */
	@Action(value = "sprm-borrar", results = { @Result(name = "success", type = "redirectAction", params = {
			"actionName", "prmt-detalle", "item.id", "%{item.prmtId}" }) })
	public String borrar() {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getEntiId());

		if (item.getSpvr() == null || item.getSpvr().getId() == null) {
			throw new Error("Identificador de version del subparametro no especificado");
		}

		final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);

		enti = TipoSubparametroProxy.select(item.getEntiId());

		try {
			sprmBO.delete(item.getSpvr().getId(), enti);

			addActionMessage("Elemento del Maestro '" + enti.getNombre() + "' eliminado correctamente");
		} catch (final InstanceNotFoundException ex) {
			addActionError(getText("error.sprm.notFound"));
		}

		return SUCCESS;
	}

	/**
	 * Detalle.
	 *
	 * @return the string
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	@Actions({ @Action(value = "sprm-detalle"), @Action(value = "sprm-detalle-popup") })
	public String detalle() throws InstanceNotFoundException {
		Preconditions.checkNotNull(item);
		Preconditions.checkNotNull(item.getId());

		final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);
		final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

		sprmCriterioVO.setId(item.getId());
		sprmCriterioVO.setFechaVigencia(fechaVigencia);
		sprmCriterioVO.setIdioma(getIdioma());

		item = sprmBO.selectObject(sprmCriterioVO);
		enti = TipoSubparametroProxy.select(item.getEntiId());

		return SUCCESS;
	}

	// get / set

	/**
	 * Gets the prmt asociado list.
	 *
	 * @return the prmt asociado list
	 */
	public List<LabelValueVO> getPrmtAsociadoList() {
		if (prmtAsociadoList == null) {
			final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);

			final Set<Long> tpprIds = new HashSet<>();

			tpprIds.add(enti.getTpprAsociado().getId());
			prmtAsociadoList = prmtBO.selectLabelValues(tpprIds, fechaVigencia, getIdioma()).get(
					enti.getTpprAsociado().getId());
		}

		return prmtAsociadoList;
	}

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
	public TipoSubparametroVO getEnti() {
		return enti;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SubparametroVO getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param value
	 *            the new item
	 */
	public void setItem(final SubparametroVO value) {
		item = value;
	}

}
