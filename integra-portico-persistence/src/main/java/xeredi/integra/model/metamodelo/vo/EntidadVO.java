package xeredi.integra.model.metamodelo.vo;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * Datos de una entidad de la aplicación. Padre de Tipos de Parámetro, Subtipos
 * de Parámetro, Tipos de Servicio, Subtipos de Subservicio y Tipos de
 * Estadística.
 */
public class EntidadVO {

	/** Identificador único de entidad. */
	private Long id;

	/** Código único de entidad. */
	private String codigo;

	/** Tipo de entidad. */
	private TipoEntidad tipo;

	/** Nombre de la entidad. */
	private String nombre;

	/** The cmd alta. */
	private boolean cmdAlta;

	/** The cmd baja. */
	private boolean cmdBaja;

	/** The cmd edicion. */
	private boolean cmdEdicion;

	/** The cmd duplicado. */
	private boolean cmdDuplicado;

	/**
	 * Lista de Grupos de Datos de la Entidad (Pestañas) ordenadas por orden de
	 * visualización.
	 */
	private List<Integer> engdList;

	/**
	 * Map de Grupos de Datos de la Entidad (Pestañas), indexados por
	 * identificador de Grupo de Datos.
	 */
	private Map<Integer, EntidadGrupoDatoVO> engdMap;

	/**
	 * Map de datos asociados a cada una de las pestañas de la entidad. FIXME
	 * Implementar!!!
	 */
	private Map<Integer, List<Long>> engdEntdMap;

	/**
	 * {@link List} de Ids de tipos de dato asociados a una entidad, ordenados
	 * por grupo de dato, fila y orden dentro de la fila.
	 */
	private List<Long> entdList;

	/**
	 * {@link List} de Ids de tipos de dato asociados a una entidad que se
	 * muestran en grid, ordenados por grupo de dato, fila y orden dentro de la
	 * fila.
	 */
	private List<Long> entdGridList;

	/**
	 * {@link Map} de tipos de dato asociados a una entidad, indexados por el
	 * identificador de tipo de dato.
	 */
	private Map<Long, EntidadTipoDatoVO> entdMap;

	/** {@link List} de identificadores de entidades padre de la entidad. */
	private List<Long> entiPadresList;

	/** {@link List} de identificadores de entidades hija de la entidad. */
	private List<Long> entiHijasList;

	/** {@link List} de acciones web que se pueden realizar sobre la entidad. */
	private List<EntidadAccionVO> enacList;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Gets the etiqueta.
	 * 
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		final StringBuffer buffer = new StringBuffer();

		buffer.append(codigo);

		if (nombre != null) {
			buffer.append(" - ");
			buffer.append(nombre);
		}

		return buffer.toString();
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param value
	 *            the new id
	 */
	public void setId(final Long value) {
		id = value;
	}

	/**
	 * Gets the codigo.
	 * 
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 * 
	 * @param value
	 *            the new codigo
	 */
	public void setCodigo(final String value) {
		codigo = value;
	}

