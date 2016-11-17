package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.item.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioVO.
 */

/**
 * Instantiates a new subservicio VO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class SubservicioVO extends ItemVO implements I18nable {

    /** The srvc id. */
    private ServicioVO srvc;

    /** The numero. */
    private Integer numero;

    /** The finicio. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private String estado;

    /** The ssrv padre map. */
    private Map<Long, SubservicioVO> ssrvPadreMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        if (srvc == null || srvc.getId() == null) {
            return null;
        }

        final StringBuffer buffer = new StringBuffer();

        if (srvc != null) {
            buffer.append(srvc.getEtiqueta());
            buffer.append(" - ");
        }

        buffer.append(numero);

        return buffer.toString();
    }
}
