package xeredi.argo.model.maestro.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
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

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.dao.SubparametroDAO;
import xeredi.argo.model.maestro.dao.SubparametroDatoDAO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroServiceImpl.
 */
@Transactional(executorType = ExecutorType.BATCH)
public class SubparametroService {

	/** The sprm DAO. */
	private final SubparametroDAO sprmDAO;

	/** The spdt DAO. */
	private final SubparametroDatoDAO spdtDAO;

	/**
	 * Instantiates a new subparametro service.
	 *
	 * @param sprmDAO
	 *            the sprm DAO
	 * @param spdtDAO
	 *            the spdt DAO
	 */
	@Inject
	protected SubparametroService(final SubparametroDAO sprmDAO, final SubparametroDatoDAO spdtDAO) {
		super();
		this.sprmDAO = sprmDAO;
		this.spdtDAO = spdtDAO;
	}

	/**
	 * Insert.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public void insert(SubparametroVO sprm, TipoSubparametroDetailVO tpspDetail) throws OverlapException {
		Preconditions.checkNotNull(sprm.getVersion());

		// Validar que los datos del subparametro son correctos
		if (tpspDetail.getEntdList() != null) {
			for (final Long tpdtId : tpspDetail.getEntdList()) {
				if (!sprm.getItdtMap().containsKey(tpdtId)) {
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(tpdtId);
					sprm.getItdtMap().put(tpdtId, itdt);
				}
			}
		}

		if (sprmDAO.exists(sprm)) {
			sprm.setId(sprmDAO.selectId(sprm));
		} else {
			IgUtilBO.assignNextVal(sprm);

			sprmDAO.insert(sprm);
		}

		IgUtilBO.assignNextVal(sprm.getVersion());

		if (sprmDAO.existsOverlap(sprm)) {
			throw new OverlapException(sprm.getEntiId(), sprm);
		}

		sprmDAO.insertVersion(sprm);

		if (sprm.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
				itdtVO.setItemId(sprm.getVersion().getId());
				spdtDAO.insert(itdtVO);
			}
		}

		insertPostOperations(sprm, tpspDetail);
	}

	/**
	 * Insert post operations.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws OverlapException
	 *             the overlap exception
	 */
	protected void insertPostOperations(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail)
			throws OverlapException {
		// noop
	}

	/**
	 * Duplicate.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public void duplicate(SubparametroVO sprm, TipoSubparametroDetailVO tpspDetail) throws OverlapException {
		Preconditions.checkNotNull(sprm.getId());

		if (sprmDAO.exists(sprm)) {
			sprm.setId(sprmDAO.selectId(sprm));
		} else {
			IgUtilBO.assignNextVal(sprm);

			sprmDAO.insert(sprm);
		}

		IgUtilBO.assignNextVal(sprm.getVersion());

		if (sprmDAO.existsOverlap(sprm)) {
			throw new OverlapException(sprm.getEntiId(), sprm);
		}

		sprmDAO.insertVersion(sprm);

		if (sprm.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
				itdtVO.setItemId(sprm.getVersion().getId());
				spdtDAO.insert(itdtVO);
			}
		}

		duplicatePostOperations(sprm, tpspDetail);
	}

	/**
	 * Duplicate post operations.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws OverlapException
	 *             the overlap exception
	 */
	protected void duplicatePostOperations(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail)
			throws OverlapException {
		// noop
	}

