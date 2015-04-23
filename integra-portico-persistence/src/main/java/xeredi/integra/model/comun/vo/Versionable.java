package xeredi.integra.model.comun.vo;

// TODO: Auto-generated Javadoc
/**
 * The Interface Versionable.
 *
 * @param <T>
 *            the generic type
 */
public interface Versionable<T extends VersionVO> {
    /**
     * Gets the version.
     *
     * @return the version
     */
    T getVersion();

    /**
     * Sets the version.
     *
     * @param value
     *            the new version
     */
    void setVersion(final T value);
}
