package xeredi.argo.model.servicio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.dao.ItemTramiteDAO;
import xeredi.argo.model.item.dao.ItemTramiteDatoDAO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.servicio.dao.ServicioActorDAO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioTramiteDAO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SetUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioService.
 */
@Transactional(executorType = ExecutorType.BATCH)
public class SubservicioService {

	/** The Constant SEGMENT_SIZE. */
	private static final int SEGMENT_SIZE = 500;

	/** The ssrv DAO. */
	private final SubservicioDAO ssrvDAO;

	/** The ssdt DAO. */
	private final SubservicioDatoDAO ssdtDAO;

	/** The ssss DAO. */
	private final SubservicioSubservicioDAO ssssDAO;

	/** The srac DAO. */
	private final ServicioActorDAO sracDAO;

	/** The ittr DAO. */
	private final ItemTramiteDAO ittrDAO;

	/** The sstr DAO. */
	private final SubservicioTramiteDAO sstrDAO;

	/** The ittd DAO. */
	private final ItemTramiteDatoDAO ittdDAO;

	/** The usro DAO. */
	private final UsuarioDAO usroDAO;

	/** The enti proxy. */
	private final EntidadProxyService entiProxy;

	/** The trmt proxy. */
	private final TramiteProxyService trmtProxy;

	/** The enti id. */
	private Long entiId;

	/** The usro id. */
	private Long usroId;

	/**
	 * Instantiates a new subservicio service.
	 *
	 * @param ssrvDAO
	 *            the ssrv DAO
	 * @param ssdtDAO
	 *            the ssdt DAO
	 * @param ssssDAO
	 *            the ssss DAO
	 * @param sracDAO
	 *            the srac DAO
	 * @param ittrDAO
	 *            the ittr DAO
	 * @param sstrDAO
	 *            the sstr DAO
	 * @param ittdDAO
	 *            the ittd DAO
	 * @param usroDAO
	 *            the usro DAO
	 * @param entiProxy
	 *            the enti proxy
	 * @param trmtProxy
	 *            the trmt proxy
	 */
	@Inject
	protected SubservicioService(final SubservicioDAO ssrvDAO, final SubservicioDatoDAO ssdtDAO,
			final SubservicioSubservicioDAO ssssDAO, final ServicioActorDAO sracDAO, final ItemTramiteDAO ittrDAO,
			final SubservicioTramiteDAO sstrDAO, final ItemTramiteDatoDAO ittdDAO, final UsuarioDAO usroDAO,
			final EntidadProxyService entiProxy, final TramiteProxyService trmtProxy) {
		super();
		this.ssrvDAO = ssrvDAO;
		this.ssdtDAO = ssdtDAO;
		this.ssssDAO = ssssDAO;
		this.sracDAO = sracDAO;
		this.ittrDAO = ittrDAO;
		this.sstrDAO = sstrDAO;
		this.ittdDAO = ittdDAO;
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
	 * Count.
	 *
	 * @param ssrvCriterio
	 *            the ssrv criterio
	 * @return the int
	 */
	public final int count(@NonNull final SubservicioCriterioVO ssrvCriterio) {
		fillUserSpecificFilter(ssrvCriterio);

		return ssrvDAO.count(ssrvCriterio);
	}

	/**
	 * Select list.
	 *
	 * @param ssrvCriterio
	 *            the ssrv criterio vo
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public final PaginatedList<SubservicioVO> selectList(@NonNull final SubservicioCriterioVO ssrvCriterio,
			final int offset, final int limit) {
		fillUserSpecificFilter(ssrvCriterio);

		final int count = ssrvDAO.count(ssrvCriterio);
		final List<SubservicioVO> ssrvList = count > offset
				? ssrvDAO.selectList(ssrvCriterio, new RowBounds(offset, limit)) : new ArrayList<>();

		fillDependencies(ssrvList, ssrvCriterio, true);

		return new PaginatedList<>(ssrvList, offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param ssrvCriterio
	 *            the ssrv criterio vo
	 * @return the list
	 */
	public final List<SubservicioVO> selectList(@NonNull final SubservicioCriterioVO ssrvCriterio) {
		fillUserSpecificFilter(ssrvCriterio);

		final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterio);

		fillDependencies(ssrvList, ssrvCriterio, false);

		return ssrvList;
	}

