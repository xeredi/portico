package xeredi.argo.db.importer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import oracle.sql.TIMESTAMP;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class EntityImporterBO.
 */
public abstract class EntityImporterBO {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(EntityImporterBO.class);

    /**
     * Delete translations.
     *
     * @param con
     *            the con
     * @throws SQLException
     *             the SQL exception
     */
    protected final void deleteTranslations(final @NonNull Connection con) throws SQLException {
        try (final PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE tbl_traduccion_ids_trid")) {
            stmt.executeUpdate();
        }
    }

    /**
     * Insert translation.
     *
     * @param con
     *            the con
     * @param tableName
     *            the table name
     * @param oldId
     *            the old id
     * @param newId
     *            the new id
     * @throws SQLException
     *             the SQL exception
     */
    protected final void insertTranslation(final @NonNull Connection con, final @NonNull String tableName,
            final @NonNull Long oldId, final @NonNull Long newId) throws SQLException {
        try (final PreparedStatement stmt = con
                .prepareStatement("INSERT INTO tbl_traduccion_ids_trid (trid_old_id, trid_new_id, trid_table_name) VALUES (?, ?, ?)")) {
            int i = 1;

            stmt.setLong(i++, oldId);
            stmt.setLong(i++, newId);
            stmt.setString(i++, tableName);

            stmt.executeUpdate();
        }
    }

    protected final Long readLong(final ResultSet rs, final int index) throws SQLException {
        final Object value = rs.getObject(index);

        return value == null ? null : ((BigDecimal) value).longValue();
    }

    protected final ItemDatoVO createItdt(final @NonNull Entidad entity, final @NonNull EntidadTipoDatoVO entd,
            final Object value) throws SQLException {
        try {
            final ItemDatoVO itdt = new ItemDatoVO();

            itdt.setTpdtId(entd.getTpdt().getId());

            if (value != null) {
                switch (entd.getTpdt().getTipoElemento()) {
                case BO:
                case NE:
                    itdt.setCantidadEntera(((BigDecimal) value).longValue());

                    break;
                case ND:
                    itdt.setCantidadDecimal(((BigDecimal) value).doubleValue());

                    break;
                case FE:
                case FH:
                    final Date date = value instanceof TIMESTAMP ? ((TIMESTAMP) value).dateValue() : (Date) value;

                    if (date != null) {
                        if ((entd.getTpdt().getTipoElemento() == TipoElemento.FE)) {
                            DateUtil.truncTime(date, Calendar.HOUR_OF_DAY);
                        } else {
                            DateUtil.truncTime(date, Calendar.SECOND);
                        }

                        itdt.setFecha(date);
                    }

                    break;
                case CR:
                case TX:
                    itdt.setCadena((String) value);

                    break;
                case PR:
                    final ParametroVO prmt = new ParametroVO();

                    prmt.setId(((BigDecimal) value).longValue());

                    itdt.setPrmt(prmt);

                    break;
                case SR:
                    final ServicioVO srvc = new ServicioVO();

                    srvc.setId(((BigDecimal) value).longValue());

                    itdt.setSrvc(srvc);

                    break;

                default:
                    throw new Error("Unsupported data type '" + entd.getTpdt().getCodigo() + "' for entity '"
                            + entity.name() + "'");
                }
            }

            return itdt;
        } catch (final Exception ex) {
            LOG.error("Entity: " + entity + ", value: " + value + ", entd: " + entd);

            throw new SQLException(ex);
        }
    }
}