	/**
	 * Update.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public void update(SubparametroVO sprm, TipoSubparametroDetailVO tpspDetail)
			throws InstanceNotFoundException, OverlapException {
		Preconditions.checkNotNull(sprm.getVersion());
		Preconditions.checkNotNull(sprm.getVersion().getId());
		Preconditions.checkNotNull(sprm.getVersion().getFini());

		// Validaciones

		// Validar que los datos del parametro son correctos
		if (tpspDetail.getEntdList() != null) {
			for (final Long tpdtId : tpspDetail.getEntdList()) {
				if (!sprm.getItdtMap().containsKey(tpdtId)) {
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(tpdtId);
					sprm.getItdtMap().put(tpdtId, itdt);

					// throw new Error("No se ha pasado informacion del dato "
					// + tpspVO.getEntdMap().get(tpdtId).getTpdt().getNombre() +
					// " del subparametro: " +
					// sprm);
				}
			}
		}

		if (sprmDAO.existsOverlap(sprm)) {
			throw new OverlapException(sprm.getEntiId(), sprm);
		}

		final int updated = sprmDAO.updateVersion(sprm);

		if (updated == 0) {
			throw new InstanceNotFoundException(sprm.getEntiId(), sprm);
		}

		if (sprm.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
				itdtVO.setItemId(sprm.getVersion().getId());
				spdtDAO.update(itdtVO);
			}
		}

		updatePostOperations(sprm, tpspDetail);
	}

	/**
	 * Update post operations.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	protected void updatePostOperations(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail)
			throws InstanceNotFoundException, OverlapException {
		// noop
	}

	/**
	 * Delete.
	 *
	 * @param sprm
	 *            the sprm
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(SubparametroVO sprm) throws InstanceNotFoundException {
		Preconditions.checkNotNull(sprm.getVersion());
		Preconditions.checkNotNull(sprm.getVersion().getId());

		final SubparametroCriterioVO sprmCriterio = new SubparametroCriterioVO();

		sprmCriterio.setVersionId(sprm.getVersion().getId());

		spdtDAO.deleteList(sprmCriterio);

		if (sprmDAO.deleteVersion(sprm) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.sprm, sprm);
		}

		deletePostOperations(sprm);
	}

	/**
	 * Delete post operations.
	 *
	 * @param sprm
	 *            the sprm
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	protected void deletePostOperations(final SubparametroVO sprm) throws InstanceNotFoundException {
		// noop
	}

	/**
	 * Select list.
	 *
	 * @param sprmCriterioVO
	 *            the sprm criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<SubparametroVO> selectList(SubparametroCriterioVO sprmCriterioVO, int offset, int limit) {
		final List<SubparametroVO> sprmList = new ArrayList<>();
		final int count = sprmDAO.count(sprmCriterioVO);

		if (count > offset) {
			sprmList.addAll(sprmDAO.selectList(sprmCriterioVO, new RowBounds(offset, limit)));

			fillDependencies(sprmList, sprmCriterioVO);
		}

		return new PaginatedList<>(sprmList, offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param sprmCriterioVO
	 *            the sprm criterio VO
	 * @return the list
	 */
	public List<SubparametroVO> selectList(SubparametroCriterioVO sprmCriterioVO) {
		final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);

		if (!sprmList.isEmpty()) {
			fillDependencies(sprmList, sprmCriterioVO);
		}

		return sprmList;
	}

	/**
	 * Select object.
	 *
	 * @param sprmId
	 *            the sprm id
	 * @param idioma
	 *            the idioma
	 * @param fechaVigencia
	 *            the fecha vigencia
	 * @return the subparametro VO
	 */
	public SubparametroVO selectObject(Long sprmId, String idioma, Date fechaVigencia) {
		final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

		sprmCriterioVO.setId(sprmId);
		sprmCriterioVO.setIdioma(idioma);
		sprmCriterioVO.setFechaVigencia(fechaVigencia);

		final SubparametroVO sprmVO = sprmDAO.selectObject(sprmCriterioVO);

		if (sprmVO != null) {
			fillDependencies(Arrays.asList(new SubparametroVO[] { sprmVO }), sprmCriterioVO);
		}

		return sprmVO;
	}

	/**
	 * Fill dependencies.
	 *
	 * @param sprmList
	 *            the sprm list
	 * @param sprmCriterioVO
	 *            the sprm criterio VO
	 */
	private void fillDependencies(final Collection<SubparametroVO> sprmList,
			final SubparametroCriterioVO sprmCriterioVO) {
		if (!sprmList.isEmpty()) {
			final Set<Long> spvrIds = new HashSet<>();

			for (final SubparametroVO sprmVO : sprmList) {
				spvrIds.add(sprmVO.getVersion().getId());
			}

			sprmCriterioVO.setVersionIds(spvrIds);

			final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

			for (final ItemDatoVO itdtVO : spdtDAO.selectList(sprmCriterioVO)) {
				if (!map.containsKey(itdtVO.getItemId())) {
					map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
				}

				map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

				itdtVO.setItemId(null);
				itdtVO.setTpdtId(null);
			}

			for (final SubparametroVO sprmVO : sprmList) {
				sprmVO.setItdtMap(map.get(sprmVO.getVersion().getId()));
			}

			sprmCriterioVO.setVersionIds(null);
		}
	}
}
