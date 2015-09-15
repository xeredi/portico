package xeredi.integra.model.servicio.vo;

import xeredi.integra.model.comun.vo.BaseCriterioVO;
import xeredi.integra.model.item.vo.ItemTypeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioLupaCriterioVO.
 */
public final class ServicioLupaCriterioVO extends BaseCriterioVO implements ItemTypeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The enti id. */
    private Long entiId;

    /** The subpuerto. */
    private String subpuerto;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    @Override
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value
     *            the new enti id
     */
    @Override
    public void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the subpuerto.
     *
     * @return the subpuerto
     */
    public String getSubpuerto() {
        return subpuerto;
    }

    /**
     * Sets the subpuerto.
     *
     * @param value
     *            the new subpuerto
     */
    public void setSubpuerto(final String value) {
        subpuerto = value;
    }

    /**
     * Gets the anno.
     *
     * @return the anno
     */
    public String getAnno() {
        return anno;
    }

    /**
     * Sets the anno.
     *
     * @param value
     *            the new anno
     */
    public void setAnno(final String value) {
        anno = value;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param value
     *            the new numero
     */
    public void setNumero(final String value) {
        numero = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTextoBusqueda(final String value) {
        textoBusqueda = value;
    }
}
