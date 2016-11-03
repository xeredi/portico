package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaVO.
 */
@Data
public final class FacturaVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.fctr;

    /** The Constant NUMERO_LENGTH. */
    private static final int NUMERO_LENGTH = 5;

    /** The id. */
    private Long id;

    /** The aspc. */
    private AspectoVO aspc;

    /** The pagador. */
    private ParametroVO pagador;

    /** The fcsr. */
    private FacturaSerieVO fcsr;

    /** The numero. */
    private Integer numero;

    /** The falta. */
    private Date falta;

    /** The fref. */
    private Date fref;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The estado. */
    private FacturaEstado estado;

    /** The suj pasivo. */
    private Boolean sujPasivo;

    /** The importe. */
    private Double importe;

    /** The impuesto. */
    private Double impuesto;

    /** The fctr anulada. */
    private FacturaVO fctrAnulada;

    /** The info1. */
    private String info1;

    /** The info2. */
    private String info2;

    /** The info3. */
    private String info3;

    /** The info4. */
    private String info4;

    /** The info5. */
    private String info5;

    /** The info6. */
    private String info6;

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        final StringBuilder etiqueta = new StringBuilder();

        if (fcsr != null) {
            etiqueta.append(fcsr.getSerie()).append('/').append(fcsr.getAnio()).append('/');
        }

        etiqueta.append(StringUtils.leftPad(String.valueOf(numero), NUMERO_LENGTH, '0'));

        return etiqueta.toString();
    }
}