	/**
	 * Select label value object.
	 *
	 * @param ssrvCriterio
	 *            the ssrv criterio vo
	 * @return the label value vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final LabelValueVO selectLabelValueObject(@NonNull final SubservicioCriterioVO ssrvCriterio)
			throws InstanceNotFoundException {
		final SubservicioVO ssrv = selectObject(ssrvCriterio);

		return new LabelValueVO(ssrv.getEtiqueta(), ssrv.getId());
	}

	/**
	 * Select.
	 *
	 * @param ssrvId
	 *            the ssrv id
	 * @param idioma
	 *            the idioma
	 * @return the subservicio vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final SubservicioVO select(@NonNull final Long ssrvId, final String idioma)
			throws InstanceNotFoundException {
		final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

		ssrvCriterio.setId(ssrvId);
		ssrvCriterio.setIdioma(idioma);

		return selectObject(ssrvCriterio);
	}

	/**
	 * Select object.
	 *
	 * @param ssrvCriterio
	 *            the ssrv criterio
	 * @return the subservicio VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final SubservicioVO selectObject(@NonNull final SubservicioCriterioVO ssrvCriterio)
			throws InstanceNotFoundException {
		fillUserSpecificFilter(ssrvCriterio);

		final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterio);

		if (ssrv == null) {
			throw new InstanceNotFoundException(MessageI18nKey.ssrv, ssrvCriterio);
		}

		// Busqueda de los padres (si tiene)
		if (!entiProxy.selectTpss(ssrv.getEntiId()).getEntiPadresList().isEmpty()) {
			final SubservicioCriterioVO ssrvPadreCriterio = new SubservicioCriterioVO();

			ssrvPadreCriterio.setHijoId(ssrv.getId());

			for (final SubservicioVO ssrvPadre : ssrvDAO.selectList(ssrvPadreCriterio)) {
				ssrv.getSsrvPadreMap().put(ssrvPadre.getEntiId(), ssrvPadre);
			}
		}

		fillDependencies(Arrays.asList(new SubservicioVO[] { ssrv }), ssrvCriterio, true);

		return ssrv;
	}

	/**
	 * Select lupa list.
	 *
	 * @param ssrvTypeaheadCriterio
	 *            the ssrv typeahead criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	public final List<SubservicioVO> selectTypeaheadList(@NonNull final SubservicioLupaCriterioVO ssrvTypeaheadCriterio,
			final int limit) {
		ssrvTypeaheadCriterio.setNumero(Integer.valueOf(ssrvTypeaheadCriterio.getTextoBusqueda()));

		return ssrvDAO.selectLupaList(ssrvTypeaheadCriterio, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
	}

	/**
	 * Insert.
	 *
	 * @param ssrvVO
	 *            the ssrv vo
	 * @param tpssDetail
	 *            the tpss detail
	 * @param ssrvPadreIds
	 *            the ssrv padre ids
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public final void insert(@NonNull final SubservicioVO ssrvVO, @NonNull final TipoSubservicioDetailVO tpssDetail,
			final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
		Preconditions.checkNotNull(ssrvVO.getSrvc());
		Preconditions.checkNotNull(ssrvVO.getSrvc().getId());

		// FIXME En entidades padre, NO debería estar el propio tipo de servicio
		// if (tpssDetail.getEntiPadresList() != null &&
		// !tpssDetail.getEntiPadresList().isEmpty()) {
		// Preconditions.checkNotNull(ssrvPadreIds);
		// Preconditions.checkArgument(!ssrvPadreIds.isEmpty());
		// }

		if (tpssDetail.getEntdList() != null) {
			for (final Long tpdtId : tpssDetail.getEntdList()) {
				if (!ssrvVO.getItdtMap().containsKey(tpdtId)) {
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(tpdtId);
					ssrvVO.getItdtMap().put(tpdtId, itdt);
				}
			}
		}

		if (ssrvDAO.exists(ssrvVO)) {
			throw new DuplicateInstanceException(ssrvVO.getEntiId(), ssrvVO);
		}

		IgUtilBO.assignNextVal(ssrvVO);

		ssrvDAO.insert(ssrvVO);

		for (final Long tpdtId : ssrvVO.getItdtMap().keySet()) {
			final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

			itdtVO.setItemId(ssrvVO.getId());
			itdtVO.setTpdtId(tpdtId);
			ssdtDAO.insert(itdtVO);
		}

		if (ssrvPadreIds != null) {
			for (final Long ssrvPadreId : ssrvPadreIds) {
				final SubservicioSubservicioVO ssssVO = new SubservicioSubservicioVO(ssrvPadreId, ssrvVO.getId());

				ssssDAO.insert(ssssVO);
			}
		}

		sracDAO.deleteList(ssrvVO.getSrvc().getId());
		sracDAO.insert(ssrvVO.getSrvc().getId());

		insertPostOperations(ssrvVO, tpssDetail, ssrvPadreIds);
	}

	/**
	 * Insert post operations.
	 *
	 * @param ssrvVO
	 *            the ssrv vo
	 * @param tpssDetail
	 *            the tpss detail
	 * @param ssrvPadreIds
	 *            the ssrv padre ids
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	protected void insertPostOperations(final SubservicioVO ssrvVO, final TipoSubservicioDetailVO tpssDetail,
			final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
		// noop
	}

	/**
	 * Update.
	 *
	 * @param ssrvVO
	 *            the ssrv vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final void update(@NonNull final SubservicioVO ssrvVO) throws InstanceNotFoundException {
		Preconditions.checkNotNull(ssrvVO.getSrvc());
		Preconditions.checkNotNull(ssrvVO.getSrvc().getId());

		if (ssrvVO.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
				itdtVO.setItemId(ssrvVO.getId());
				ssdtDAO.update(itdtVO);
			}
		}

		sracDAO.deleteList(ssrvVO.getSrvc().getId());
		sracDAO.insert(ssrvVO.getSrvc().getId());

		updatePostOperations(ssrvVO);
	}

	/**
	 * Update.
	 *
	 * @param ssrvVO
	 *            the ssrv vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	protected void updatePostOperations(final SubservicioVO ssrvVO) throws InstanceNotFoundException {
		// noop
	}

	/**
	 * Duplicado de un subservicio. Implica las siguientes operaciones:
	 * <ul>
	 * <li>Duplicado del subservicio y sus datos asociados.</li>
	 * <li>Duplicado de los subservicio dependientes (hijos, nietos, ...) y sus
	 * datos asociados.</li>
	 * <li>Duplicado de las relaciones entre los subservicio duplicados.</li>
	 * <li>Recálculo de los actores del servicio al que pertenece el subservicio
	 * duplicado.</li>
	 * </ul>
	 *
	 * @param ssrv
	 *            the ssrv vo
	 *
	 * @see SubservicioService#duplicatePostOperations(SubservicioVO)
	 */
	public final void duplicate(@NonNull final SubservicioVO ssrv) {
		Preconditions.checkNotNull(ssrv.getId());
		Preconditions.checkNotNull(ssrv.getEntiId());
		Preconditions.checkNotNull(ssrv.getSrvc());
		Preconditions.checkNotNull(ssrv.getSrvc().getId());

		// Identificadores de los subservicios a eliminar
		final Set<Long> ssrvIds = new HashSet<>();

		// Busqueda de los hijos sel servicio a duplicar
		{
			ssrvIds.add(ssrv.getId());

			final Set<Long> ssrvPadreIds = new HashSet<>(ssrvIds);
			final Set<Long> ssrvHijoIds = new HashSet<>();

			do {
				ssrvHijoIds.clear();

				for (final Set<Long> division : SetUtil.divide(ssrvPadreIds, SEGMENT_SIZE)) {
					Preconditions.checkArgument(!division.isEmpty());

					final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

					ssssCriterio.getSsrvPadreIds().addAll(division);

					for (final SubservicioSubservicioVO ssss : ssssDAO.selectList(ssssCriterio)) {
						ssrvHijoIds.add(ssss.getSsrvHijoId());
					}
				}

				ssrvPadreIds.clear();
				ssrvIds.addAll(ssrvHijoIds);
				ssrvPadreIds.addAll(ssrvHijoIds);
			} while (!ssrvPadreIds.isEmpty());
		}

		// Traduccion de ids entre el subservicio a duplicar y el
		// subservicio duplicado
		final Map<Long, Long> translationIds = new HashMap<>();

		// Alta del subservicio pasado como argumento y sus datos asociados
		final Long oldId = new Long(ssrv.getId());

		{
			IgUtilBO.assignNextVal(ssrv);

			translationIds.put(oldId, ssrv.getId());

			ssrvDAO.insert(ssrv);

			for (final Long tpdtId : ssrv.getItdtMap().keySet()) {
				final ItemDatoVO itdt = ssrv.getItdt(tpdtId);

				itdt.setItemId(ssrv.getId());
				itdt.setTpdtId(tpdtId);

				ssdtDAO.insert(itdt);
			}
		}

		// Busqueda de los subservicios y duplicado de los mismos
		{
			Preconditions.checkArgument(!ssrvIds.isEmpty());

			for (final Set<Long> division : SetUtil.divide(ssrvIds, SEGMENT_SIZE)) {
				Preconditions.checkArgument(!division.isEmpty());

				final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

				ssrvCriterio.setIds(division);

				for (final SubservicioVO oldSsrv : ssrvDAO.selectList(ssrvCriterio)) {
					// Si el subservicio tiene el id del subservicio pasado
					// como argumento, no lo
					// insertamos (ya insertado)
					if (!oldSsrv.getId().equals(oldId)) {
						final TipoSubservicioDetailVO tpss = entiProxy.selectTpss(oldSsrv.getEntiId());
						final SubservicioVO newSsrv = new SubservicioVO();

						newSsrv.setEstado(tpss.getEnti().getEstadoDef());
						newSsrv.setEntiId(oldSsrv.getEntiId());
						newSsrv.setNumero(oldSsrv.getNumero());
						newSsrv.setSrvc(oldSsrv.getSrvc());
						newSsrv.setFini(oldSsrv.getFini());
						newSsrv.setFfin(oldSsrv.getFfin());
						newSsrv.setFref(oldSsrv.getFref());

						IgUtilBO.assignNextVal(newSsrv);

						translationIds.put(oldSsrv.getId(), newSsrv.getId());

						ssrvDAO.insert(newSsrv);
					}
				}
			}
		}

		// Busqueda de los datos asociados a los subservicios y duplicado de
		// los mismos
		{
			Preconditions.checkArgument(!ssrvIds.isEmpty());

			for (final Set<Long> division : SetUtil.divide(ssrvIds, SEGMENT_SIZE)) {
				Preconditions.checkArgument(!division.isEmpty());

				final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

				ssrvCriterio.setIds(division);

				for (final ItemDatoVO oldItdt : ssdtDAO.selectList(ssrvCriterio)) {
					// Si el identificador del item es el del subservicio
					// pasado como argumento, no lo
					// insertamos (ya insertado)
					if (!oldItdt.getItemId().equals(oldId)) {
						final ItemDatoVO newItdt = new ItemDatoVO();

						newItdt.setItemId(translationIds.get(oldItdt.getItemId()));

						newItdt.setTpdtId(oldItdt.getTpdtId());
						newItdt.setCadena(oldItdt.getCadena());
						newItdt.setCantidadDecimal(oldItdt.getCantidadDecimal());
						newItdt.setCantidadEntera(oldItdt.getCantidadEntera());
						newItdt.setFecha(oldItdt.getFecha());
						newItdt.setPrmt(oldItdt.getPrmt());
						newItdt.setSrvc(oldItdt.getSrvc());

						ssdtDAO.insert(newItdt);
					}
				}
			}
		}

		// Busqueda de las relaciones de los subservicios a duplicar y
		// duplicado de las mismas
		{
			Preconditions.checkArgument(!ssrvIds.isEmpty());

			for (final Set<Long> division : SetUtil.divide(ssrvIds, SEGMENT_SIZE)) {
				Preconditions.checkArgument(!division.isEmpty());

				{
					// Duplicado como hijos
					final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

					ssssCriterio.getSsrvHijoIds().addAll(division);

					for (final SubservicioSubservicioVO oldSsss : ssssDAO.selectList(ssssCriterio)) {
						final SubservicioSubservicioVO newSsss = new SubservicioSubservicioVO(
								translationIds.containsKey(oldSsss.getSsrvPadreId())
										? translationIds.get(oldSsss.getSsrvPadreId()) : oldSsss.getSsrvPadreId(),
								translationIds.get(oldSsss.getSsrvHijoId()));

						ssssDAO.insert(newSsss);
					}
				}
			}
		}

		// Recalculo de los actores del servicio al que pertenece el
		// subservicio eliminado
		sracDAO.deleteList(ssrv.getSrvc().getId());
		sracDAO.insert(ssrv.getSrvc().getId());

		duplicatePostOperations(ssrv);
	}

