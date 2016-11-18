package xeredi.argo.db.importer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import lombok.NonNull;
import oracle.sql.TIMESTAMP;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntityImporterBO.
 */
public abstract class EntityImporterBO {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(EntityImporterBO.class);

    /** The Constant ITEMS_PER_COMMIT. */
    public static final int ITEMS_PER_COMMIT = 5000;

    /**
     * The Enum XmlKeyword.
     */
    enum XmlKeyword {

        /** The id. */
        id,
        /** The table. */
        table,
        /** The imp tmp. */
        tempImp,
        /** The sql id. */
        sqlId,
        /** The sql. */
        sql
    };

    /** The idioma. */
    protected String idioma;

    /** The fecha vigencia. */
    protected Date fechaVigencia;

    /** The fecha inicio. */
    protected Date fechaInicio;

    /** The prto map. */
    protected final Map<String, PuertoVO> prtoMap = new HashMap<>();

    /**
     * Import entities.
     *
     * @param sprtCode
     *            the sprt code
     * @param referenceDate
     *            the reference date
     * @param language
     *            the language
     */
    public final void importEntities(final String sprtCode, final Date referenceDate, final String language) {
        idioma = language;

        final Calendar calendar = Calendar.getInstance();

        // calendar.setTime(referenceDate);

        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        fechaVigencia = calendar.getTime();

        calendar.add(Calendar.YEAR, -10);

        fechaInicio = calendar.getTime();

        try (final Connection con = getRemoteConnection();
                final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            con.setAutoCommit(false);

            LOG.info("Start process");

            final SuperpuertoBO sprtBO = new SuperpuertoBO();
            final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

            sprtCriterio.setCodigo(sprtCode);

            final SuperpuertoVO sprt = sprtBO.selectObject(sprtCriterio);

            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(sprt.getId());

            for (final PuertoVO prto : prtoBO.selectList(prtoCriterio)) {
                prtoMap.put(prto.getCodigoCorto(), prto);
            }

            final String xmlFilename = getXmlFilename();
            final List<EntityNodeV2VO> entiList = readEntities(xmlFilename);

            LOG.info("Translations delete");

            for (final EntityNodeV2VO entiNode : entiList) {
                deleteTranslations(con, entiNode.getTable());
            }

            con.commit();

            for (final EntityNodeV2VO entiNode : entiList) {
                LOG.info("Import: " + entiNode.getId());

                translateEntity(con, entiNode);
                con.commit();

                importEntity(con, session, entiNode);
                session.commit();
            }
        } catch (final InstanceNotFoundException ex) {
            LOG.fatal(ex, ex);
        } catch (final ClassNotFoundException ex) {
            LOG.fatal(ex, ex);
        } catch (final SQLException ex) {
            LOG.fatal(ex, ex);
        } catch (final ParserConfigurationException ex) {
            LOG.fatal(ex, ex);
        } catch (final SAXException ex) {
            LOG.fatal(ex, ex);
        } catch (final IOException ex) {
            LOG.fatal(ex, ex);
        }

        LOG.info("End process");
    }

    /**
     * Gets the xml filename.
     *
     * @return the xml filename
     */
    protected abstract String getXmlFilename();

    /**
     * Import entity.
     *
     * @param con
     *            the con
     * @param session
     *            the session
     * @param entiNode
     *            the enti node
     * @throws SQLException
     *             the SQL exception
     * @throws ClassNotFoundException
     *             the class not found exception
     */
    protected abstract void importEntity(@NonNull final Connection con, @NonNull final SqlSession session,
            @NonNull final EntityNodeV2VO entiNode) throws SQLException, ClassNotFoundException;

    /**
     * Gets the remote connection.
     *
     * @return the remote connection
     * @throws ClassNotFoundException
     *             the class not found exception
     * @throws SQLException
     *             the SQL exception
     */
    private Connection getRemoteConnection() throws ClassNotFoundException, SQLException {
        Class.forName(ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_driver));

