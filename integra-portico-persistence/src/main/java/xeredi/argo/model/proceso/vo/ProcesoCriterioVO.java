package xeredi.argo.model.proceso.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ProcesoCriterioVO extends BaseCriterioVO {

    /**
     * The Enum OrderByColumns.
     */
    public enum ProcesoOrderByColumn {
        /** The prbt pk. */
        prbt_pk,
        /** The prbt usro pk. */
        prbt_usro_pk,
        /** The prbt modulo. */
        prbt_modulo,
        /** The prbt tipo. */
        prbt_tipo,
        /** The prbt estado. */
        prbt_estado,
        /** The prbt falta. */
        prbt_falta,
        /** The prbt finicio. */
        prbt_finicio,
        /** The prbt ffin. */
        prbt_ffin,
        /** The prbt errores cnt. */
        prbt_errores_cnt,
        /** The prbt alertas cnt. */
        prbt_alertas_cnt,
        /** The prbt mensajes cnt. */
        prbt_mensajes_cnt
    }

    /** The id. */
    private Long id;

    /** The modulo. */
    private ProcesoModulo modulo;

    /** The tipo. */
    private ProcesoTipo tipo;

    /** The estado. */
    private ProcesoEstado estado;

    /** The falta min. */
    private Date faltaMin;

    /** The falta max. */
    private Date faltaMax;
}
