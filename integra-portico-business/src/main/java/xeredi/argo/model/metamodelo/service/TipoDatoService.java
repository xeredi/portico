package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.Arrays;
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
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.dao.TipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class TipoDatoService {

	/** The tpdt DAO. */
	private TipoDatoDAO tpdtDAO;

	/** The cdrf DAO. */
	private CodigoReferenciaDAO cdrfDAO;

	/** The i 18 n DAO. */
	private I18nService i18nService;

	/**
	 * Instantiates a new tipo dato service.
	 *
	 * @param tpdtDAO
	 *            the tpdt DAO
	 * @param cdrfDAO
	 *            the cdrf DAO
	 * @param i18nService
	 *            the i 18 n service
	 */
	@Inject
	public TipoDatoService(final TipoDatoDAO tpdtDAO, final CodigoReferenciaDAO cdrfDAO,
			final I18nService i18nService) {
		super();
		this.tpdtDAO = tpdtDAO;
		this.cdrfDAO = cdrfDAO;
		this.i18nService = i18nService;
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo dato VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

		tpdtCriterio.setId(id);
		tpdtCriterio.setIdioma(idioma);

		final TipoDatoVO tpdt = tpdtDAO.selectObject(tpdtCriterio);

		if (tpdt == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpdt, id);
		}

		fillDependencies(Arrays.asList(new TipoDatoVO[] { tpdt }));

		return tpdt;
	}

	/**
	 * Insert.
	 *
	 * @param tpdt
	 *            the tpdt
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (tpdtDAO.exists(tpdt)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpdt, tpdt);
		}

		IgUtilBO.assignNextVal(tpdt);
		tpdtDAO.insert(tpdt);

		i18nService.insertMap(tpdt, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param tpdt
	 *            the tpdt
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpdt.getId());

		if (tpdtDAO.update(tpdt) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdt.getCodigo());
		}

		i18nService.updateMap(tpdt, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param tpdt
	 *            the tpdt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TipoDatoVO tpdt) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpdt.getId());

		i18nService.deleteMap(tpdt);

		final CodigoReferenciaCriterioVO cdrfCriterio = new CodigoReferenciaCriterioVO();

		cdrfCriterio.setTpdtId(tpdt.getId());

		cdrfDAO.deleteList(cdrfCriterio);

		if (tpdtDAO.delete(tpdt) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdt);
		}
	}

	/**
	 * Select list.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the list
	 */
	public List<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		final List<TipoDatoVO> list = tpdtDAO.selectList(tpdtCriterio);

		fillDependencies(list);

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio, int offset, int limit) {
		final int count = tpdtDAO.count(tpdtCriterio);

		if (count > offset) {
			final List<TipoDatoVO> list = tpdtDAO.selectList(tpdtCriterio, new RowBounds(offset, limit));

			fillDependencies(list);

			return new PaginatedList<>(list, offset, limit, count);
		}

		return new PaginatedList<>(new ArrayList<>(), offset, limit, count);
	}

	/**
	 * Select map.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the map
	 */
	public Map<Long, TipoDatoVO> selectMap(TipoDatoCriterioVO tpdtCriterio) {
		final Map<Long, TipoDatoVO> tpdtMap = new HashMap<>();

		for (final TipoDatoVO tpdt : selectList(tpdtCriterio)) {
			tpdtMap.put(tpdt.getId(), tpdt);
		}

		return tpdtMap;
	}

	/**
	 * Select label values.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoDatoVO tpdt : selectList(tpdtCriterio)) {
			list.add(new LabelValueVO(tpdt.getNombre(), tpdt.getId()));
		}

		return list;
	}

	/**
	 * Fill dependencies.
	 *
	 * @param list
	 *            the list
	 */
	private void fillDependencies(final @NonNull List<TipoDatoVO> list) {
		final Set<Long> tpdtIds = new HashSet<>();
		final Map<Long, List<CodigoReferenciaVO>> cdrfMap = new HashMap<>();

		for (final TipoDatoVO tpdt : list) {
			if (tpdt.getTipoElemento() == TipoElemento.CR) {
				tpdtIds.add(tpdt.getId());
				cdrfMap.put(tpdt.getId(), new ArrayList<CodigoReferenciaVO>());

				tpdt.setCdrfList(new ArrayList<>());
				tpdt.setCdrfCodeSet(new HashSet<>());
			}
		}

		if (!tpdtIds.isEmpty()) {
			final CodigoReferenciaCriterioVO cdfrCriterio = new CodigoReferenciaCriterioVO();

			cdfrCriterio.setTpdtIds(tpdtIds);

			for (final CodigoReferenciaVO cdrf : cdrfDAO.selectList(cdfrCriterio)) {
				cdrfMap.get(cdrf.getTpdtId()).add(cdrf);
			}

			for (final TipoDatoVO tpdt : list) {
				if (cdrfMap.containsKey(tpdt.getId())) {
					tpdt.setCdrfList(cdrfMap.get(tpdt.getId()));

					for (final CodigoReferenciaVO cdrf : cdrfMap.get(tpdt.getId())) {
						tpdt.getCdrfCodeSet().add(cdrf.getTexto());
					}
				}
			}
		}
	}
}
