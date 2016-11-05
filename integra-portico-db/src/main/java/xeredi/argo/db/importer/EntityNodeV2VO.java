package xeredi.argo.db.importer;

import lombok.Data;
import xeredi.argo.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * EntityNodeV2VO.
 */

/**
 * {@inheritDoc}
 */
@Data
public final class EntityNodeV2VO {

    /** The id. */
    private final Entidad id;

    /** The table. */
    private final String table;

    /** The implicit temp. */
    private final Boolean implicitTemp;

    /** The sql id. */
    private final String sqlId;

    /** The sql. */
    private final String sql;

    /**
     * Instantiates a new entity node v2 vo.
     *
     * @param aid
     *            the aid
     * @param atable
     *            the atable
     * @param aimplicitTemp
     *            the aimplicit temp
     * @param asqlId
     *            the asql id
     * @param asql
     *            the asql
     */
    public EntityNodeV2VO(final Entidad aid, final String atable, final Boolean aimplicitTemp, final String asqlId,
            String asql) {
        super();
        this.id = aid;
        this.table = atable;
        this.implicitTemp = aimplicitTemp;
        this.sqlId = asqlId;
        this.sql = asql;
    }

    /**
     * Instantiates a new entity node v2 vo.
     *
     * @param aid
     *            the aid
     * @param atable
     *            the atable
     * @param asqlId
     *            the asql id
     * @param asql
     *            the asql
     */
    public EntityNodeV2VO(final Entidad aid, final String atable, final String asqlId, final String asql) {
        this(aid, atable, null, asqlId, asql);
    }

}
