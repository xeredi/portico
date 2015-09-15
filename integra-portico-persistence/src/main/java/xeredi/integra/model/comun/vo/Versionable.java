package xeredi.integra.model.comun.vo;

import java.util.Date;

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

    /**
     * Gets the fref.
     *
     * @return the fref
     */
    Date getFref();
}
