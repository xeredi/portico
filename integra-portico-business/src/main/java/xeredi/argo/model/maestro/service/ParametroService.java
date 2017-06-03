package xeredi.argo.model.maestro.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.dao.ParametroDAO;
import xeredi.argo.model.maestro.dao.ParametroDatoDAO;
import xeredi.argo.model.maestro.dao.SubparametroDAO;
import xeredi.argo.model.maestro.dao.SubparametroDatoDAO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroServiceImpl.
 */
@Transactional(executorType = ExecutorType.BATCH)
public class ParametroService {
	/** The prmt DAO. */
	@Inject
	private ParametroDAO prmtDAO;

	/** The prdt DAO. */
	@Inject
	private ParametroDatoDAO prdtDAO;

	/** The sprm DAO. */
	@Inject
	private SubparametroDAO sprmDAO;

	/** The spdt DAO. */
	@Inject
	private SubparametroDatoDAO spdtDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Insert.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public void insert(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException {
		Preconditions.checkNotNull(prmt.getParametro());
		Preconditions.checkNotNull(prmt.getVersion());
		Preconditions.checkNotNull(prmt.getVersion().getFini());

		if (tpprDetail.getEnti().isI18n()) {
			Preconditions.checkNotNull(i18nMap);
		}

		// Validar que los datos del parametro son correctos
		if (tpprDetail.getEntdList() != null && !tpprDetail.getEntdList().isEmpty()) {
			for (final Long tpdtId : tpprDetail.getEntdList()) {
				final EntidadTipoDatoVO entd = tpprDetail.getEntdMap().get(tpdtId);

				if (!prmt.getItdtMap().containsKey(entd.getTpdt().getId())) {
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(entd.getTpdt().getId());
					prmt.getItdtMap().put(entd.getTpdt().getId(), itdt);
				}
			}
		}

		if (prmtDAO.exists(prmt)) {
			prmt.setId(prmtDAO.selectId(prmt));
		} else {
			IgUtilBO.assignNextVal(prmt);

			prmtDAO.insert(prmt);
		}

		IgUtilBO.assignNextVal(prmt.getVersion());

		if (prmtDAO.existsOverlap(prmt)) {
			throw new OverlapException(MessageI18nKey.prmt, prmt);
		}

		prmtDAO.insertVersion(prmt);

		if (tpprDetail.getEnti().isI18n()) {
			i18nService.insertMap(prmt, i18nMap);
		}

		if (prmt.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
				itdtVO.setItemId(prmt.getVersion().getId());
				prdtDAO.insert(itdtVO);
			}
		}

		insertPostOperations(prmt, tpprDetail, i18nMap);
	}

