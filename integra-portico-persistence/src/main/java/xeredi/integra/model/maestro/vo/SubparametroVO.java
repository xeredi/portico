package xeredi.integra.model.maestro.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.Versionable;
import xeredi.integra.model.item.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroVO.
 */
public final class SubparametroVO extends ItemVO implements Versionable<SubparametroVersionVO> {

    /** The prmt id. */
    private Long prmtId;

    /** The prmt asociado. */
    private ParametroVO prmtAsociado;

    /** The spvr. */
    private SubparametroVersionVO version;

    /** The prto id. */
    private Long prtoId;

    /**
     * Instantiates a new subparametro vo.
     */
    public SubparametroVO() {
        super();

        version = new SubparametroVersionVO();
    }

    /**
     * Instantiates a new subparametro vo.
     *
     * @param entiDetail the enti detail
     */
    public SubparametroVO(TipoSubparametroDetailVO entiDetail) {
		super(entiDetail);

        version = new SubparametroVersionVO();
	}

	/**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        return prmtAsociado == null ? null : prmtAsociado.getEtiqueta();
    }

    /**
     * Gets the prmt id.
     *
     * @return the prmt id
     */
    public Long getPrmtId() {
        return prmtId;
    }

    /**
     * Sets the prmt id.
     *
     * @param value
     *            the new prmt id
     */
    public void setPrmtId(final Long value) {
        prmtId = value;
    }

    /**
     * Gets the prmt asociado.
     *
     * @return the prmt asociado
     */
    public ParametroVO getPrmtAsociado() {
        return prmtAsociado;
    }

    /**
     * Sets the prmt asociado.
     *
     * @param value
     *            the new prmt asociado
     */
    public void setPrmtAsociado(final ParametroVO value) {
        prmtAsociado = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubparametroVersionVO getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVersion(final SubparametroVersionVO value) {
        version = value;
    }

    /**
     * Gets the prto id.
     *
     * @return the prto id
     */
    public final Long getPrtoId() {
        return prtoId;
    }

    /**
     * Sets the prto id.
     *
     * @param value
     *            the new prto id
     */
    public final void setPrtoId(final Long value) {
        prtoId = value;
    }
}
