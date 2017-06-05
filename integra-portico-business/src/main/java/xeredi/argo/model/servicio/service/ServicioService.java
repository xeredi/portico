package xeredi.argo.model.servicio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.dao.ItemTramiteDAO;
import xeredi.argo.model.item.dao.ItemTramiteDatoDAO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.servicio.dao.ServicioActorDAO;
import xeredi.argo.model.servicio.dao.ServicioArchivoDAO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.dao.ServicioDatoDAO;
import xeredi.argo.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.argo.model.servicio.dao.ServicioTramiteDAO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.argo.model.servicio.vo.ServicioArchivoVO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioTypeaheadCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioService.
 */
@Transactional(executorType = ExecutorType.BATCH)
public class ServicioService {

	/** The srvc DAO. */
	private final ServicioDAO srvcDAO;

	/** The srdt DAO. */
	private final ServicioDatoDAO srdtDAO;

	/** The ssrv DAO. */
	private final SubservicioDAO ssrvDAO;

	/** The ssdt DAO. */
	private final SubservicioDatoDAO ssdtDAO;

	/** The ssss DAO. */
	private final SubservicioSubservicioDAO ssssDAO;

	/** The ittr DAO. */
	private final ItemTramiteDAO ittrDAO;

	/** The srtr DAO. */
	private final ServicioTramiteDAO srtrDAO;

	/** The ittd DAO. */
	private final ItemTramiteDatoDAO ittdDAO;

	/** The srac DAO. */
	private final ServicioActorDAO sracDAO;

	/** The srar DAO. */
	private final ServicioArchivoDAO srarDAO;

	/** The srsc DAO. */
	private final ServicioSecuenciaDAO srscDAO;

	/** The usro DAO. */
	private final UsuarioDAO usroDAO;

	/** The enti proxy. */
	private final EntidadProxyService entiProxy;

	/** The trmt service. */
	private final TramiteProxyService trmtProxy;

	/** The enti id. */
	private Long entiId;

	/** The usro id. */
	private Long usroId;

	/**
	 * Instantiates a new servicio service.
	 *
	 * @param srvcDAO
	 *            the srvc DAO
	 * @param srdtDAO
	 *            the srdt DAO
	 * @param ssrvDAO
	 *            the ssrv DAO
	 * @param ssdtDAO
	 *            the ssdt DAO
	 * @param ssssDAO
	 *            the ssss DAO
	 * @param ittrDAO
	 *            the ittr DAO
	 * @param srtrDAO
	 *            the srtr DAO
	 * @param ittdDAO
	 *            the ittd DAO
	 * @param sracDAO
	 *            the srac DAO
	 * @param srarDAO
	 *            the srar DAO
	 * @param srscDAO
	 *            the srsc DAO
	 * @param usroDAO
	 *            the usro DAO
	 * @param entiProxy
	 *            the enti proxy
	 * @param trmtProxy
	 *            the trmt proxy
	 */
	@Inject
	protected ServicioService(final ServicioDAO srvcDAO, final ServicioDatoDAO srdtDAO, final SubservicioDAO ssrvDAO,
			final SubservicioDatoDAO ssdtDAO, final SubservicioSubservicioDAO ssssDAO, final ItemTramiteDAO ittrDAO,
			final ServicioTramiteDAO srtrDAO, final ItemTramiteDatoDAO ittdDAO, final ServicioActorDAO sracDAO,
			final ServicioArchivoDAO srarDAO, final ServicioSecuenciaDAO srscDAO, final UsuarioDAO usroDAO,
			final EntidadProxyService entiProxy, final TramiteProxyService trmtProxy) {
		super();
		this.srvcDAO = srvcDAO;
		this.srdtDAO = srdtDAO;
		this.ssrvDAO = ssrvDAO;
		this.ssdtDAO = ssdtDAO;
		this.ssssDAO = ssssDAO;
		this.ittrDAO = ittrDAO;
		this.srtrDAO = srtrDAO;
		this.ittdDAO = ittdDAO;
		this.sracDAO = sracDAO;
		this.srarDAO = srarDAO;
		this.srscDAO = srscDAO;
		this.usroDAO = usroDAO;
		this.entiProxy = entiProxy;
		this.trmtProxy = trmtProxy;
	}

	/**
	 * Sets the enti id.
	 *
	 * @param entiId
	 *            the new enti id
	 */
	protected void setEntiId(final Long entiId) {
		this.entiId = entiId;
	}

