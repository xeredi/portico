package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Modelable;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionVO.
 */
@Data
public final class CampoAgregacionVO implements Modelable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.cmag;

    /** The tpes id. */
    private Long tpesId;

    /** The entd. */
    private EntidadTipoDatoVO entd;

    /** The agregar. */
    private Boolean agregar;

    /** The nombre. */
    private String nombre;
}
