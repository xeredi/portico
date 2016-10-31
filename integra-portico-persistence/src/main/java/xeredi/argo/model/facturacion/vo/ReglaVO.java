package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaVO.
 */
@Data
public final class ReglaVO implements Versionable<ReglaVersionVO>, I18nable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.rgla;

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The enti. */
    private EntidadVO enti;

    /** The tipo. */
    private ReglaTipo tipo;

    /** The crgo. */
    private CargoVO crgo;

    /** The rglv. */
    private ReglaVersionVO version;

    /** The fref. */
    private Date fref;

    /** The texto. */
    private String texto;

    /**
     * Instantiates a new regla vo.
     */
    public ReglaVO() {
        super();

        version = new ReglaVersionVO();
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        final StringBuffer buffer = new StringBuffer();

        if (codigo != null) {
            buffer.append(codigo);
        }

        if (texto != null) {
            buffer.append(" - ").append(texto);
        }

        return buffer.length() == 0 ? null : buffer.toString();
    }
}
