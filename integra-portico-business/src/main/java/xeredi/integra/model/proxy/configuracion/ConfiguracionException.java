package xeredi.integra.model.proxy.configuracion;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationNotFoundException.
 */
public final class ConfiguracionException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2518481418787375032L;

    /** The key. */
    private final String key;

    /**
     * Instantiates a new configuracion exception.
     * 
     * @param key
     *            the key
     * @param mensaje
     *            the mensaje
     * @param ex
     *            the ex
     */
    public ConfiguracionException(final String key, final String mensaje, final Throwable ex) {
        super("clave: '" + key + "', mensaje: '" + mensaje + "'", ex);

        this.key = key;
    }

    /**
     * Instantiates a new configuracion exception.
     * 
     * @param key
     *            the key
     * @param mensaje
     *            the mensaje
     */
    public ConfiguracionException(final String key, final String mensaje) {
        super("clave: '" + key + "', mensaje: '" + mensaje + "'");

        this.key = key;
    }

    /**
     * Gets the key.
     * 
     * @return the key
     */
    public String getKey() {
        return key;
    }

}
