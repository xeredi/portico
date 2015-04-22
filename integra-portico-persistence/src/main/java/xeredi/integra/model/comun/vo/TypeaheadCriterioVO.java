package xeredi.integra.model.comun.vo;

// TODO: Auto-generated Javadoc
/**
 * The Class TypeaheadCriterioVO.
 */
public abstract class TypeaheadCriterioVO extends BaseCriterioVO {

    /** The texto busqueda. */
    private String textoBusqueda;

    /**
     * Gets the texto busqueda.
     *
     * @return the texto busqueda
     */
    public final String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * Sets the texto busqueda.
     *
     * @param textoBusqueda
     *            the new texto busqueda
     */
    public final void setTextoBusqueda(final String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }
}
