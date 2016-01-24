package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVO.
 */
@Data
public final class CargoVO implements Versionable<CargoVersionVO> {

    /** The ig. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The crgv. */
    private CargoVersionVO version;

    /** The fref. */
    private Date fref;

    /**
     * Instantiates a new cargo vo.
     */
    public CargoVO() {
        super();

        version = new CargoVersionVO();
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
