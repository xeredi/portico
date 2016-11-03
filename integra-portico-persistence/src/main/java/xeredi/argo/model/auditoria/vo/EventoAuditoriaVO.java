package xeredi.argo.model.auditoria.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * CambioAuditoriaVO.
 */
@Data
public final class EventoAuditoriaVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.evau;

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