	/**
	 * Duplicate post operations.
	 *
	 * @param ssrvVO
	 *            the ssrv vo
	 */
	protected void duplicatePostOperations(final SubservicioVO ssrvVO) {
		// noop
	}

	/**
	 * Borrado de un subservicio. Implica las siguientes operaciones:
	 * <ul>
	 * <li>Borrado del subservicio y sus datos asociados.</li>
	 * <li>Borrado de los subservicio dependientes (hijos, nietos, ...) y sus
	 * datos asociados.</li>
	 * <li>Borrado de las relaciones entre los subservicio borrados.</li>
	 * <li>Recálculo de los actores del servicio al que pertenece el subservicio
	 * borrado.</li>
	 * </ul>
	 *
	 * @param ssrv
	 *            the ssrv
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final void delete(@NonNull final SubservicioVO ssrv) throws InstanceNotFoundException {
		Preconditions.checkNotNull(ssrv.getId());
		Preconditions.checkNotNull(ssrv.getEntiId());
		Preconditions.checkNotNull(ssrv.getSrvc());
		Preconditions.checkNotNull(ssrv.getSrvc().getId());

		// Identificadores de los subservicios a eliminar
		final Set<Long> ssrvIds = new HashSet<>();

		// Busqueda de los hijos sel servicio a borrar
		ssrvIds.add(ssrv.getId());

		{
			final Set<Long> ssrvPadreIds = new HashSet<>(ssrvIds);
			final Set<Long> ssrvHijoIds = new HashSet<>();

			do {
				ssrvHijoIds.clear();

				for (final Set<Long> division : SetUtil.divide(ssrvPadreIds, SEGMENT_SIZE)) {
					Preconditions.checkArgument(!division.isEmpty());

					final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

					ssssCriterio.getSsrvPadreIds().addAll(division);

					for (final SubservicioSubservicioVO ssss : ssssDAO.selectList(ssssCriterio)) {
						ssrvHijoIds.add(ssss.getSsrvHijoId());
					}
				}

				ssrvPadreIds.clear();
				ssrvIds.addAll(ssrvHijoIds);
				ssrvPadreIds.addAll(ssrvHijoIds);
			} while (!ssrvPadreIds.isEmpty());
		}

		// Borrado de las relaciones de los subservicios a eliminar
		{
			Preconditions.checkArgument(!ssrvIds.isEmpty());

			for (final Set<Long> division : SetUtil.divide(ssrvIds, SEGMENT_SIZE)) {
				Preconditions.checkArgument(!division.isEmpty());

				{
					// Borrado como hijos
					final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

					ssssCriterio.getSsrvHijoIds().addAll(division);

					ssssDAO.deleteList(ssssCriterio);
				}

				{
					// Borrado como padres
					final SubservicioSubservicioCriterioVO ssssCriterio = new SubservicioSubservicioCriterioVO();

					ssssCriterio.getSsrvPadreIds().addAll(division);

					ssssDAO.deleteList(ssssCriterio);

				}
			}
		}

		// Borrado de los datos asociados a los subservicios
		{
			Preconditions.checkArgument(!ssrvIds.isEmpty());

			for (final Set<Long> division : SetUtil.divide(ssrvIds, SEGMENT_SIZE)) {
				Preconditions.checkArgument(!division.isEmpty());

				final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

				ssrvCriterio.setIds(division);
				ssdtDAO.deleteList(ssrvCriterio);
			}
		}

		// Borrado de los subservicios
		{
			Preconditions.checkArgument(!ssrvIds.isEmpty());

			for (final Set<Long> division : SetUtil.divide(ssrvIds, SEGMENT_SIZE)) {
				Preconditions.checkArgument(!division.isEmpty());

				final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

				ssrvCriterio.setIds(division);
				ssrvDAO.deleteList(ssrvCriterio);
			}
		}

		// Recalculo de los actores del servicio al que pertenece el
		// subservicio eliminado
		sracDAO.deleteList(ssrv.getSrvc().getId());
		sracDAO.insert(ssrv.getSrvc().getId());

		// FIXME Habria que pasar a deletePostOperations los padres del
		// subservicio eliminado
		deletePostOperations(ssrv);
	}

	/**
	 * Delete.
	 *
	 * @param ssrv
	 *            the ssrv
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	protected void deletePostOperations(final SubservicioVO ssrv) throws InstanceNotFoundException {
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

		// Modificacion del subservicio
		final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();

		ssrvCriterio.setId(ittr.getItemId());

		final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterio);

		if (ssrv == null) {
			throw new InstanceNotFoundException(ittr.getTrmt().getEntiId(), ittr.getItemId());
		}

		ssrv.setFini(ittr.getDitemFini());
		ssrv.setFfin(ittr.getDitemFfin());

		ssrvDAO.update(ssrv);

		// Alta del tramite
		final TramiteDetailVO trmtDetail = trmtProxy.select(ittr.getTrmt().getId());

		IgUtilBO.assignNextVal(ittr);

		ittr.setFecha(Calendar.getInstance().getTime());

		if (ssrvDAO.updateEstado(ittr) == 0) {
			throw new InstanceNotFoundException(ssrv.getEntiId(), ssrv.getId());
		}

		ittrDAO.insert(ittr);
		sstrDAO.insert(ittr);

		// Modificacion de los datos del subservicio introducidos en el tramite
		// (si los hay)
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

			ssdtDAO.update(itdt);
			ittdDAO.insert(ittd);
		}

		sracDAO.deleteList(ssrv.getSrvc().getId());
		sracDAO.insert(ssrv.getSrvc().getId());

		statechangePostOperations(ssrv, ittr, trmtDetail);
	}

	/**
	 * Statechange post operations.
	 *
	 * @param ssrv
	 *            the ssrv
	 * @param ittr
	 *            the ittr
	 * @param trmtDetail
	 *            the trmt detail
	 * @throws ModelException
	 *             the model exception
	 */
	protected void statechangePostOperations(final SubservicioVO ssrv, final ItemTramiteVO ittr,
			final TramiteDetailVO trmtDetail) throws ModelException {
		// noop
	}

