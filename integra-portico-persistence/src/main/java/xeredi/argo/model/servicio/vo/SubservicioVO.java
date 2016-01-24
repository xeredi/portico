package xeredi.argo.model.servicio.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioVO.
 */
@Data
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
     * Instantiates a new subservicio vo.
     */
    public SubservicioVO() {
        super();
    }

    /**
     * Instantiates a new subservicio vo.
     *
     * @param entiDetail
     *            the enti detail
     */
    public SubservicioVO(final TipoSubservicioDetailVO entiDetail) {
        super(entiDetail);

        estado = entiDetail.getEnti().getEstadoDef();
    }

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