	/**
	 * Sets the usro id.
	 *
	 * @param usroId
	 *            the new usro id
	 */
	protected void setUsroId(final Long usroId) {
		this.usroId = usroId;
	}

	/**
	 * Select.
	 *
	 * @param srvcId
	 *            the srvc id
	 * @param idioma
	 *            the idioma
	 * @return the servicio vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final ServicioVO select(@NonNull final Long srvcId, final String idioma) throws InstanceNotFoundException {
		final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

		srvcCriterioVO.setId(srvcId);
		srvcCriterioVO.setIdioma(idioma);

		return selectObject(srvcCriterioVO);
	}

	/**
	 * Select object.
	 *
	 * @param srvcCriterio
	 *            the srvc criterio vo
	 * @return the servicio vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final ServicioVO selectObject(@NonNull final ServicioCriterioVO srvcCriterio)
			throws InstanceNotFoundException {
		fillUserSpecificFilter(srvcCriterio);

		final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterio);

		if (srvcVO == null) {
			throw new InstanceNotFoundException(MessageI18nKey.srvc, srvcCriterio);
		}

		fillDependencies(Arrays.asList(new ServicioVO[] { srvcVO }), srvcCriterio, true);

		return srvcVO;
	}

	/**
	 * Select list.
	 *
	 * @param srvcCriterio
	 *            the srvc criterio vo
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public final PaginatedList<ServicioVO> selectList(@NonNull final ServicioCriterioVO srvcCriterio, final int offset,
			final int limit) {
		fillUserSpecificFilter(srvcCriterio);

		final int count = srvcDAO.count(srvcCriterio);
		final List<ServicioVO> srvcList = new ArrayList<>();

		if (count > offset) {
			srvcList.addAll(srvcDAO.selectList(srvcCriterio, new RowBounds(offset, limit)));

			fillDependencies(srvcList, srvcCriterio, true);
		}

		return new PaginatedList<>(srvcList, offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param srvcCriterio
	 *            the srvc criterio vo
	 * @return the list
	 */
	public final List<ServicioVO> selectList(@NonNull final ServicioCriterioVO srvcCriterio) {
		fillUserSpecificFilter(srvcCriterio);

		final List<ServicioVO> srvcList = srvcDAO.selectList(srvcCriterio);

		fillDependencies(srvcList, srvcCriterio, false);

		return srvcList;
	}

