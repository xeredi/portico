package xeredi.integra.model.metamodelo.vo;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaDetailVO.
 */
public final class TipoEstadisticaDetailVO extends AbstractEntidadDetailVO {

    /** The tpes. */
    private TipoEstadisticaVO enti;

    /** The cmag list. */
    private List<CampoAgregacionVO> cmagList;

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoEstadisticaVO getEnti() {
        return enti;
    }

    /**
     * Sets the tpes.
     *
     * @param value
     *            the new tpes
     */
    public void setEnti(final TipoEstadisticaVO value) {
        enti = value;
    }

    /**
     * Gets the cmag list.
     *
     * @return the cmag list
     */
    public List<CampoAgregacionVO> getCmagList() {
        return cmagList;
    }

    /**
     * Sets the cmag list.
     *
     * @param value
     *            the new cmag list
     */
    public void setCmagList(final List<CampoAgregacionVO> value) {
        cmagList = value;
    }

}
