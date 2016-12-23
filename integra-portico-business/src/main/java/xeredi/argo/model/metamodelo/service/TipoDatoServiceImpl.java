package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
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
@Transactional
@Singleton
public class TipoDatoServiceImpl implements TipoDatoService {

	/** The tpdt DAO. */
	@Inject
	private TipoDatoDAO tpdtDAO;

	@Inject
	private CodigoReferenciaDAO cdrfDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

		tpdtCriterio.setId(id);
		tpdtCriterio.setIdioma(idioma);

		final TipoDatoVO tpdt = tpdtDAO.selectObject(tpdtCriterio);

		if (tpdt == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpdt, id);
		}

		// Si el tipo de dato es un codigo de referencia, se buscan los
		// valores posibles
		if (tpdt.getTipoElemento() == TipoElemento.CR) {
			final CodigoReferenciaCriterioVO cdrfCriterio = new CodigoReferenciaCriterioVO();

			cdrfCriterio.setIdioma(idioma);
			cdrfCriterio.setTpdtIds(new HashSet<>(Arrays.asList(new Long[] { tpdt.getId() })));

			tpdt.setCdrfList(cdrfDAO.selectList(cdrfCriterio));

			final Set<String> cdrfCodeSet = new HashSet<>();

			for (final CodigoReferenciaVO cdrf : tpdt.getCdrfList()) {
				cdrfCodeSet.add(cdrf.getValor());
			}

			tpdt.setCdrfCodeSet(cdrfCodeSet);
		}

		return tpdt;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (tpdtDAO.exists(tpdt)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpdt, tpdt);
		}

		IgUtilBO.assignNextVal(tpdt);
		tpdtDAO.insert(tpdt);

		I18nUtil.insertMap(i18nDAO, tpdt, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpdt.getId());

		if (tpdtDAO.update(tpdt) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdt.getCodigo());
		}

		I18nUtil.updateMap(i18nDAO, tpdt, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final TipoDatoVO tpdt) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpdt.getId());

		I18nUtil.deleteMap(i18nDAO, tpdt);

		final CodigoReferenciaCriterioVO cdrfCriterio = new CodigoReferenciaCriterioVO();

		cdrfCriterio.setTpdtId(tpdt.getId());

		cdrfDAO.deleteList(cdrfCriterio);

		if (tpdtDAO.delete(tpdt) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpdt, tpdt);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		return tpdtDAO.selectList(tpdtCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio, int offset, int limit) {
		final int count = tpdtDAO.count(tpdtCriterio);

		return new PaginatedList<>(
				count > offset ? tpdtDAO.selectList(tpdtCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LabelValueVO> selectLabelValues(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoDatoVO tpdt : selectList(tpdtCriterio)) {
			list.add(new LabelValueVO(tpdt.getNombre(), tpdt.getId()));
		}

		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Long, TipoDatoVO> selectMap(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		final Map<Long, TipoDatoVO> tpdtMap = tpdtDAO.selectMap(tpdtCriterio);
		final Map<Long, List<CodigoReferenciaVO>> cdrfMap = new HashMap<>();

		for (final CodigoReferenciaVO cdrf : cdrfDAO.selectList(new CodigoReferenciaCriterioVO())) {
			if (!cdrfMap.containsKey(cdrf.getTpdtId())) {
				cdrfMap.put(cdrf.getTpdtId(), new ArrayList<CodigoReferenciaVO>());
			}

			cdrfMap.get(cdrf.getTpdtId()).add(cdrf);

			cdrf.setTpdtId(null);
			cdrf.setOrden(null);
		}

		for (final TipoDatoVO tpdt : tpdtMap.values()) {
			if (cdrfMap.containsKey(tpdt.getId())) {
				tpdt.setCdrfList(cdrfMap.get(tpdt.getId()));

				final Set<String> cdrfCodeSet = new HashSet<>();

				for (final CodigoReferenciaVO cdrf : cdrfMap.get(tpdt.getId())) {
					cdrfCodeSet.add(cdrf.getValor());
				}

				tpdt.setCdrfCodeSet(cdrfCodeSet);
			}

			tpdtMap.put(tpdt.getId(), tpdt);
		}

		return tpdtMap;
	}
}
