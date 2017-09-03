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
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.dao.ServicioActorDAO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.dao.ServicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MaestroImporterV2BO.
 */
public final class ServicioImporterV2BO extends EntityImporterBO {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ServicioImporterV2BO.class);

	/** The Constant MAESTRO_FILENAME. */
	private static final String SERVICIO_FILENAME = "/xeredi/integra/db/importer/ServicioImporter.v2.xml";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getXmlFilename() {
		return SERVICIO_FILENAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void prepareImport(Connection con, SqlSession session) throws SQLException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void finalizeImport(Connection con, SqlSession session) throws SQLException {
		LOG.info("Actualizacion de actores de los servicios");

		final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

		sracDAO.insertAll();
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

		final AbstractEntidadDetailVO entityDetail = EntidadProxy.select(entiNode.getId().getId());

		switch (entityDetail.getEnti().getTipo()) {
		case T:
			importServiceType(con, session, entiNode);

			break;
		case S:
			importSubserviceType(con, session, entiNode);

			break;
		default:
			throw new Error("Invalid entity type: " + entityDetail.getEnti().getTipo());
		}
	}

	/**
	 * Import service type.
	 *
	 * @param con
	 *            the con
	 * @param session
	 *            the session
	 * @param entiNode
	 *            the enti node
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void importServiceType(@NonNull final Connection con, @NonNull final SqlSession session,
			@NonNull final EntityNodeV2VO entiNode) throws SQLException {
		final TipoServicioDetailVO entityDetail = TipoServicioProxy.select(entiNode.getId().getId());

		final List<ServicioVO> srvcList = new ArrayList<>();
		final List<ItemDatoVO> srdtList = new ArrayList<>();

		final Map<Long, Long> translationMap = new HashMap<>();

		try (final PreparedStatement stmt = con.prepareStatement(entiNode.getSql());
				final ResultSet rs = stmt.executeQuery();) {
			final int columnCount = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				final ServicioVO srvc = new ServicioVO();

				int i = 1;

				final Long oldId = rs.getLong(i++);

				IgUtilBO.assignNextVal(srvc);

				translationMap.put(oldId, srvc.getId());

				srvc.setEntiId(entityDetail.getEnti().getId());
				srvc.setFalta(rs.getDate(i++));

				rs.getDate(i++); // fbaja
				rs.getDate(i++); // fmodificacion
				rs.getString(i++); // tipo
				rs.getString(i++); // modulo

				srvc.setPrto(prtoMap.get(rs.getString(i++)));
				srvc.setAnno(rs.getString(i++));
				srvc.setNumero(rs.getString(i++));

				rs.getDate(i++); // festadistica
				rs.getDate(i++); // fanulafactura

				srvc.setFref(rs.getDate(i++));

				if (entityDetail.getEnti().getTemporal()) {
					srvc.setFini(rs.getDate(i++));
					srvc.setFfin(rs.getDate(i++));
				}

				if (entityDetail.getEnti().getTpdtEstado() != null) {
					srvc.setEstado(rs.getString(i++));
				}

				srvcList.add(srvc);

				for (final Long tpdtId : entityDetail.getEntdList()) {
					Object value = null;

					if (i <= columnCount) {
						value = rs.getObject(i++);
					}

					final ItemDatoVO itdt = createItdt(entiNode.getId(), entityDetail.getEntdMap().get(tpdtId), value);

					itdt.setItemId(srvc.getId());

					srdtList.add(itdt);
				}
			}

			final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
			final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);

			for (final ServicioVO srvc : srvcList) {
				srvcDAO.insert(srvc);
			}

			for (final ItemDatoVO srdt : srdtList) {
				srdtDAO.insert(srdt);
			}

			createTranslations(con, entiNode.getTable(), translationMap);
		}
	}

	/**
	 * Import subservice type.
	 *
	 * @param con
	 *            the con
	 * @param session
	 *            the session
	 * @param entiNode
	 *            the enti node
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void importSubserviceType(@NonNull final Connection con, @NonNull final SqlSession session,
			@NonNull final EntityNodeV2VO entiNode) throws SQLException {
		final TipoSubservicioDetailVO entityDetail = TipoSubservicioProxy.select(entiNode.getId().getId());

		final List<SubservicioVO> ssrvList = new ArrayList<>();
		final List<ItemDatoVO> ssdtList = new ArrayList<>();
		final List<SubservicioSubservicioVO> ssssList = new ArrayList<>();

		final Map<Long, Long> translationMap = new HashMap<>();

		try (final PreparedStatement stmt = con.prepareStatement(entiNode.getSql());
				final ResultSet rs = stmt.executeQuery();) {
			final int columnCount = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				final SubservicioVO ssrv = new SubservicioVO();

				int i = 1;

				{
					final ServicioVO srvc = new ServicioVO();

					srvc.setId(rs.getLong(i++));

					ssrv.setSrvc(srvc);
				}

				final Long oldId = rs.getLong(i++);

				IgUtilBO.assignNextVal(ssrv);

				translationMap.put(oldId, ssrv.getId());

				ssrv.setNumero(rs.getInt(i++));
				ssrv.setEntiId(entityDetail.getEnti().getId());

				if (entityDetail.getEnti().isTemporal()) {
					ssrv.setFini(rs.getDate(i++));
					ssrv.setFfin(rs.getDate(i++));
				}

				if (entityDetail.getEnti().getTpdtEstado() != null) {
					ssrv.setEstado(rs.getString(i++));
				}

				ssrvList.add(ssrv);

				if (entityDetail.getEntiPadresList() != null) {
					for (final Long entiId : entityDetail.getEntiPadresList()) {
						if (!entiId.equals(entityDetail.getEnti().getTpsrId())) {
							final SubservicioSubservicioVO ssss = new SubservicioSubservicioVO(rs.getLong(i++),
									ssrv.getId());

							ssssList.add(ssss);
						}
					}
				}

				for (final Long tpdtId : entityDetail.getEntdList()) {
					Object value = null;

					if (i <= columnCount) {
						value = rs.getObject(i++);
					}

					final ItemDatoVO itdt = createItdt(entiNode.getId(), entityDetail.getEntdMap().get(tpdtId), value);

					itdt.setItemId(ssrv.getId());

					ssdtList.add(itdt);
				}

				if (ssrvList.size() > ITEMS_PER_COMMIT) {
					LOG.debug("Partial Commit");

					final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
					final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
					final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

					for (final SubservicioVO item : ssrvList) {
						ssrvDAO.insert(item);
					}

					for (final ItemDatoVO item : ssdtList) {
						ssdtDAO.insert(item);
					}

					for (final SubservicioSubservicioVO item : ssssList) {
						ssssDAO.insert(item);
					}

					session.commit();

					ssrvList.clear();
					ssdtList.clear();
					ssssList.clear();
				}
			}
		}

		final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
		final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
		final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);

		for (final SubservicioVO item : ssrvList) {
			ssrvDAO.insert(item);
		}

		for (final ItemDatoVO item : ssdtList) {
			ssdtDAO.insert(item);
		}

		for (final SubservicioSubservicioVO item : ssssList) {
			ssssDAO.insert(item);
		}

		session.commit();

		ssrvList.clear();
		ssdtList.clear();
		ssssList.clear();

		createTranslations(con, entiNode.getTable(), translationMap);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		final ServicioImporterV2BO bo = new ServicioImporterV2BO();

		bo.importEntities("60", Calendar.getInstance().getTime(), "es_ES");
	}

}
