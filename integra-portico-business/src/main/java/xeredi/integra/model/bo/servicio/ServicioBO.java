package xeredi.integra.model.bo.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.comun.IgBO;
import xeredi.integra.model.dao.servicio.ServicioDAO;
import xeredi.integra.model.dao.servicio.ServicioDatoDAO;
import xeredi.integra.model.dao.servicio.ServicioSecuenciaDAO;
import xeredi.integra.model.dao.servicio.SubservicioDAO;
import xeredi.integra.model.dao.servicio.SubservicioDatoDAO;
import xeredi.integra.model.dao.servicio.SubservicioSubservicioDAO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.servicio.ServicioCriterioVO;
import xeredi.integra.model.vo.servicio.ServicioLupaCriterioVO;
import xeredi.integra.model.vo.servicio.ServicioVO;
import xeredi.integra.model.vo.servicio.SubservicioCriterioVO;
import xeredi.integra.model.vo.servicio.SubservicioSubservicioVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioBO.
 */
@Singleton
public class ServicioBO implements Servicio {

	/** The srvc dao. */
	@Inject
	ServicioDAO srvcDAO;

	@Inject
	ServicioSecuenciaDAO srscDAO;

	/** The srdt dao. */
	@Inject
	ServicioDatoDAO srdtDAO;

	/** The ssrv dao. */
	@Inject
	SubservicioDAO ssrvDAO;

	/** The ssdt dao. */
	@Inject
	SubservicioDatoDAO ssdtDAO;

	/** The ssss dao. */
	@Inject
	SubservicioSubservicioDAO ssssDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final ServicioVO select(final Long srvcId, final String idioma)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(srvcId);
		Preconditions.checkNotNull(idioma);

		final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

		srvcCriterioVO.setId(srvcId);
		srvcCriterioVO.setIdioma(idioma);

		final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

		if (srvcVO == null) {
			throw new InstanceNotFoundException(ServicioVO.class.getName(),
					srvcId);
		}

		fillDependencies(Arrays.asList(new ServicioVO[] { srvcVO }),
				srvcCriterioVO, true);

