package xeredi.argo.model.facturacion.vo;

// TODO: Auto-generated Javadoc
/**
 * Formas en las que se pueden agrupar valoraciones para compponer facturas.
 */
public enum ValoracionGrupoTipo {
    /** Pagador. */
    P,
    /** Tipo de Servicio. */
    T,
    /** Servicio. */
    S,
    /** Valoracion. */
    V,

    ;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name();
    }
}
