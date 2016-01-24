package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoVO.
 */
@Data
public final class AspectoVO implements Versionable<AspectoVersionVO> {
    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The aspv. */
    private AspectoVersionVO version;

    /** The fref. */
    private Date fref;

    /**
     * Instantiates a new aspecto vo.
     */
    public AspectoVO() {
        super();

        version = new AspectoVersionVO();
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        if (codigo == null) {
            return null;
        }

        final StringBuffer buffer = new StringBuffer();

        buffer.append(codigo);

        if (version != null && version.getDescripcion() != null) {
            buffer.append(" - ").append(version.getDescripcion());
        }

        return buffer.toString();
    }
}
