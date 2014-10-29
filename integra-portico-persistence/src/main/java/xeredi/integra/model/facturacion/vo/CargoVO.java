package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVO.
 */
public final class CargoVO {

    /** The ig. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The crgv. */
    private CargoVersionVO crgv;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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

        if (crgv != null && crgv.getDescripcion() != null) {
            buffer.append(" - ").append(crgv.getDescripcion());
        }

        return buffer.toString();
    }

    /**
     * Gets the ig.
     *
     * @return the ig
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ig.
     *
     * @param value
     *            the ig
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param value
     *            the codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the tpsr.
     *
     * @return the tpsr
     */
    public TipoServicioVO getTpsr() {
        return tpsr;
    }

    /**
     * Sets the tpsr.
     *
     * @param value
     *            the tpsr
     */
    public void setTpsr(final TipoServicioVO value) {
        tpsr = value;
    }

    /**
     * Gets the crgv.
     *
     * @return the crgv
     */
    public CargoVersionVO getCrgv() {
        return crgv;
    }

    /**
     * Sets the crgv.
     *
     * @param value
     *            the crgv
     */
    public void setCrgv(final CargoVersionVO value) {
        crgv = value;
    }

}
