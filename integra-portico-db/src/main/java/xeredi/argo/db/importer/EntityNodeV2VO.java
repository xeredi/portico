package xeredi.argo.db.importer;

import lombok.Data;
import xeredi.argo.model.metamodelo.vo.Entidad;

@Data
public final class EntityNodeV2VO {

    /** The id. */
    private final Entidad id;

    /** The table. */
    private final String table;

    /** The implicit temp. */
    private final Boolean implicitTemp;

    /** The sql. */
    private final String sql;

    /**
     * Instantiates a new entity node v2 vo.
     *
     * @param aid the aid
     * @param atable the atable
     * @param aimplicitTemp the aimplicit temp
     * @param asql the asql
     */
    public EntityNodeV2VO(Entidad aid, String atable, Boolean aimplicitTemp, String asql) {
        super();
        this.id = aid;
        this.table = atable;
        this.implicitTemp = aimplicitTemp;
        this.sql = asql;
    }

    /**
     * Instantiates a new entity node v2 vo.
     *
     * @param aid the aid
     * @param atable the atable
     * @param asql the asql
     */
    public EntityNodeV2VO(Entidad aid, String atable, String asql) {
        this(aid, atable, null, asql);
    }

}