	/**
	 * Fill dependencies.
	 *
	 * @param ssrvList
	 *            the ssrv list
	 * @param ssrvCriterioVO
	 *            the ssrv criterio VO
	 * @param useIds
	 *            the use ids
	 */
	private final void fillDependencies(@NonNull final List<SubservicioVO> ssrvList,
			@NonNull final SubservicioCriterioVO ssrvCriterioVO, final boolean useIds) {
		// Datos asociados
		if (!ssrvList.isEmpty()) {
			if (useIds) {
				final Set<Long> ssrvIds = new HashSet<>();

				for (final SubservicioVO ssrvVO : ssrvList) {
					ssrvIds.add(ssrvVO.getId());
				}

				ssrvCriterioVO.setIds(ssrvIds);
			}

			final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

			for (final ItemDatoVO itdtVO : ssdtDAO.selectList(ssrvCriterioVO)) {
				if (!itdtMap.containsKey(itdtVO.getItemId())) {
					itdtMap.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
				}

				itdtMap.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

				itdtVO.setItemId(null);
				itdtVO.setTpdtId(null);
			}

			for (final SubservicioVO ssrvVO : ssrvList) {
				ssrvVO.setItdtMap(itdtMap.get(ssrvVO.getId()));
			}

			if (useIds) {
				ssrvCriterioVO.setIds(null);
			}
		}
	}

	/**
	 * Fill user specific filter.
	 *
	 * @param ssrvCriterio
	 *            the ssrv criterio
	 */
	private void fillUserSpecificFilter(@NonNull final SubservicioCriterioVO ssrvCriterio) {
		ssrvCriterio.setEntiId(entiId);

		final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

		usroCriterio.setId(usroId);

		final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

		if (usro == null) {
			throw new Error("Usuario no encontrado: " + usroId);
		}

		ssrvCriterio.setUsroId(usro.getId());

		if (usro.getSprt() != null) {
			ssrvCriterio.setUsroSprtId(usro.getSprt().getId());
		}

		if (usro.getPrto() != null) {
			ssrvCriterio.setUsroPrtoId(usro.getPrto().getId());
		}

		if (usro.getOrga() != null) {
			ssrvCriterio.setUsroOrgaId(usro.getPrto().getId());
		}
	}

}
