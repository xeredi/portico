package xeredi.integra.model.comun.vo;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteCriterioVO.
 */
public abstract class ItemTramiteCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public final void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }
}
