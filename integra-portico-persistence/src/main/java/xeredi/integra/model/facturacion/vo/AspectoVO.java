package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.Versionable;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoVO.
 */
public final class AspectoVO implements Versionable<AspectoVersionVO> {
    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The aspv. */
    private AspectoVersionVO version;

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

        if (version != null && version.getDescripcion() != null) {
            buffer.append(" - ").append(version.getDescripcion());
        }

        return buffer.toString();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the id
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
     * {@inheritDoc}
     */
    @Override
    public AspectoVersionVO getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVersion(final AspectoVersionVO value) {
        version = value;
    }
}
