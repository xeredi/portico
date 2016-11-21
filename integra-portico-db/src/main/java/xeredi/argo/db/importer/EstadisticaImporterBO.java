package xeredi.argo.db.importer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.dao.EstadisticaDAO;
import xeredi.argo.model.estadistica.dao.EstadisticaDatoDAO;
import xeredi.argo.model.estadistica.dao.PeriodoProcesoDAO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaImporterBO.
 */
public final class EstadisticaImporterBO extends EntityImporterBO {
    private static final Log LOG = LogFactory.getLog(EstadisticaImporterBO.class);

    /** The Constant ESTADISTICA_FILENAME. */
    private static final String ESTADISTICA_FILENAME = "/xeredi/integra/db/importer/EstadisticaImporter.xml";

    /** The Constant PEPR_TABLENAME. */
    private static final String PEPR_TABLENAME = "IEST_PERIODOPROCESO_PEPR";

    /** The Constant PEPR_SQL_ID. */
    private static final String PEPR_SQL_ID = "SELECT pepr_id FROM iest_periodoproceso_pepr";

    /** The Constant PEPR_SQL. */
    private static final String PEPR_SQL = new StringBuilder()
            .append(" SELECT pepr_id, pepr_anio, pepr_mes, pepr_fecha_alta, autp_dependencia_autp_id, pepr_autp_id ")
            .append(" FROM iest_periodoproceso_pepr LEFT JOIN igen_autoridad_port_autp ON pepr_autp_id = autp_id ")
            .append(" WHERE autp_dependencia_autp_id IS NOT NULL").toString();

    private final Map<String, PuertoVO> prtoEstdMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getXmlFilename() {
        return ESTADISTICA_FILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareImport(@NonNull final Connection con, @NonNull final SqlSession session) throws SQLException {
        // Leer puertos
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setSprtId(sprt.getId());

        for (final PuertoVO prto : prtoBO.selectList(prtoCriterio)) {
            prtoEstdMap.put(prto.getCodigo(), prto);
        }

        // Borrado de las traducciones de los periodos de proceso
        deleteTranslations(con, PEPR_TABLENAME);

        final Map<Long, Long> translationMap = new HashMap<>();

        // Importacion de los periodos de proceso
        try (final PreparedStatement stmt = con.prepareStatement(PEPR_SQL); final ResultSet rs = stmt.executeQuery();) {
            final PeriodoProcesoDAO peprDAO = session.getMapper(PeriodoProcesoDAO.class);

            while (rs.next()) {
                final PeriodoProcesoVO pepr = new PeriodoProcesoVO();

                int i = 1;

                final Long oldId = rs.getLong(i++);

                IgUtilBO.assignNextVal(pepr);

                translationMap.put(oldId, pepr.getId());

                pepr.setAnio(rs.getInt(i++));
                pepr.setMes(rs.getInt(i++));
                pepr.setFalta(rs.getDate(i++));

                pepr.setSprt(sprt);

                final Calendar calendar = Calendar.getInstance();

                calendar.setTimeInMillis(0);

                calendar.set(Calendar.YEAR, pepr.getAnio());
                calendar.set(Calendar.MONTH, pepr.getMes());
                calendar.set(Calendar.DAY_OF_MONTH, 1);

                pepr.setFreferencia(calendar.getTime());

                peprDAO.insert(pepr);
            }
        }

        createTranslations(con, PEPR_TABLENAME, translationMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void finalizeImport(Connection con, SqlSession session) throws SQLException {
        LOG.info("Generacion de cuadros mensuales");

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        for (final PeriodoProcesoVO pepr : peprBO.selectList(new PeriodoProcesoCriterioVO())) {
            LOG.debug("pepr: " + pepr);

            peprBO.generarCuadroMensual(pepr.getId(), false);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void importEntity(@NonNull final Connection con, @NonNull final SqlSession session,
            @NonNull final EntityNodeV2VO entiNode) throws SQLException, ClassNotFoundException {
        Preconditions.checkNotNull(entiNode.getId());
        Preconditions.checkNotNull(entiNode.getTable());
        Preconditions.checkNotNull(entiNode.getSql());

        final TipoEstadisticaDetailVO entityDetail = TipoEstadisticaProxy.select(entiNode.getId().getId());

        final List<EstadisticaVO> estdList = new ArrayList<>();
        final List<ItemDatoVO> esdtList = new ArrayList<>();

        try (final PreparedStatement stmt = con.prepareStatement(entiNode.getSql());
                final ResultSet rs = stmt.executeQuery();) {
            final int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                final EstadisticaVO estd = new EstadisticaVO();
                final PeriodoProcesoVO pepr = new PeriodoProcesoVO();

                int i = 1;

                estd.setPrto(prtoEstdMap.get(rs.getString(i++)));
                pepr.setId(rs.getLong(i++));
                estd.setId(rs.getLong(i++));
                estd.setEntiId(entityDetail.getEnti().getId());

                estd.setPepr(pepr);

                IgUtilBO.assignNextVal(estd);

                estdList.add(estd);

                for (final Long tpdtId : entityDetail.getEntdList()) {
                    Object value = null;

                    if (i <= columnCount) {
                        value = rs.getObject(i++);
                    }

                    final ItemDatoVO itdt = createItdt(entiNode.getId(), entityDetail.getEntdMap().get(tpdtId), value);

                    itdt.setItemId(estd.getId());

                    esdtList.add(itdt);
                }

                if (estdList.size() > ITEMS_PER_COMMIT) {
                    LOG.debug("Partial Commit");

                    final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
                    final EstadisticaDatoDAO esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

                    for (final EstadisticaVO item : estdList) {
                        estdDAO.insert(item);
                    }

                    for (final ItemDatoVO item : esdtList) {
                        esdtDAO.insert(item);
                    }

                    session.commit();

                    estdList.clear();
                    esdtList.clear();
                }

            }

            final EstadisticaDAO estdDAO = session.getMapper(EstadisticaDAO.class);
            final EstadisticaDatoDAO esdtDAO = session.getMapper(EstadisticaDatoDAO.class);

            for (final EstadisticaVO item : estdList) {
                estdDAO.insert(item);
            }

            for (final ItemDatoVO item : esdtList) {
                esdtDAO.insert(item);
            }

            session.commit();

            estdList.clear();
            esdtList.clear();
        }
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final EstadisticaImporterBO bo = new EstadisticaImporterBO();

        bo.importEntities("60", Calendar.getInstance().getTime(), "es_ES");
    }

}
