package xeredi.argo.model.metamodelo.vo;

import java.util.List;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nable;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoVO.
 */

/**
 * Instantiates a new tipo dato VO.
 */
@Data
public final class TipoDatoVO implements I18nable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.tpdt;

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The tpht. */
    private TipoHtml tpht;

    /** The tppr. */
    private EntidadVO enti;

    /** The tipo elemento. */
    private TipoElemento tipoElemento;

    /** Lista de Codigos de Referencia (solo si el tipo de elemento es 'R'). */
    private List<CodigoReferenciaVO> cdrfList;

    /** The cdrf code set. */
    private Set<String> cdrfCodeSet;

    /**
     * {@inheritDoc}
     */
    public String getEtiqueta() {
        if (codigo == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();

        builder.append(codigo);

        if (nombre != null) {
            builder.append(" - ").append(nombre);
        }

        return builder.toString();
    }
}
