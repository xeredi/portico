package xeredi.argo.model.comun.vo;

import java.util.Date;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemVersionVO.
 */
@Data
public abstract class VersionVO {
    /**
     * Gets the prefix.
     *
     * @return the prefix
     */
    public abstract ClassPrefix getPrefix();

    /** The id. */
    protected Long id;

    /** The fini. */
    protected Date fini;

    /** The ffin. */
    protected Date ffin;
}