	/**
	 * Select lupa list.
	 *
	 * @param criterio
	 *            the srvc typeahead criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	public final List<ServicioVO> selectTypeaheadList(@NonNull final ServicioTypeaheadCriterioVO criterio,
			final int limit) {
		if (criterio.getTextoBusqueda() == null) {
			criterio.setTextoBusqueda("");
		}

		final StringTokenizer tokenizer = new StringTokenizer(criterio.getTextoBusqueda(), "/");

		criterio.setSubpuerto(tokenizer.nextToken().toUpperCase());

		if (tokenizer.hasMoreTokens()) {
			criterio.setAnno(tokenizer.nextToken() + "%");
		}

		if (tokenizer.hasMoreTokens()) {
			criterio.setNumero(tokenizer.nextToken() + "%");
		}

		return srvcDAO.selectTypeaheadList(criterio, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
	}

	/**
	 * Insert.
	 *
	 * @param srvc
	 *            the srvc
	 * @param ssrvList
	 *            the ssrv list
	 * @param ssssList
	 *            the ssss list
	 * @param archId
	 *            the arch id
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public final void insert(@NonNull final ServicioVO srvc, final List<SubservicioVO> ssrvList,
			final List<SubservicioSubservicioVO> ssssList, final Long archId) throws DuplicateInstanceException {

		final Map<Long, Long> ssrvDepsMap = new HashMap<Long, Long>();

		final TipoServicioDetailVO tpsrDetail = entiProxy.selectTpsr(srvc.getEntiId());

		if (tpsrDetail.getEntdList() != null) {
			if (srvc.getItdtMap() == null) {
				srvc.setItdtMap(new HashMap<Long, ItemDatoVO>());
			}

			for (final Long tpdtId : tpsrDetail.getEntdList()) {
				if (!srvc.getItdtMap().containsKey(tpdtId)) {
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(tpdtId);
					srvc.getItdtMap().put(tpdtId, itdt);
				}
			}
		}

		srscDAO.incrementarSecuencia(srvc);

		final Integer secuencia = srscDAO.obtenerSecuencia(srvc);

		if (secuencia == null) {
			throw new Error("No se encuentra secuencia para: " + srvc);
		}

		srvc.setNumero(ServicioVO.convertNumero(secuencia));

		if (srvcDAO.exists(srvc)) {
			throw new DuplicateInstanceException(srvc.getEntiId(), srvc);
		}

		IgUtilBO.assignNextVal(srvc);

		srvcDAO.insert(srvc);

		if (srvc.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : srvc.getItdtMap().values()) {
				itdtVO.setItemId(srvc.getId());
				srdtDAO.insert(itdtVO);
			}
		}

		if (ssrvList != null) {
			for (final SubservicioVO ssrvVO : ssrvList) {
				final SubservicioVO ssrvNew = new SubservicioVO();

				IgUtilBO.assignNextVal(ssrvNew);

				if (ssrvVO.getId() != null) {
					ssrvDepsMap.put(ssrvVO.getId(), ssrvNew.getId());
				}

				ssrvVO.setId(ssrvNew.getId());
				ssrvVO.setSrvc(srvc);
				ssrvDAO.insert(ssrvVO);

				final TipoSubservicioDetailVO tpssDetail = entiProxy.selectTpss(ssrvVO.getEntiId());

				if (tpssDetail.getEntdList() != null) {
					if (ssrvVO.getItdtMap() == null) {
						ssrvVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
					}

					for (final Long tpdtId : tpsrDetail.getEntdList()) {
						if (!ssrvVO.getItdtMap().containsKey(tpdtId)) {
							final ItemDatoVO itdt = new ItemDatoVO();

							itdt.setTpdtId(tpdtId);
							ssrvVO.getItdtMap().put(tpdtId, itdt);
						}
					}
				}
			}

			for (final SubservicioVO ssrvVO : ssrvList) {
				if (ssrvVO.getItdtMap() != null) {
					for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
						itdtVO.setItemId(ssrvVO.getId());
						ssdtDAO.insert(itdtVO);
					}
				}
			}
		}

		if (ssssList != null) {
			for (final SubservicioSubservicioVO ssssVO : ssssList) {
				ssssDAO.insert(new SubservicioSubservicioVO(ssrvDepsMap.get(ssssVO.getSsrvPadreId()),
						ssrvDepsMap.get(ssssVO.getSsrvHijoId())));
			}
		}

		if (archId != null) {
			final ServicioArchivoVO srar = new ServicioArchivoVO();

			srar.setSrvcId(srvc.getId());
			srar.setArchId(archId);

			srarDAO.insert(srar);
		}

		sracDAO.insert(srvc.getId());

		insertPostOperations(srvc, ssrvList, ssssList);

		// if (ConfigurationProxy.getBoolean(ConfigurationKey.audit_enabled)) {
		// EventoAuditoriaUtils.insert(session, this, AuditoriaAccion.INSERT);
		// }
	}

	/**
	 * Insert post operations.
	 *
	 * @param srvcVO
	 *            the srvc vo
	 * @param ssrvList
	 *            the ssrv list
	 * @param ssssList
	 *            the ssss list
	 */
	protected void insertPostOperations(final ServicioVO srvcVO, final List<SubservicioVO> ssrvList,
			final List<SubservicioSubservicioVO> ssssList) {
		// noop
	}

