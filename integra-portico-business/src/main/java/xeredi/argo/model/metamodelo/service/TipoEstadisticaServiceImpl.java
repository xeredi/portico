package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoEstadisticaDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaServiceImpl.
 */
@Singleton
@Transactional
public class TipoEstadisticaServiceImpl implements TipoEstadisticaService {

	/** The tpes DAO. */
	@Inject
	private TipoEstadisticaDAO tpesDAO;

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

		for (final TipoEstadisticaVO tpes : selectList(new TipoEstadisticaCriterioVO())) {
			list.add(new LabelValueVO(tpes.getNombre(), tpes.getId()));
		}

		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio) {
		return tpesDAO.selectList(tpesCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio,
			int offset, int limit) {
		final int count = tpesDAO.count(tpesCriterio);

		return new PaginatedList<>(
				count > offset ? tpesDAO.selectList(tpesCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoEstadisticaVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final TipoEstadisticaCriterioVO entiCriterio = new TipoEstadisticaCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoEstadisticaVO enti = tpesDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpes, id);
		}

		return enti;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (entiDAO.exists(tpes)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpes, tpes);
		}

		IgUtilBO.assignNextVal(tpes);
		tpes.setTipo(TipoEntidad.E);

		entiDAO.insert(tpes);
		tpesDAO.insert(tpes);

		I18nUtil.insertMap(i18nDAO, tpes, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpes.getId());

		if (entiDAO.update(tpes) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpes, tpes);
		}

		I18nUtil.updateMap(i18nDAO, tpes, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final TipoEstadisticaVO tpes) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpes.getId());

		if (tpesDAO.delete(tpes) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpes, tpes);
		}

		I18nUtil.deleteMap(i18nDAO, tpes);

		entiDAO.delete(tpes);
	}

}
