package xeredi.integra.model.metamodelo.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaVO.
 */
public final class TipoEstadisticaVO extends EntidadVO {

    /** The cmag list. */
    private List<CampoAgregacionVO> cmagList;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
