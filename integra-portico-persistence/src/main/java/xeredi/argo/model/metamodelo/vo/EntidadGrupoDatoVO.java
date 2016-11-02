package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nable;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoVO.
 */
@Data
public final class EntidadGrupoDatoVO implements I18nable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.engd;

    /** The enti id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The numero. */
    private Integer numero;

    /** The etiqueta. */
    private String etiqueta;
}
