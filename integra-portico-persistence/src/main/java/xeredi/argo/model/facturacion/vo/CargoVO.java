package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVO.
 */
public final class CargoVO implements Versionable<CargoVersionVO> {

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
     * {@inheritDoc}
     */
    @Override
    public CargoVersionVO getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVersion(final CargoVersionVO value) {
        version = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFref() {
        return fref;
    }

    /**
     * Sets the fref.
     *
     * @param value
     *            the new fref
     */
    public void setFref(final Date value) {
        fref = value;
    }
}
