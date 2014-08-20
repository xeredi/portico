package xeredi.integra.model.vo.usuario;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioVO.
 */
public final class UsuarioVO {

    /** The id. */
    private Long id;

    /** The login. */
    private String login;

    /** The contrasenia. */
    private String contrasenia;

    /** The nombre. */
    private String nombre;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login.
     *
     * @param value
     *            the new login
     */
    public void setLogin(final String value) {
        login = value;
    }

    /**
     * Gets the contrasenia.
     *
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Sets the contrasenia.
     *
     * @param value
     *            the new contrasenia
     */
    public void setContrasenia(final String value) {
        contrasenia = value;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param value
     *            the new nombre
     */
    public void setNombre(final String value) {
        nombre = value;
    }

}
