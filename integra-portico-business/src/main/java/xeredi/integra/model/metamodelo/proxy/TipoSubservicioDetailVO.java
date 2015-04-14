package xeredi.integra.model.metamodelo.proxy;

import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioDetailVO.
 */
public final class TipoSubservicioDetailVO extends AbstractEntidadDetailVO {

    /** The tpss. */
    private TipoSubservicioVO enti;

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoSubservicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the tpss.
     *
     * @param value
     *            the new tpss
     */
    public void setEnti(final TipoSubservicioVO value) {
        enti = value;
    }

}
