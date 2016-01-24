package xeredi.argo.model.metamodelo.vo;

import java.util.List;
import java.util.Set;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoVO.
 */
@Data
public final class TipoDatoVO {

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
}
