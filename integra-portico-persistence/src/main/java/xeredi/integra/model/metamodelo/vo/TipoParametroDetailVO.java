package xeredi.integra.model.metamodelo.vo;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroDetailVO.
 */
public final class TipoParametroDetailVO extends AbstractEntidadDetailVO {

    /** The tppr. */
    private TipoParametroVO enti;

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoParametroVO getEnti() {
        return enti;
    }

    /**
     * Sets the tppr.
     *
     * @param value
     *            the new tppr
     */
    public void setEnti(final TipoParametroVO value) {
        enti = value;
    }

}
