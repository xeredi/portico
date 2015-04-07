package xeredi.integra.model.metamodelo.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * Datos de una entidad de la aplicación. Padre de Tipos de Parámetro, Subtipos de Parámetro, Tipos de
 * Servicio, Subtipos de Subservicio y Tipos de Estadística.
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

    /** The gis. */
    private boolean gis;

    /** The subpuerto. */
    private boolean puerto;

    /** The max grid. */
    private Integer maxGrid;

    /** The classpath. */
    private String classpath;

    /**
     * Lista de Grupos de Datos de la Entidad (Pestañas) ordenadas por orden de visualización.
     */
    private List<EntidadGrupoDatoVO> engdList;

    /**
     * {@link List} de Ids de tipos de dato asociados a una entidad, ordenados por grupo de dato, fila y orden
     * dentro de la fila.
     */
    private List<EntidadTipoDatoVO> entdList;

    /** {@link List} de identificadores de entidades padre de la entidad. */
    private List<Long> entiPadresList;

    /** {@link List} de identificadores de entidades hija de la entidad. */
    private List<Long> entiHijasList;

    /** {@link List} de acciones web que se pueden realizar sobre la entidad. */
    private List<EntidadAccionVO> enacList;

    /** {@link List} de acciones web que se pueden realizar sobre el grid de la entidad. */
    private List<EntidadAccionGridVO> enagList;

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
    public final String getEtiqueta() {
        if (codigo == null) {
            return null;
        }

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
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public final void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public final String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param value
     *            the new codigo
     */
    public final void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public final TipoEntidad getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the new tipo
     */
    public final void setTipo(final TipoEntidad value) {
        tipo = value;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param value
     *            the new nombre
     */
    public final void setNombre(final String value) {
        nombre = value;
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
     * Checks if get cmd edicion.
     *
     * @return true, if get cmd edicion
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
     * Checks if get cmd duplicado.
     *
     * @return true, if get cmd duplicado
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
     * Gets the max grid.
     *
     * @return the max grid
     */
    public final Integer getMaxGrid() {
        return maxGrid;
    }

    /**
     * Sets the max grid.
     *
     * @param value
     *            the new max grid
     */
    public final void setMaxGrid(final Integer value) {
        maxGrid = value;
    }

    /**
     * Gets the classpath.
     *
     * @return the classpath
     */
    public final String getClasspath() {
        return classpath;
    }

    /**
     * Sets the classpath.
     *
     * @param value
     *            the new classpath
     */
    public final void setClasspath(final String value) {
        classpath = value;
    }

    /**
     * Gets the gis.
     *
     * @return the gis
     */
    public final boolean isGis() {
        return gis;
    }

    /**
     * Sets the gis.
     *
     * @param value
     *            the new gis
     */
    public final void setGis(final boolean value) {
        gis = value;
    }

    /**
     * Gets the subpuerto.
     *
     * @return the subpuerto
     */
    public final boolean isPuerto() {
        return puerto;
    }

    /**
     * Sets the subpuerto.
     *
     * @param value
     *            the new subpuerto
     */
    public final void setPuerto(final boolean value) {
        puerto = value;
    }

    /**
     * Gets the engd list.
     *
     * @return the engd list
     */
    public final List<EntidadGrupoDatoVO> getEngdList() {
        return engdList;
    }

    /**
     * Sets the engd list.
     *
     * @param value
     *            the new engd list
     */
    public final void setEngdList(final List<EntidadGrupoDatoVO> value) {
        engdList = value;
    }

    /**
     * Gets the entd list.
     *
     * @return the entd list
     */
    public final List<EntidadTipoDatoVO> getEntdList() {
        return entdList;
    }

    /**
     * Sets the entd list.
     *
     * @param value
     *            the new entd list
     */
    public final void setEntdList(final List<EntidadTipoDatoVO> value) {
        entdList = value;
    }

    /**
     * Gets the enag list.
     *
     * @return the enag list
     */
    public final List<EntidadAccionGridVO> getEnagList() {
        return enagList;
    }

    /**
     * Sets the enag list.
     *
     * @param value
     *            the new enag list
     */
    public final void setEnagList(final List<EntidadAccionGridVO> value) {
        enagList = value;
    }

    /**
     * Gets the enti padres list.
     *
     * @return the enti padres list
     */
    public final List<Long> getEntiPadresList() {
        return entiPadresList;
    }

    /**
     * Sets the enti padres list.
     *
     * @param value
     *            the new enti padres list
     */
    public final void setEntiPadresList(final List<Long> value) {
        entiPadresList = value;
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public final List<Long> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Sets the enti hijas list.
     *
     * @param value
     *            the new enti hijas list
     */
    public final void setEntiHijasList(final List<Long> value) {
        entiHijasList = value;
    }

    /**
     * Gets the enac list.
     *
     * @return the enac list
     */
    public final List<EntidadAccionVO> getEnacList() {
        return enacList;
    }

    /**
     * Sets the enac list.
     *
     * @param value
     *            the new enac list
     */
    public final void setEnacList(final List<EntidadAccionVO> value) {
        enacList = value;
    }

}
