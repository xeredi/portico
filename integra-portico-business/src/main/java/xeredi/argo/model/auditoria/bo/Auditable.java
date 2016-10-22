package xeredi.argo.model.auditoria.bo;

import xeredi.argo.model.auditoria.vo.AuditoriaPrefijoEntidad;

// TODO: Auto-generated Javadoc
/**
 * The Interface Auditable.
 */
public interface Auditable {

    /**
     * Gets the usro id.
     *
     * @return the usro id
     */
    Long getUsroId();

    /**
     * Gets the prefijo entidad.
     *
     * @return the prefijo entidad
     */
    AuditoriaPrefijoEntidad getPrefijoEntidad();
}
