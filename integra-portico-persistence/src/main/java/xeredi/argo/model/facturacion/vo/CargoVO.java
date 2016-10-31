package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVO.
 */
@Data
public final class CargoVO implements Versionable<CargoVersionVO>, I18nable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.crgo;

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
