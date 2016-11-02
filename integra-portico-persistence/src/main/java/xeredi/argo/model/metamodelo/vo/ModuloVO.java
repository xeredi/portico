package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nable;

// TODO: Auto-generated Javadoc
/**
 * ModuloVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ModuloVO extends FuncionalidadVO implements I18nable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.mdlo;

    /** The codigo. */
    private String codigo;

    /** The etiqueta. */
    private String etiqueta;
}
