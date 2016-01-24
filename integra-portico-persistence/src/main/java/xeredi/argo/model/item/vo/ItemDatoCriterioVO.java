package xeredi.argo.model.item.vo;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadDatoCriterioVO.
 */
@Data
public final class ItemDatoCriterioVO {

    /** The endt id. */
    private Long itemId;

    /** The endt ids. */
    private Set<Long> itemIds;

    /** The tpdt. */
    private Long tpdtId;

    /** The cantidad entera. */
    private Long cantidadEntera;

    /** The cantidad entera min. */
    private Long cantidadEnteraMin;

    /** The cantidad entera max. */
    private Long cantidadEnteraMax;

    /** The cantidad decimal. */
    private Double cantidadDecimal;

    /** The cantidad decimal min. */
    private Double cantidadDecimalMin;

    /** The cantidad decimal max. */
    private Double cantidadDecimalMax;

    /** The fecha. */
    private Date fecha;

    /** The fecha min. */
    private Date fechaMin;

    /** The fecha max. */
    private Date fechaMax;

    /** The cadena. */
    private Set<String> cadenas;

    /** The cadena. */
    private String cadena;

    /** The prmt id. */
    private ParametroVO prmt;

    /** The srvc id. */
    private ServicioVO srvc;

    /**
     * Gets the booleano.
     *
     * @return the booleano
     */
    public Boolean getBooleano() {
        return cantidadEntera == null ? null : 1 == cantidadEntera;
    }

    /**
     * Sets the booleano.
     *
     * @param value
     *            the new booleano
     */
    public void setBooleano(final String value) {
        if (value != null && !value.isEmpty()) {
            cantidadEntera = Boolean.TRUE.toString().equals(value) ? 1L : 0L;
        }
    }
}
