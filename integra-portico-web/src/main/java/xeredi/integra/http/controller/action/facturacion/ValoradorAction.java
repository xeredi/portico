package xeredi.integra.http.controller.action.facturacion;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorAction.
 */
public final class ValoradorAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3003393076467187485L;

	/** The srvc. */
	private ServicioVO srvc;

	/** The fliq. */
	private Date fliq;

	/** The crgo ids. */
	private Set<Long> crgoIds;

	// Acciones web

	/**
	 * Prepare.
	 *
	 * @return the string
	 */
	@Action("vldr-prepare")
	public String prepare() {
		Preconditions.checkNotNull(srvc);
		Preconditions.checkNotNull(srvc.getId());
		Preconditions.checkNotNull(srvc.getEntiId());

		return SUCCESS;
	}

	// get / set

	/** The crgo list. */
	private List<CargoVO> crgoList;

	/**
	 * Gets the srvc.
	 *
	 * @return the srvc
	 */
	public ServicioVO getSrvc() {
		return srvc;
	}

	/**
	 * Sets the srvc.
	 *
	 * @param value
	 *            the new srvc
	 */
	public void setSrvc(ServicioVO value) {
		this.srvc = value;
	}

	/**
	 * Gets the fliq.
	 *
	 * @return the fliq
	 */
	public Date getFliq() {
		return fliq;
	}

	/**
	 * Sets the fliq.
	 *
	 * @param value
	 *            the new fliq
	 */
	public void setFliq(Date value) {
		this.fliq = value;
	}

	/**
	 * Gets the crgo list.
	 *
	 * @return the crgo list
	 */
	public List<CargoVO> getCrgoList() {
		return crgoList;
	}

	/**
	 * Sets the crgo ids.
	 *
	 * @param value
	 *            the new crgo ids
	 */
	public void setCrgoIds(Set<Long> value) {
		this.crgoIds = value;
	}

}