        return DriverManager.getConnection(ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_url),
                ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_username),
                ConfigurationProxy.getString(ConfigurationKey.db_migration_dataSource_password));
    }

    /**
     * Translate entity.
     *
     * @param con
     *            the con
     * @param entiNode
     *            the enti node
     * @throws SQLException
     *             the SQL exception
     */
    private final void translateEntity(@NonNull final Connection con, final EntityNodeV2VO entiNode)
            throws SQLException {
        // Los submaestros no es necesario traducirlos
        if (EntidadProxy.select(entiNode.getId().getId()).getEnti().getTipo() != TipoEntidad.B) {
            try (final PreparedStatement stmtInsert = con.prepareStatement(
                    "INSERT INTO tbl_traduccion_ids_trid (trid_table_name, trid_old_id, trid_new_id) values (?, ?, ?)");) {
                try (final Statement stmtSelect = con.createStatement();
                        final ResultSet rsSelect = stmtSelect.executeQuery(entiNode.getSqlId());) {
                    while (rsSelect.next()) {
                        final Long oldId = rsSelect.getLong(1);

                        final ParametroVO prmt = new ParametroVO();

                        IgUtilBO.assignNextVal(prmt);

                        stmtInsert.setString(1, entiNode.getTable());
                        stmtInsert.setLong(2, oldId);
                        stmtInsert.setLong(3, prmt.getId());

                        stmtInsert.addBatch();
                    }

                    stmtInsert.executeBatch();
                }
            }
        }
    }

    /**
     * Delete translations.
     *
     * @param con
     *            the con
     * @param tableName
     *            the table name
     * @throws SQLException
     *             the SQL exception
     */
    private final void deleteTranslations(@NonNull final Connection con, @NonNull final String tableName)
            throws SQLException {
        try (final PreparedStatement stmt = con
                .prepareStatement("DELETE FROM tbl_traduccion_ids_trid WHERE trid_table_name = ?")) {
            stmt.setString(1, tableName);

            stmt.executeUpdate();
        }
    }

    /**
     * Read long.
     *
     * @param rs
     *            the rs
     * @param index
     *            the index
     * @return the long
     * @throws SQLException
     *             the SQL exception
     */
    protected final Long readLong(final ResultSet rs, final int index) throws SQLException {
        final Object value = rs.getObject(index);

        return value == null ? null : ((BigDecimal) value).longValue();
    }

    /**
     * Creates the itdt.
     *
     * @param entity
     *            the entity
     * @param entd
     *            the entd
     * @param value
     *            the value
     * @return the item dato VO
     * @throws SQLException
     *             the SQL exception
     */
    protected final ItemDatoVO createItdt(@NonNull final Entidad entity, @NonNull final EntidadTipoDatoVO entd,
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

    /**
     * Read entities.
     *
     * @param xmlFileName
     *            the xml file name
     * @return the list
     * @throws ParserConfigurationException
     *             the parser configuration exception
     * @throws SAXException
     *             the SAX exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private List<EntityNodeV2VO> readEntities(final String xmlFileName)
            throws ParserConfigurationException, SAXException, IOException {
        LOG.info("Xml parse: " + xmlFileName);

        final List<EntityNodeV2VO> amaestrosList = new ArrayList<>();

        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser saxParser = factory.newSAXParser();

        final DefaultHandler handler = new DefaultHandler() {

            private boolean isSql;

            private Entidad id;

            private String table;

            private boolean impTmp;

            private String sqlId;

            private StringBuffer sql;

            /**
             * {@inheritDoc}
             */
            @Override
            public void startElement(final String uri, final String localName, final String qName,
                    final Attributes attributes) throws SAXException {
                if (XmlKeyword.sql.name().equals(qName)) {
                    isSql = true;

                    id = Entidad.valueOf(attributes.getValue(XmlKeyword.id.name()).toUpperCase());
                    table = String.valueOf(attributes.getValue(XmlKeyword.table.name())).toUpperCase();
                    impTmp = Boolean.parseBoolean(attributes.getValue(XmlKeyword.tempImp.name()));
                    sqlId = attributes.getValue(XmlKeyword.sqlId.name());
                    sql = new StringBuffer();
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void characters(final char[] ch, final int start, final int length) throws SAXException {
                if (isSql) {
                    sql.append(new String(ch, start, length));
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void endElement(final String uri, final String localName, final String qName) throws SAXException {
                if (XmlKeyword.sql.name().equals(qName)) {
                    amaestrosList.add(new EntityNodeV2VO(id, table, impTmp, sqlId, sql.toString()));

                    isSql = false;
                }
            }

        };

        saxParser.parse(EntityImporterBO.class.getResourceAsStream(xmlFileName), handler);

        return amaestrosList;
    }

}
