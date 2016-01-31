package xeredi.argo.model.servicio.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.item.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class SubservicioVO extends ItemVO {

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
