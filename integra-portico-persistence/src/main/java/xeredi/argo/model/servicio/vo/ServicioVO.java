package xeredi.argo.model.servicio.vo;

import java.util.Date;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioVO.
 */
@Data
public final class ServicioVO extends ItemVO {

    /** The Constant NUMERO_LENGTH. */
    public static final int NUMERO_LENGTH = 5;

    /** The subpuerto. */
    private PuertoVO prto;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /** The falta. */
    private Date falta;

    /** The fbaja. */
    private Date fbaja;

    /** The finicio. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private String estado;

    /**
     * Instantiates a new servicio vo.
     */
    public ServicioVO() {
        super();
    }

    /**
     * Instantiates a new servicio vo.
     *
     * @param entiDetail
     *            the enti detail
     */
    public ServicioVO(final TipoServicioDetailVO entiDetail) {
        super(entiDetail);

        estado = entiDetail.getEnti().getEstadoDef();
    }

    /**
     * Convert numero.
     *
     * @param numero
     *            the numero
     * @return the string
     */
    public static final String convertNumero(final Integer numero) {
        return StringUtils.leftPad(String.valueOf(numero), NUMERO_LENGTH, '0');
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        if ((prto == null || prto.getCodigo() == null) && anno == null && numero == null) {
            return null;
        }

        final StringBuffer buffer = new StringBuffer();

        buffer.append(prto == null ? "-" : prto.getCodigo()).append('/').append(anno).append('/').append(numero);

        return buffer.toString();
    }
}