		return srvcVO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final PaginatedList<ServicioVO> selectList(
			final ServicioCriterioVO srvcCriterioVO, final int offset,
			final int limit) {
		Preconditions.checkNotNull(srvcCriterioVO);

		final int count = srvcDAO.selectCount(srvcCriterioVO);
		final List<ServicioVO> srvcList = new ArrayList<>();

		if (count > offset) {
			srvcList.addAll(srvcDAO.selectList(srvcCriterioVO, new RowBounds(offset, limit)));

			// FIXME Ojo en la paginacion, puede traer una barbaridad de
			// dependencias
			fillDependencies(srvcList, srvcCriterioVO, true);
		}

		return new PaginatedList<>(srvcList, offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(executorType = ExecutorType.BATCH)
	public final List<ServicioVO> selectList(
			final ServicioCriterioVO srvcCriterioVO) {
		Preconditions.checkNotNull(srvcCriterioVO);

		final List<ServicioVO> srvcList = srvcDAO.selectList(srvcCriterioVO);

		// FIXME Ojo en la paginacion, puede traer una barbaridad de
		// dependencias
		fillDependencies(srvcList, srvcCriterioVO,
				srvcCriterioVO.getLimit() != null);

		return srvcList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<LabelValueVO> selectLupaList(
			final ServicioLupaCriterioVO srvcLupaCriterioVO, final int limit) {
		Preconditions.checkNotNull(srvcLupaCriterioVO);

		return srvcDAO.selectLupaList(srvcLupaCriterioVO, new RowBounds(0, limit));
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
	private final void fillDependencies(final List<ServicioVO> srvcList,
			final ServicioCriterioVO srvcCriterioVO, final boolean useIds) {
		Preconditions.checkNotNull(srvcList);
		Preconditions.checkNotNull(srvcCriterioVO);

		if (!srvcList.isEmpty()) {
			if (useIds) {
				final Set<Long> srvcIds = new HashSet<>();

				for (final ServicioVO srvcVO : srvcList) {
					srvcIds.add(srvcVO.getId());
				}

				srvcCriterioVO.setIds(srvcIds);
			}

			final List<ItemDatoVO> itdtList = srdtDAO
					.selectList(srvcCriterioVO);
			final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

			for (final ItemDatoVO itdtVO : itdtList) {
				if (!map.containsKey(itdtVO.getItemId())) {
					map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
				}

				map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);
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
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(executorType = ExecutorType.BATCH)
	public final void insert(final ServicioVO srvcVO,
			final List<SubservicioVO> ssrvList)
					throws DuplicateInstanceException {
		Preconditions.checkNotNull(srvcVO);
		// Preconditions.checkNotNull(ssrvList);

		final IgBO igBO = new IgBO();

		srscDAO.incrementarSecuencia(srvcVO);

		final Integer secuencia = srscDAO.obtenerSecuencia(srvcVO);

		if (secuencia == null) {
			throw new Error("No se encuentra secuencia para: " + srvcVO);
		}

		srvcVO.setNumero(ServicioVO.convertNumero(secuencia));

		if (srvcDAO.exists(srvcVO)) {
			throw new DuplicateInstanceException(ServicioVO.class.getName(),
					srvcVO);
		}

		srvcVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
		srvcDAO.insert(srvcVO);

		if (srvcVO.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : srvcVO.getItdtMap().values()) {
				itdtVO.setItemId(srvcVO.getId());
				srdtDAO.insert(itdtVO);
			}
		}

		if (ssrvList != null) {
			for (final SubservicioVO ssrvVO : ssrvList) {
				ssrvVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
				ssrvVO.setSrvc(srvcVO);
				ssrvDAO.insert(ssrvVO);
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
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(executorType = ExecutorType.BATCH)
	public final void update(final ServicioVO srvcVO) {
		Preconditions.checkNotNull(srvcVO);

		for (final ItemDatoVO itdtVO : srvcVO.getItdtMap().values()) {
			srdtDAO.update(itdtVO);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(executorType = ExecutorType.BATCH)
	public final void duplicate(final ServicioVO srvcVO) {
		Preconditions.checkNotNull(srvcVO);

		final IgBO igBO = new IgBO();
		final Map<Long, Long> ssrvIds = new HashMap<>();

		// Busqueda de los elementos a duplicar
		final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();
		final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

		srvcCriterioVO.setId(srvcVO.getId());
		ssrvCriterioVO.setSrvc(srvcCriterioVO);

		final List<SubservicioVO> ssrvList = ssrvDAO.selectList(ssrvCriterioVO);
		final List<ItemDatoVO> ssdtList = ssdtDAO.selectList(ssrvCriterioVO);
		final List<SubservicioSubservicioVO> ssssList = ssssDAO
				.selectList(ssrvCriterioVO);

		// Duplicado del servicio. Se duplica el propio servicio y sus datos
		// asociados, los
		// subservicios y
		// los datos asociados, y las relaciones entre subservicios.
		srscDAO.incrementarSecuencia(srvcVO);

		final Integer secuencia = srscDAO.obtenerSecuencia(srvcVO);
		final Long srvcIdActual = srvcVO.getId();

		if (secuencia == null) {
			throw new Error("No se encuentra secuencia para: "
					+ srvcVO.getEtiqueta());
		}

		srvcVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
		srvcVO.setNumero(ServicioVO.convertNumero(secuencia));

		srvcDAO.insert(srvcVO);

		for (final SubservicioVO ssrvVO : ssrvList) {
			final Long ssrvIdActual = ssrvVO.getId();

			ssrvVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
			ssrvVO.setSrvc(srvcVO);
			ssrvDAO.insert(ssrvVO);

			ssrvIds.put(ssrvIdActual, ssrvVO.getId());
		}

		for (final ItemDatoVO itdtVO : srvcVO.getItdtMap().values()) {
			itdtVO.setItemId(srvcVO.getId());
			srdtDAO.insert(itdtVO);
		}

		for (final ItemDatoVO ssdtVO : ssdtList) {
			ssdtVO.setItemId(ssrvIds.get(ssdtVO.getItemId()));
			ssdtDAO.insert(ssdtVO);
		}

		for (final SubservicioSubservicioVO ssssVO : ssssList) {
			ssssDAO.insert(new SubservicioSubservicioVO(ssrvIds.get(ssssVO
					.getSsrvPadreId()), ssrvIds.get(ssssVO.getSsrvHijoId())));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final void delete(final Long srvcId)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(srvcId);

		final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();
		final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

		srvcCriterioVO.setId(srvcId);
		ssrvCriterioVO.setSrvc(srvcCriterioVO);

		ssssDAO.delete(ssrvCriterioVO);

		ssdtDAO.delete(ssrvCriterioVO);
		ssrvDAO.delete(ssrvCriterioVO);

		srdtDAO.delete(srvcCriterioVO);

		final int updated = srvcDAO.delete(srvcId);

		if (updated == 0) {
			throw new InstanceNotFoundException(ServicioVO.class.getName(),
					srvcId);
		}
	}

}
