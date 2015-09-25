package xeredi.argo.model.seguridad.vo;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

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

    /** The sprt. */
    private SuperpuertoVO sprt;

    /** The prto. */
    private PuertoVO prto;

    /** The grpo ids. */
    private Set<Long> grpoIds;

    /**
     * Instantiates a new usuario vo.
     */
    public UsuarioVO() {
        super();

        grpoIds = new HashSet<>();
    }

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

    /**
     * Gets the sprt.
     *
     * @return the sprt
     */
    public SuperpuertoVO getSprt() {
        return sprt;
    }

    /**
     * Sets the sprt.
     *
     * @param value
     *            the new sprt
     */
    public void setSprt(final SuperpuertoVO value) {
        sprt = value;
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoVO value) {
        prto = value;
    }

    /**
     * Gets the grpo ids.
     *
     * @return the grpo ids
     */
    public Set<Long> getGrpoIds() {
        return grpoIds;
    }

    /**
     * Sets the grpo ids.
     *
     * @param value
     *            the new grpo ids
     */
    public void setGrpoIds(final Set<Long> value) {
        grpoIds = value;
    }

}
