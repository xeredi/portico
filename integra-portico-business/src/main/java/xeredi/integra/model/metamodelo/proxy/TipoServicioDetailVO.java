package xeredi.integra.model.metamodelo.proxy;

import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioDetailVO.
 */
public final class TipoServicioDetailVO extends AbstractEntidadDetailVO {

    /** The tpsr. */
    private TipoServicioVO enti;

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoServicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the tpsr.
     *
     * @param value
     *            the new tpsr
     */
    public void setEnti(final TipoServicioVO value) {
        enti = value;
    }

}