	/**
	 * Insert post operations.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 */
	protected void insertPostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap) {
		// noop
	}

	/**
	 * Duplicate.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void duplicate(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
		Preconditions.checkNotNull(prmt.getId());
		Preconditions.checkNotNull(prmt.getParametro());
		Preconditions.checkNotNull(prmt.getVersion());
		Preconditions.checkNotNull(prmt.getVersion().getFini());

		if (tpprDetail.getEnti().isI18n()) {
			Preconditions.checkNotNull(i18nMap);
		}

		// Validar que los datos del parametro son correctos
		if (tpprDetail.getEntdList() != null && !tpprDetail.getEntdList().isEmpty()) {
			for (final Long tpdtId : tpprDetail.getEntdList()) {
				if (!prmt.getItdtMap().containsKey(tpdtId)) {
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(tpdtId);
					prmt.getItdtMap().put(tpdtId, itdt);

					// throw new Error("No se ha pasado informacion del dato "
					// + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() +
					// " del parametro: " +
					// prmt);
				}
			}
		}

		// Busqueda del parametro a duplicar
		final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

		prmtCriterio.setVersionId(prmt.getVersion().getId());

		final ParametroVO prmtActual = prmtDAO.selectObject(prmtCriterio);

		if (prmtActual == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prmt, prmt);
		}

		// Alta del nuevo parametro
		if (prmtDAO.exists(prmt)) {
			prmt.setId(prmtDAO.selectId(prmt));
		} else {
			IgUtilBO.assignNextVal(prmt);

			prmtDAO.insert(prmt);
		}

		IgUtilBO.assignNextVal(prmt.getVersion());

		if (prmtDAO.existsOverlap(prmt)) {
			throw new OverlapException(MessageI18nKey.prmt, prmt);
		}

		prmtDAO.insertVersion(prmt);

		if (tpprDetail.getEnti().isI18n()) {
			i18nService.insertMap(prmt, i18nMap);
		}

		if (prmt.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
				itdtVO.setItemId(prmt.getVersion().getId());

				prdtDAO.insert(itdtVO);
			}
		}

		if (!prmtActual.getId().equals(prmt.getId())) {
			// Duplicado de subparametros

			if (tpprDetail.getEntiHijasList() != null && !tpprDetail.getEntiHijasList().isEmpty()) {
				final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();
				final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

				prmtCriterioVO.setId(prmtActual.getId());
				sprmCriterioVO.setPrmt(prmtCriterioVO);
				sprmCriterioVO.setFechaVigencia(prmtActual.getVersion().getFfin() == null
						? Calendar.getInstance().getTime() : prmtActual.getVersion().getFfin());

				final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);
				final Map<Long, SubparametroVO> sprmMap = new HashMap<>();
				final Set<Long> spvrIds = new HashSet<>();

				for (final SubparametroVO sprmVO : sprmList) {
					final TipoSubparametroDetailVO tpspDetail = TipoSubparametroProxy.select(sprmVO.getEntiId());

					if (tpspDetail.getEnti().getCmdDuplicado()) {
						sprmMap.put(sprmVO.getVersion().getId(), sprmVO);
						spvrIds.add(sprmVO.getVersion().getId());
					}
				}

				if (!spvrIds.isEmpty()) {
					sprmCriterioVO.setVersionIds(spvrIds);

					final List<ItemDatoVO> spdtList = spdtDAO.selectList(sprmCriterioVO);

					for (final ItemDatoVO itdtVO : spdtList) {
						final SubparametroVO sprmVO = sprmMap.get(itdtVO.getItemId());

						if (sprmVO != null) {
							if (sprmVO.getItdtMap() == null) {
								sprmVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
							}

							sprmVO.getItdtMap().put(itdtVO.getTpdtId(), itdtVO);
						}
					}

					for (final SubparametroVO sprmVO : sprmMap.values()) {
						IgUtilBO.assignNextVal(sprmVO);
						IgUtilBO.assignNextVal(sprmVO.getVersion());

						sprmVO.setPrmtId(prmt.getId());
						sprmVO.getVersion().setFini(prmt.getVersion().getFini());
						sprmVO.getVersion().setFfin(prmt.getVersion().getFfin());

						if (sprmVO.getItdtMap() != null) {
							for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
								itdtVO.setItemId(sprmVO.getVersion().getId());
							}
						}
					}

					for (final SubparametroVO sprmVO : sprmMap.values()) {
						sprmDAO.insert(sprmVO);
					}

					for (final SubparametroVO sprmVO : sprmMap.values()) {
						sprmDAO.insertVersion(sprmVO);
					}

					for (final SubparametroVO sprmVO : sprmMap.values()) {
						if (sprmVO.getItdtMap() != null) {
							for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
								spdtDAO.insert(itdtVO);
							}
						}
					}
				}
			}
		}

		duplicatePostOperations(prmtActual, tpprDetail, i18nMap);
	}

	/**
	 * Duplicate post operations.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	protected void duplicatePostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
			throws OverlapException, InstanceNotFoundException {
		// noop
	}

	/**
	 * Duplicate version.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void duplicateVersion(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
		Preconditions.checkNotNull(prmt.getId());
		Preconditions.checkNotNull(prmt.getVersion());
		Preconditions.checkNotNull(prmt.getVersion().getFini());

		if (tpprDetail.getEnti().isI18n()) {
			Preconditions.checkNotNull(i18nMap);
		}

		// Validar que los datos del parametro son correctos
		if (tpprDetail.getEntdList() != null && !tpprDetail.getEntdList().isEmpty()) {
			for (final Long tpdtId : tpprDetail.getEntdList()) {
				if (!prmt.getItdtMap().containsKey(tpdtId)) {
					final ItemDatoVO itdt = new ItemDatoVO();

					itdt.setTpdtId(tpdtId);
					prmt.getItdtMap().put(tpdtId, itdt);

					// throw new Error("No se ha pasado informacion del dato "
					// + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() +
					// " del parametro: " +
					// prmt);
				}
			}
		}

		// Busqueda del parametro a duplicar
		final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

		prmtCriterio.setVersionId(prmt.getVersion().getId());

		final ParametroVO prmtActual = prmtDAO.selectObject(prmtCriterio);

		if (prmtActual == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prmt, prmt);
		}

		// Cierre de vigencia de la version actual
		prmtActual.getVersion().setFfin(prmt.getVersion().getFini());

		prmtDAO.updateVersion(prmtActual);

		// Alta de la nueva version
		IgUtilBO.assignNextVal(prmt.getVersion());

		if (prmtDAO.existsOverlap(prmt)) {
			throw new OverlapException(MessageI18nKey.prmt, prmt);
		}

		prmtDAO.insertVersion(prmt);

		if (tpprDetail.getEnti().isI18n()) {
			i18nService.insertMap(prmt, i18nMap);
		}

		if (prmt.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
				itdtVO.setItemId(prmt.getVersion().getId());

				prdtDAO.insert(itdtVO);
			}
		}

		duplicateVersionPostOperations(prmtActual, tpprDetail, i18nMap);
	}

	/**
	 * Duplicate version post operations.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	protected void duplicateVersionPostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
			throws OverlapException, InstanceNotFoundException {
		// noop
	}

	/**
	 * Update.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
		Preconditions.checkNotNull(prmt.getVersion());
		Preconditions.checkNotNull(prmt.getVersion().getId());

		if (tpprDetail.getEnti().isI18n()) {
			Preconditions.checkNotNull(i18nMap);
		}

		if (tpprDetail.getEnti().isTempExp()) {
			Preconditions.checkNotNull(prmt.getVersion().getFini());
		}

		// Validar que los datos del parametro son correctos
		if (tpprDetail.getEntdList() != null && !tpprDetail.getEntdList().isEmpty()) {
			for (final Long tpdtId : tpprDetail.getEntdList()) {
				final EntidadTipoDatoVO entd = tpprDetail.getEntdMap().get(tpdtId);

				if (!prmt.getItdtMap().containsKey(entd.getTpdt().getId())) {
					throw new Error("No se ha pasado informacion del dato " + entd.getTpdt().getNombre()
							+ " del parametro: " + prmt);
				}
			}
		}

		if (prmtDAO.existsOverlap(prmt)) {
			throw new OverlapException(MessageI18nKey.prmt, prmt);
		}

		if (prmtDAO.updateVersion(prmt) == 0) {
			throw new InstanceNotFoundException(prmt.getEntiId(), prmt);
		}

		if (tpprDetail.getEnti().isI18n()) {
			i18nService.updateMap(prmt, i18nMap);
		}

		if (prmt.getItdtMap() != null) {
			for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
				itdtVO.setItemId(prmt.getVersion().getId());
				prdtDAO.update(itdtVO);
			}
		}

		updatePostOperations(prmt, tpprDetail, i18nMap);
	}

	/**
	 * Update post operations.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	protected void updatePostOperations(@NonNull final ParametroVO prmt,
			@NonNull final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
			throws OverlapException, InstanceNotFoundException {
		// noop
	}

	/**
	 * Delete.
	 *
	 * @param prmt
	 *            the prmt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final ParametroVO prmt) throws InstanceNotFoundException {
		Preconditions.checkNotNull(prmt.getVersion());
		Preconditions.checkNotNull(prmt.getVersion().getId());

		final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

		prmtCriterio.setVersionId(prmt.getVersion().getId());

		prdtDAO.deleteList(prmtCriterio);

		i18nService.deleteMap(prmt);

		if (prmtDAO.deleteVersion(prmt) == 0) {
			throw new InstanceNotFoundException(prmt.getEntiId(), prmt);
		}

		deletePostOperations(prmt);
	}

	/**
	 * Delete post operations.
	 *
	 * @param prmt
	 *            the prmt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	protected void deletePostOperations(@NonNull final ParametroVO prmt) throws InstanceNotFoundException {
		// noop
	}

	/**
	 * Select list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the list
	 */
	public List<ParametroVO> selectList(@NonNull final ParametroCriterioVO prmtCriterioVO) {
		final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);

		fillDependencies(prmtList, prmtCriterioVO, false);

		return prmtList;
	}

	/**
	 * Select list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ParametroVO> selectList(@NonNull final ParametroCriterioVO prmtCriterioVO, int offset,
			int limit) {
		final List<ParametroVO> prmtList = new ArrayList<>();
		final int count = prmtDAO.count(prmtCriterioVO);

		if (count > offset) {
			prmtList.addAll(prmtDAO.selectList(prmtCriterioVO, new RowBounds(offset, limit)));

			fillDependencies(prmtList, prmtCriterioVO, true);
		}

		return new PaginatedList<>(prmtList, offset, limit, count);
	}

	/**
	 * Select map.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	public Map<Long, ParametroVO> selectMap(@NonNull final ParametroCriterioVO prmtCriterioVO) {
		final Map<Long, ParametroVO> prmtMap = prmtDAO.selectMap(prmtCriterioVO);

		fillDependencies(prmtMap.values(), prmtCriterioVO, false);

		return prmtMap;
	}

	/**
	 * Select map by codigo.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	public Map<String, ParametroVO> selectMapByCodigo(@NonNull final ParametroCriterioVO prmtCriterioVO) {
		final Map<String, ParametroVO> prmtMap = prmtDAO.selectMapByCodigo(prmtCriterioVO);

		fillDependencies(prmtMap.values(), prmtCriterioVO, false);

		return prmtMap;
	}

	/**
	 * Select map codigo id.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	public Map<String, Long> selectMapCodigoId(@NonNull final ParametroCriterioVO prmtCriterioVO) {
		final Map<String, Long> map = new HashMap<>();

		for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
			final StringBuffer code = new StringBuffer();

			if (prmtVO.getPrto() != null) {
				code.append(prmtVO.getPrto().getCodigoCorto());
			}

			code.append(prmtVO.getParametro());

			map.put(code.toString(), prmtVO.getId());
		}

		return map;
	}

	/**
	 * Select map id codigo.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	public Map<Long, String> selectMapIdCodigo(@NonNull final ParametroCriterioVO prmtCriterioVO) {
		final Map<Long, String> map = new HashMap<>();

		for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
			map.put(prmtVO.getId(), prmtVO.getParametro());
		}

		return map;
	}

	/**
	 * Select label values.
	 *
	 * @param tpprIds
	 *            the tppr ids
	 * @param fechaReferencia
	 *            the fecha referencia
	 * @param idioma
	 *            the idioma
	 * @return the map
	 */
	public Map<Long, List<LabelValueVO>> selectLabelValues(@NonNull final Set<Long> tpprIds,
			@NonNull final Date fechaReferencia, final String idioma) {
		final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

		prmtCriterioVO.setEntiIds(tpprIds);
		prmtCriterioVO.setIdioma(idioma);
		prmtCriterioVO.setFechaVigencia(fechaReferencia);

		final Map<Long, List<LabelValueVO>> map = new HashMap<>();

		for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
			if (!map.containsKey(prmtVO.getEntiId())) {
				map.put(prmtVO.getEntiId(), new ArrayList<LabelValueVO>());
			}

			map.get(prmtVO.getEntiId()).add(new LabelValueVO(prmtVO.getEtiqueta(), prmtVO.getId()));
		}

		return map;
	}

	/**
	 * Select label values.
	 *
	 * @param criterioVO
	 *            the criterio VO
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final ParametroCriterioVO criterioVO) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final ParametroVO prmt : prmtDAO.selectList(criterioVO)) {
			list.add(new LabelValueVO(prmt.getEtiqueta(), prmt.getId()));
		}

		return list;
	}

	/**
	 * Select object.
	 *
	 * @param prmtCriterio
	 *            the prmt criterio
	 * @return the parametro VO
	 */
	public ParametroVO selectObject(@NonNull final ParametroCriterioVO prmtCriterio) {
		final ParametroVO prmt = prmtDAO.selectObject(prmtCriterio);

		if (prmt != null) {
			fillDependencies(Arrays.asList(new ParametroVO[] { prmt }), prmtCriterio, true);
		}

		return prmt;
	}

	/**
	 * Select.
	 *
	 * @param prmtId
	 *            the prmt id
	 * @param idioma
	 *            the idioma
	 * @param fechaVigencia
	 *            the fecha vigencia
	 * @return the parametro VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ParametroVO select(@NonNull final Long prmtId, @NonNull final String idioma,
			@NonNull final Date fechaVigencia) throws InstanceNotFoundException {
		final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

		prmtCriterio.setId(prmtId);
		prmtCriterio.setIdioma(idioma);
		prmtCriterio.setFechaVigencia(fechaVigencia);

		final ParametroVO prmt = selectObject(prmtCriterio);

		if (prmt == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prmt, prmtId);
		}

		return prmt;
	}

	/**
	 * Select typeahead list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	public List<ParametroVO> selectTypeaheadList(@NonNull final ParametroCriterioVO criterio, int limit) {
		Preconditions.checkNotNull(criterio.getEntiId());
		Preconditions.checkNotNull(criterio.getFechaVigencia());
		Preconditions.checkNotNull(criterio.getIdioma());

		if (criterio.getTextoBusqueda() == null) {
			criterio.setTextoBusqueda("");
		}

		criterio.setTextoBusqueda(criterio.getTextoBusqueda() + '%');

		return prmtDAO.selectTypeaheadList(criterio, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
	}

	/**
	 * Fill dependencies.
	 *
	 * @param prmtList
	 *            the prmt list
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @param useIds
	 *            the use ids
	 */
	private void fillDependencies(@NonNull final Collection<ParametroVO> prmtList,
			@NonNull final ParametroCriterioVO prmtCriterioVO, final boolean useIds) {
		if (!prmtList.isEmpty()) {
			if (useIds) {
				final Set<Long> prvrIds = new HashSet<>();

				for (final ParametroVO prmtVO : prmtList) {
					prvrIds.add(prmtVO.getVersion().getId());
				}

				prmtCriterioVO.setVersionIds(prvrIds);
			}

			final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

			for (final ItemDatoVO itdtVO : prdtDAO.selectList(prmtCriterioVO)) {
				if (!map.containsKey(itdtVO.getItemId())) {
					map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
				}

				map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

				itdtVO.setItemId(null);
				itdtVO.setTpdtId(null);
			}

			for (final ParametroVO prmtVO : prmtList) {
				prmtVO.setItdtMap(map.get(prmtVO.getVersion().getId()));
			}

			if (useIds) {
				prmtCriterioVO.setVersionIds(null);
			}
		}
	}
}