	/**
	 * Insert list.
	 *
	 * @param srvcMap
	 *            the srvc map
	 * @param ssrvMap
	 *            the ssrv map
	 * @param ssssMap
	 *            the ssss map
	 * @param archId
	 *            the arch id
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public final void insertList(@NonNull final Map<String, ServicioVO> srvcMap,
			final Map<String, List<SubservicioVO>> ssrvMap, final Map<String, List<SubservicioSubservicioVO>> ssssMap,
			final Long archId) throws DuplicateInstanceException {

		final Map<Long, Long> ssrvDepsMap = new HashMap<Long, Long>();

		for (final String key : srvcMap.keySet()) {
			final ServicioVO srvc = srvcMap.get(key);
			final List<SubservicioVO> ssrvList = ssrvMap == null ? null : ssrvMap.get(key);
			final List<SubservicioSubservicioVO> ssssList = ssssMap == null ? null : ssssMap.get(key);

			final TipoServicioDetailVO tpsrDetail = entiProxy.selectTpsr(srvc.getEntiId());

			if (tpsrDetail.getEntdList() != null) {
				if (srvc.getItdtMap() == null) {
					srvc.setItdtMap(new HashMap<Long, ItemDatoVO>());
				}

				for (final Long tpdtId : tpsrDetail.getEntdList()) {
					if (!srvc.getItdtMap().containsKey(tpdtId)) {
						final ItemDatoVO itdt = new ItemDatoVO();

						itdt.setTpdtId(tpdtId);
						srvc.getItdtMap().put(tpdtId, itdt);
					}
				}
			}

			srscDAO.incrementarSecuencia(srvc);

			final Integer secuencia = srscDAO.obtenerSecuencia(srvc);

			if (secuencia == null) {
				throw new Error("No se encuentra secuencia para: " + srvc);
			}

			srvc.setNumero(ServicioVO.convertNumero(secuencia));

			if (srvcDAO.exists(srvc)) {
				throw new DuplicateInstanceException(srvc.getEntiId(), srvc);
			}

			IgUtilBO.assignNextVal(srvc);

			srvcDAO.insert(srvc);

			if (srvc.getItdtMap() != null) {
				for (final ItemDatoVO itdtVO : srvc.getItdtMap().values()) {
					itdtVO.setItemId(srvc.getId());
					srdtDAO.insert(itdtVO);
				}
			}

			if (ssrvList != null) {
				for (final SubservicioVO ssrvVO : ssrvList) {
					final SubservicioVO ssrvNew = new SubservicioVO();

					IgUtilBO.assignNextVal(ssrvNew);

					if (ssrvVO.getId() != null) {
						ssrvDepsMap.put(ssrvVO.getId(), ssrvNew.getId());
					}

					ssrvVO.setId(ssrvNew.getId());
					ssrvVO.setSrvc(srvc);
					ssrvDAO.insert(ssrvVO);

					final TipoSubservicioDetailVO tpssDetail = entiProxy.selectTpss(ssrvVO.getEntiId());

					if (tpssDetail.getEntdList() != null) {
						if (ssrvVO.getItdtMap() == null) {
							ssrvVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
						}

						for (final Long tpdtId : tpsrDetail.getEntdList()) {
							if (!ssrvVO.getItdtMap().containsKey(tpdtId)) {
								final ItemDatoVO itdt = new ItemDatoVO();

								itdt.setTpdtId(tpdtId);
								ssrvVO.getItdtMap().put(tpdtId, itdt);
							}
						}
					}
				}

				for (final SubservicioVO ssrvVO : ssrvList) {
					if (ssrvVO.getItdtMap() != null) {
						for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
							itdtVO.setItemId(ssrvVO.getId());
							ssdtDAO.insert(itdtVO);
						}
					}
				}
			}

			if (ssssList != null) {
				for (final SubservicioSubservicioVO ssssVO : ssssList) {
					ssssDAO.insert(new SubservicioSubservicioVO(ssrvDepsMap.get(ssssVO.getSsrvPadreId()),
							ssrvDepsMap.get(ssssVO.getSsrvHijoId())));
				}
			}

			if (archId != null) {
				final ServicioArchivoVO srar = new ServicioArchivoVO();

				srar.setSrvcId(srvc.getId());
				srar.setArchId(archId);

				srarDAO.insert(srar);
			}

			sracDAO.insert(srvc.getId());

			insertPostOperations(srvc, ssrvList, ssssList);
		}
	}

	/**
	 * Update.
	 *
	 * @param srvc
	 *            the srvc vo
	 * @throws ModelException
	 *             the model exception
	 */
	public final void update(@NonNull final ServicioVO srvc) throws ModelException {
		for (final ItemDatoVO itdt : srvc.getItdtMap().values()) {
			itdt.setItemId(srvc.getId());
			srdtDAO.update(itdt);
		}

		// TODO Actualizar datos del servicio??

		sracDAO.deleteList(srvc.getId());
		sracDAO.insert(srvc.getId());

		updatePostOperations(srvc);
	}

	/**
	 * Update.
	 *
	 * @param srvcVO
	 *            the srvc vo
	 * @throws ModelException
	 *             the model exception
	 */
	protected void updatePostOperations(final ServicioVO srvcVO) throws ModelException {
		// noop
	}

