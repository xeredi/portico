package xeredi.argo.model.auditoria.vo;

import java.util.Date;

import xeredi.argo.model.seguridad.vo.UsuarioVO;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * CambioAuditoriaVO.
 */
@Data
public final class EventoAuditoriaVO {

    /** The id. */
    private Long id;

    /** The fecha. */
    private Date fecha;

    /** The accion. */
    private AuditoriaAccion accion;

    /** The prefijo entidad. */
    private AuditoriaPrefijoEntidad prefijoEntidad;

    /** The usro. */
    private UsuarioVO usro;
}
