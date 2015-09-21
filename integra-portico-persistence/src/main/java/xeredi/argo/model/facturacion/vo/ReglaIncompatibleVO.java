package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleVO.
 */
public final class ReglaIncompatibleVO implements Versionable<ReglaIncompatibleVersionVO> {

    /** The id. */
    private Long id;

    /** The rgla1 id. */
    private Long rgla1Id;

    /** The rgla2. */
    private ReglaVO rgla2;

    /** The rgiv. */
    private ReglaIncompatibleVersionVO version;

    /** The fref. */
    private Date fref;

    /**
     * Instantiates a new regla incompatible vo.
     */
    public ReglaIncompatibleVO() {
        super();

        version = new ReglaIncompatibleVersionVO();
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
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the rgla1 id.
     *
     * @return the rgla1 id
     */
    public Long getRgla1Id() {
        return rgla1Id;
    }

    /**
     * Sets the rgla1 id.
     *
     * @param value
     *            the new rgla1 id
     */
    public void setRgla1Id(final Long value) {
        rgla1Id = value;
    }

    /**
     * Gets the rgla2.
     *
     * @return the rgla2
     */
    public ReglaVO getRgla2() {
        return rgla2;
    }

    /**
     * Sets the rgla2.
     *
     * @param value
     *            the new rgla2
     */
    public void setRgla2(final ReglaVO value) {
        rgla2 = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReglaIncompatibleVersionVO getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVersion(final ReglaIncompatibleVersionVO value) {
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