	/**
	 * Duplicate.
	 *
	 * @param srvcVO
	 *            the srvc vo
	 * @throws ModelException
	 *             the model exception
	 */
	public final void duplicate(@NonNull final ServicioVO srvcVO) throws ModelException {
		Preconditions.checkNotNull(srvcVO.getId());

		final Map<Long, Long> ssrvIds = new HashMap<>();

		// Busqueda de los elementos a duplicar
		final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();
		final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
		final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

		srvcCriterioVO.setId(srvcVO.getId());
		ssrvCriterioVO.setSrvc(srvcCriterioVO);
		ssssCriterio.setSrvcId(srvcVO.getId());

		final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);
		final List<ItemDatoVO> ssdtList = ssdtDAO.selectList(ssrvCriterioVO);
		final List<SubservicioSubservicioVO> ssssList = ssssDAO.selectList(ssssCriterio);

		// Duplicado del servicio. Se duplica el propio servicio y sus datos
		// asociados, los
		// subservicios y
		// los datos asociados, y las relaciones entre subservicios.
		srscDAO.incrementarSecuencia(srvcVO);

		final Integer secuencia = srscDAO.obtenerSecuencia(srvcVO);
		final Long srvcIdActual = srvcVO.getId();

		if (secuencia == null) {
			throw new Error("No se encuentra secuencia para: " + srvcVO.getEtiqueta());
		}

		IgUtilBO.assignNextVal(srvcVO);

		srvcVO.setNumero(ServicioVO.convertNumero(secuencia));

		for (final SubservicioVO ssrvVO : ssrvList) {
			final Long ssrvIdActual = ssrvVO.getId();

			IgUtilBO.assignNextVal(ssrvVO);

			ssrvVO.setSrvc(srvcVO);

			ssrvIds.put(ssrvIdActual, ssrvVO.getId());
		}

		srvcDAO.insert(srvcVO);

		for (final Object tpdtId : srvcVO.getItdtMap().keySet()) {
			final ItemDatoVO itdtVO = srvcVO.getItdtMap().get(tpdtId);

			itdtVO.setTpdtId(tpdtId instanceof Long ? (Long) tpdtId : Long.parseLong(tpdtId.toString()));
			itdtVO.setItemId(srvcVO.getId());

			srdtDAO.insert(itdtVO);
		}

		for (final SubservicioVO ssrvVO : ssrvList) {
			ssrvDAO.insert(ssrvVO);
		}

		for (final ItemDatoVO ssdtVO : ssdtList) {
			ssdtVO.setItemId(ssrvIds.get(ssdtVO.getItemId()));

			ssdtDAO.insert(ssdtVO);
		}

		for (final SubservicioSubservicioVO ssssVO : ssssList) {
			ssssDAO.insert(new SubservicioSubservicioVO(ssrvIds.get(ssssVO.getSsrvPadreId()),
					ssrvIds.get(ssssVO.getSsrvHijoId())));
		}

		sracDAO.insert(srvcVO.getId());