	/**
	 * Gets the tipo.
	 * 
	 * @return the tipo
	 */
	public TipoEntidad getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 * 
	 * @param value
	 *            the new tipo
	 */
	public void setTipo(final TipoEntidad value) {
		tipo = value;
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param value
	 *            the new nombre
	 */
	public void setNombre(final String value) {
		nombre = value;
	}

	/**
	 * Gets the engd list.
	 * 
	 * @return the engd list
	 */
	public List<Integer> getEngdList() {
		return engdList;
	}

	/**
	 * Sets the engd list.
	 * 
	 * @param value
	 *            the new engd list
	 */
	public void setEngdList(final List<Integer> value) {
		engdList = value;
	}

	/**
	 * Gets the engd map.
	 * 
	 * @return the engd map
	 */
	public Map<Integer, EntidadGrupoDatoVO> getEngdMap() {
		return engdMap;
	}

	/**
	 * Sets the engd map.
	 * 
	 * @param value
	 *            the value
	 */
	public void setEngdMap(final Map<Integer, EntidadGrupoDatoVO> value) {
		engdMap = value;
	}

	/**
	 * Gets the entd list.
	 * 
	 * @return the entd list
	 */
	public List<Long> getEntdList() {
		return entdList;
	}

	/**
	 * Sets the entd list.
	 * 
	 * @param value
	 *            the new entd list
	 */
	public void setEntdList(final List<Long> value) {
		entdList = value;
	}

	/**
	 * Gets the entd map.
	 * 
	 * @return the entd map
	 */
	public Map<Long, EntidadTipoDatoVO> getEntdMap() {
		return entdMap;
	}

	/**
	 * Sets the entd map.
	 * 
	 * @param value
	 *            the value
	 */
	public void setEntdMap(final Map<Long, EntidadTipoDatoVO> value) {
		entdMap = value;
	}

	/**
	 * Gets the enti padres list.
	 * 
	 * @return the enti padres list
	 */
	public List<Long> getEntiPadresList() {
		return entiPadresList;
	}

	/**
	 * Sets the enti padres list.
	 * 
	 * @param value
	 *            the new enti padres list
	 */
	public void setEntiPadresList(final List<Long> value) {
		entiPadresList = value;
	}

	/**
	 * Gets the enti hijas list.
	 * 
	 * @return the enti hijas list
	 */
	public List<Long> getEntiHijasList() {
		return entiHijasList;
	}

	/**
	 * Sets the enti hijas list.
	 * 
	 * @param value
	 *            the new enti hijas list
	 */
	public void setEntiHijasList(final List<Long> value) {
		entiHijasList = value;
	}

	/**
	 * Gets the enac list.
	 * 
	 * @return the enac list
	 */
	public List<EntidadAccionVO> getEnacList() {
		return enacList;
	}

	/**
	 * Sets the enac list.
	 * 
	 * @param value
	 *            the new enac list
	 */
	public void setEnacList(final List<EntidadAccionVO> value) {
		enacList = value;
	}

	/**
	 * Gets the engd entd map.
	 * 
	 * @return the engd entd map
	 */
	public final Map<Integer, List<Long>> getEngdEntdMap() {
		return engdEntdMap;
	}

	/**
	 * Sets the engd entd map.
	 * 
	 * @param value
	 *            the value
	 */
	public final void setEngdEntdMap(final Map<Integer, List<Long>> value) {
		engdEntdMap = value;
	}

	/**
	 * Checks if is cmd alta.
	 * 
	 * @return true, if is cmd alta
	 */
	public final boolean isCmdAlta() {
		return cmdAlta;
	}

	/**
	 * Sets the cmd alta.
	 * 
	 * @param value
	 *            the new cmd alta
	 */
	public final void setCmdAlta(final boolean value) {
		cmdAlta = value;
	}

	/**
	 * Checks if is cmd baja.
	 * 
	 * @return true, if is cmd baja
	 */
	public final boolean isCmdBaja() {
		return cmdBaja;
	}

	/**
	 * Sets the cmd baja.
	 * 
	 * @param value
	 *            the new cmd baja
	 */
	public final void setCmdBaja(final boolean value) {
		cmdBaja = value;
	}

	/**
	 * Checks if is cmd edicion.
	 * 
	 * @return true, if is cmd edicion
	 */
	public final boolean isCmdEdicion() {
		return cmdEdicion;
	}

	/**
	 * Sets the cmd edicion.
	 * 
	 * @param value
	 *            the new cmd edicion
	 */
	public final void setCmdEdicion(final boolean value) {
		cmdEdicion = value;
	}

	/**
	 * Checks if is cmd duplicado.
	 * 
	 * @return true, if is cmd duplicado
	 */
	public final boolean isCmdDuplicado() {
		return cmdDuplicado;
	}

	/**
	 * Sets the cmd duplicado.
	 * 
	 * @param value
	 *            the new cmd duplicado
	 */
	public final void setCmdDuplicado(final boolean value) {
		cmdDuplicado = value;
	}

	/**
	 * Gets the entd grid list.
	 * 
	 * @return the entd grid list
	 */
	public final List<Long> getEntdGridList() {
		return entdGridList;
	}

	/**
	 * Sets the entd grid list.
	 * 
	 * @param value
	 *            the new entd grid list
	 */
	public final void setEntdGridList(final List<Long> value) {
		entdGridList = value;
	}

}
