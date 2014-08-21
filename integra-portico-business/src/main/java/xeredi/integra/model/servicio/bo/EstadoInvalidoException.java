package xeredi.integra.model.servicio.bo;

import xeredi.util.exception.ModelException;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadoInvalidoException.
 */
public final class EstadoInvalidoException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6371835503437767408L;

    /** The estado. */
    private final String estado;

    /** The item. */
    private final String item;

    /**
     * Instantiates a new estado invalido exception.
     * 
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     * @param aestado
     *            the aestado
     * @param aitem
     *            the aitem
     */
    public EstadoInvalidoException(final String aclassName, final Object aobjId, final String aestado,
            final String aitem) {
        super("Estado '" + aestado + "' invalido para el item '" + aitem + "' de la entidad '" + aclassName + "'",
                aclassName, aobjId);

        this.estado = aestado;
        this.item = aitem;
    }

    /**
     * Gets the estado.
     * 
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Gets the item.
     * 
     * @return the item
     */
    public final String getItem() {
        return item;
    }

}