		duplicatePostOperations(srvcVO);
	}

	/**
	 * Duplicate.
	 *
	 * @param srvcVO
	 *            the srvc vo
	 * @throws ModelException
	 *             the model exception
	 */
	protected void duplicatePostOperations(final ServicioVO srvcVO) throws ModelException {
		// noop
	}

	/**
	 * Delete.
	 *
	 * @param srvc
	 *            the srvc
	 * @throws ModelException
	 *             the model exception
	 */
	public final void delete(@NonNull final ServicioVO srvc) throws ModelException {
		Preconditions.checkNotNull(srvc.getId());

		final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();
		final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
		final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

		srvcCriterio.setId(srvc.getId());
		ssrvCriterio.setSrvc(srvcCriterio);
		ssssCriterio.setSrvcId(srvc.getId());

		ssssDAO.deleteList(ssssCriterio);
		ssdtDAO.deleteList(ssrvCriterio);
		ssrvDAO.deleteList(ssrvCriterio);
		srdtDAO.deleteList(srvcCriterio);
		srarDAO.deleteList(srvc.getId());
		sracDAO.deleteList(srvc.getId());

		final int updated = srvcDAO.delete(srvc);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.srvc, srvc);
		}

		deletePostOperations(srvc);
	}

	/**
	 * Delete.
	 *
	 * @param srvc
	 *            the srvc
	 * @throws ModelException
	 *             the model exception
	 */
	protected void deletePostOperations(final ServicioVO srvc) throws ModelException {
		// noop
	}

	/**
	 * Statechange.
	 *
	 * @param ittr
	 *            the ittr
	 * @throws ModelException
	 *             the model exception
	 */
	public final void statechange(@NonNull final ItemTramiteVO ittr) throws ModelException {
		Preconditions.checkNotNull(ittr.getItemId());
		Preconditions.checkNotNull(ittr.getTrmt());
		Preconditions.checkNotNull(ittr.getTrmt().getId());
		Preconditions.checkNotNull(ittr.getTrmt().getEntiId());

		final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

		srvcCriterio.setId(ittr.getItemId());

		final ServicioVO srvc = srvcDAO.selectObject(srvcCriterio);

		if (srvc == null) {
			throw new InstanceNotFoundException(ittr.getTrmt().getEntiId(), ittr.getItemId());
		}

		if (srvcDAO.updateEstado(ittr) == 0) {
			throw new InstanceNotFoundException(ittr.getTrmt().getEntiId(), ittr.getItemId());
		}

		final TramiteDetailVO trmtDetail = trmtProxy.select(ittr.getTrmt().getId());

		IgUtilBO.assignNextVal(ittr);

		ittr.setFecha(Calendar.getInstance().getTime());

		ittrDAO.insert(ittr);
		srtrDAO.insert(ittr);

		for (final Long tpdtId : ittr.getIttdMap().keySet()) {
			final ItemTramiteDatoVO ittd = ittr.getIttdMap().get(tpdtId);

			ittd.setTpdtId(tpdtId);
			ittd.setIttrId(ittr.getId());

			final ItemDatoVO itdt = new ItemDatoVO();

			itdt.setItemId(ittr.getItemId());
			itdt.setTpdtId(tpdtId);
			itdt.setCantidadEntera(ittd.getDnentero());
			itdt.setCantidadDecimal(ittd.getDndecimal());
			itdt.setCadena(ittd.getDcadena());
			itdt.setFecha(ittd.getDfecha());
			itdt.setPrmt(ittd.getDprmt());
			itdt.setSrvc(ittd.getDsrvc());

			srdtDAO.update(itdt);
			ittdDAO.insert(ittd);
		}

		sracDAO.deleteList(ittr.getItemId());
		sracDAO.insert(ittr.getItemId());

		statechangePostOperations(srvc, ittr, trmtDetail);
	}

	/**
	 * Statechange post operations.
	 *
	 * @param srvc
	 *            the srvc
	 * @param srtr
	 *            the srtr
	 * @param trmtDetail
	 *            the trmt detail
	 * @throws ModelException
	 *             the model exception
	 */
	protected void statechangePostOperations(final ServicioVO srvc, final ItemTramiteVO srtr,
			final TramiteDetailVO trmtDetail) throws ModelException {
		// noop
	}

	/**
	 * Fill dependencies.
	 *
	 * @param srvcList
	 *            the srvc list
	 * @param srvcCriterioVO
	 *            the srvc criterio vo
	 * @param useIds
	 *            the use ids
	 */
	private final void fillDependencies(@NonNull final List<ServicioVO> srvcList,
			@NonNull final ServicioCriterioVO srvcCriterioVO, final boolean useIds) {
		if (!srvcList.isEmpty()) {
			if (useIds) {
				final Set<Long> srvcIds = new HashSet<>();

				for (final ServicioVO srvcVO : srvcList) {
					srvcIds.add(srvcVO.getId());
				}

				srvcCriterioVO.setIds(srvcIds);
			}

			final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

			for (final ItemDatoVO itdtVO : srdtDAO.selectList(srvcCriterioVO)) {
				if (!map.containsKey(itdtVO.getItemId())) {
					map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
				}

				map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

				itdtVO.setItemId(null);
				itdtVO.setTpdtId(null);
			}

			for (final ServicioVO srvcVO : srvcList) {
				srvcVO.setItdtMap(map.get(srvcVO.getId()));
			}

			if (useIds) {
				srvcCriterioVO.setIds(null);
			}
		}
	}

	/**
	 * Fill user specific filter.
	 *
	 * @param srvcCriterio
	 *            the srvc criterio
	 */
	private void fillUserSpecificFilter(@NonNull final ServicioCriterioVO srvcCriterio) {
		srvcCriterio.setEntiId(entiId);

		final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

		usroCriterio.setId(usroId);

		final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

		if (usro == null) {
			throw new Error("Usuario no encontrado: " + usroId);
		}

		srvcCriterio.setUsroId(usro.getId());

		if (usro.getSprt() != null) {
			srvcCriterio.setUsroSprtId(usro.getSprt().getId());
		}

		if (usro.getPrto() != null) {
			srvcCriterio.setUsroPrtoId(usro.getPrto().getId());
		}

		if (usro.getOrga() != null) {
			srvcCriterio.setUsroOrgaId(usro.getPrto().getId());
		}
	}

}
