package xeredi.argo.model.maestro.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.dao.ParametroDAO;
import xeredi.argo.model.maestro.dao.ParametroDatoDAO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractParametroBO.
 */
public class ParametroBO {

	/**
	 * Instantiates a new parametro bo.
	 */
	protected ParametroBO() {
		super();
	}

	/**
	 * Insert.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i18n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public final void insert(final ParametroVO prmt, final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException {
		Preconditions.checkNotNull(prmt.getParametro());
		Preconditions.checkNotNull(prmt.getVersion());
		Preconditions.checkNotNull(prmt.getVersion().getFini());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
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

			final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
			final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);

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
				I18nUtilBO.insertMap(session, prmt, i18nMap);
			}

			if (prmt.getItdtMap() != null) {
				for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
					itdtVO.setItemId(prmt.getVersion().getId());
					prdtDAO.insert(itdtVO);
				}
			}

			insertPostOperations(session, prmt, tpprDetail, i18nMap);

			session.commit();
		}
	}

	/**
	 * Insert.
	 *
	 * @param session
	 *            the session
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i18n map
	 */
	protected void insertPostOperations(final SqlSession session, final ParametroVO prmt,
			final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap) {
		// noop
	}

	/**
	 * Select list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the list
	 */
	public final List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
			final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);

			fillDependencies(session, prmtList, prmtCriterioVO, false);

			return prmtList;
		}
	}

	/**
	 * Select map by codigo.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the map
	 */
	public final Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
			final Map<String, ParametroVO> prmtMap = prmtDAO.selectMapByCodigo(prmtCriterioVO);

			fillDependencies(session, prmtMap.values(), prmtCriterioVO, false);

			return prmtMap;
		}
	}

	/**
	 * Select map codigo id.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the map
	 */
	public final Map<String, Long> selectMapCodigoId(final ParametroCriterioVO prmtCriterioVO) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
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
	public final Map<Long, List<LabelValueVO>> selectLabelValues(final Set<Long> tpprIds, final Date fechaReferencia,
			final String idioma) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
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
	}

	/**
	 * Select object.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the parametro vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final ParametroVO selectObject(final ParametroCriterioVO prmtCriterioVO) throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
			final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

			if (prmtVO == null) {
				throw new InstanceNotFoundException(MessageI18nKey.prmt, prmtCriterioVO);
			}

			fillDependencies(session, Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

			return prmtVO;
		}
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
	 * @return the parametro vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final ParametroVO select(final Long prmtId, final String idioma, final Date fechaVigencia)
			throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
			final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

			prmtCriterioVO.setId(prmtId);
			prmtCriterioVO.setIdioma(idioma);
			prmtCriterioVO.setFechaVigencia(fechaVigencia);

			final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

			if (prmtVO == null) {
				throw new InstanceNotFoundException(MessageI18nKey.prmt, prmtId);
			}

			fillDependencies(session, Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

			return prmtVO;
		}
	}

	/**
	 * Rellenado de los datos asociados a una lista de parametros. Búsqueda en
	 * parámetro dato.
	 *
	 * @param session
	 *            the session
	 * @param prmtList
	 *            Colleccion de parámetros de los que se desea obtener sus datos
	 *            asociados.
	 * @param prmtCriterioVO
	 *            Criterio de búsqueda de parámetros. Este criterio ha sido el
	 *            utilizado para obtener la coleccion de parámetros pasada como
	 *            argumento.
	 * @param useIds
	 *            the use ids
	 */
	private void fillDependencies(final SqlSession session, final Collection<ParametroVO> prmtList,
			final ParametroCriterioVO prmtCriterioVO, final boolean useIds) {
		final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);

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
