package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoParametroDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class TipoParametroServiceImpl implements TipoParametroService {

	/** The tppr DAO. */
	@Inject
	private TipoParametroDAO tpprDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LabelValueVO> selectLabelValues() {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoParametroVO tppr : selectList(new TipoParametroCriterioVO())) {
			list.add(new LabelValueVO(tppr.getNombre(), tppr.getId()));
		}

		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO) {
		return tpprDAO.selectList(tpprCriterioVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO, int offset,
			int limit) {
		final int count = tpprDAO.count(tpprCriterioVO);

		return new PaginatedList<>(
				count > offset ? tpprDAO.selectList(tpprCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoParametroVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final TipoParametroCriterioVO entiCriterio = new TipoParametroCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoParametroVO enti = tpprDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tppr, id);
		}

		return enti;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (entiDAO.exists(tppr)) {
			throw new DuplicateInstanceException(MessageI18nKey.tppr, tppr);
		}

		IgUtilBO.assignNextVal(tppr);
		tppr.setTipo(TipoEntidad.P);

		entiDAO.insert(tppr);
		tpprDAO.insert(tppr);

		I18nUtil.insertMap(i18nDAO, tppr, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(tppr.getId());

		if (tpprDAO.update(tppr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tppr, tppr);
		}

		entiDAO.update(tppr);
		I18nUtil.updateMap(i18nDAO, tppr, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final TipoParametroVO tppr) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tppr.getId());

		if (tpprDAO.delete(tppr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tppr, tppr);
		}

		I18nUtil.deleteMap(i18nDAO, tppr);
		entiDAO.delete(tppr);
	}
}
