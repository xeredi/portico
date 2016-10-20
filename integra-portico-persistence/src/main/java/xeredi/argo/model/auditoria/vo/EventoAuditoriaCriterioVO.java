package xeredi.argo.model.auditoria.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * EventoAuditoriaCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class EventoAuditoriaCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The fecha minimo. */
    private Date fechaMinimo;

    /** The fecha maximo. */
    private Date fechaMaximo;

    /** The usro. */
    private UsuarioVO usro;

    /** The accion set. */
    private Set<AuditoriaAccion> accionSet = new HashSet<>();

    /** The prefijo entidad set. */
    private Set<AuditoriaPrefijoEntidad> prefijoEntidadSet = new HashSet<>();


}
