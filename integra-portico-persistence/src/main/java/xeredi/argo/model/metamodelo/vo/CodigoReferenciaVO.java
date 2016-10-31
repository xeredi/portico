package xeredi.argo.model.metamodelo.vo;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nable;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaVO.
 */

/**
 * Instantiates a new codigo referencia VO.
 */
@Data
public final class CodigoReferenciaVO implements I18nable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.cdrf;

    /** The id. */
    private Long id;

    /** The dominio id. */
    private Long tpdtId;

    /** The valor. */
    private String valor;

    /** The orden. */
    private Integer orden;

    /** The texto. */
    private String texto;

    /**
     * {@inheritDoc}
     */
    public String getEtiqueta() {
        if (valor == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();

        builder.append(valor);

        if (texto != null) {
            builder.append(" - ").append(texto);
        }

        return builder.toString();
    }
}
