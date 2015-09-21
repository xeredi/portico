package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaVO.
 */
public final class ReglaVO implements Versionable<ReglaVersionVO> {

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The enti. */
    private EntidadVO enti;

    /** The tipo. */
    private ReglaTipo tipo;

    /** The crgo. */
    private CargoVO crgo;

    /** The rglv. */
    private ReglaVersionVO version;

    /** The fref. */
    private Date fref;

    /**
     * Instantiates a new regla vo.
     */
    public ReglaVO() {
        super();

        version = new ReglaVersionVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * Gets the crgo.
     *
     * @return the crgo
     */
    public CargoVO getCrgo() {
        return crgo;
    }

    /**
     * Sets the crgo.
     *
     * @param value
     *            the crgo
     */
    public void setCrgo(final CargoVO value) {
        crgo = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReglaVersionVO getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVersion(final ReglaVersionVO value) {
        version = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public EntidadVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(final EntidadVO value) {
        enti = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ReglaTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the tipo
     */
    public void setTipo(final ReglaTipo value) {
        tipo = value;
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
