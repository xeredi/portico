package xeredi.argo.model.metamodelo.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Datos de una entidad de la aplicación. Padre de Tipos de Parámetro, Subtipos de Parámetro, Tipos de
 * Servicio, Subtipos de Subservicio y Tipos de Estadística.
 */
@Data
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
}
