package xeredi.argo.model.comun.service;

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
import xeredi.argo.model.comun.dao.SuperpuertoDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class SuperpuertoServiceImpl implements SuperpuertoService {

	/** The sprt DAO. */
	@Inject
	private SuperpuertoDAO sprtDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SuperpuertoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

		sprtCriterio.setId(id);
		sprtCriterio.setIdioma(idioma);

		final SuperpuertoVO sprt = selectObject(sprtCriterio);

		if (sprt == null) {
			throw new InstanceNotFoundException(MessageI18nKey.sprt, id);
		}

		return sprt;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SuperpuertoVO selectObject(@NonNull final SuperpuertoCriterioVO sprtCriterio) {
		return sprtDAO.selectObject(sprtCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<SuperpuertoVO> selectList(@NonNull final SuperpuertoCriterioVO criterio) {
		return sprtDAO.selectList(criterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<SuperpuertoVO> selectList(@NonNull final SuperpuertoCriterioVO criterio, int offset,
			int limit) {
		final int count = sprtDAO.count(criterio);

		return new PaginatedList<SuperpuertoVO>(
				count >= offset ? sprtDAO.selectList(criterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final SuperpuertoVO sprt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		Preconditions.checkNotNull(sprt.getCodigo());

		if (sprtDAO.exists(sprt)) {
			throw new DuplicateInstanceException(MessageI18nKey.sprt, sprt);
		}

		IgUtilBO.assignNextVal(sprt);
		sprtDAO.insert(sprt);
		I18nUtil.insertMap(i18nDAO, sprt, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final SuperpuertoVO sprt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(sprt.getId());
		Preconditions.checkNotNull(sprt.getCodigo());

		if (!sprtDAO.exists(sprt)) {
			throw new InstanceNotFoundException(MessageI18nKey.sprt, sprt);
		}

		I18nUtil.updateMap(i18nDAO, sprt, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final SuperpuertoVO sprt) throws InstanceNotFoundException {
		Preconditions.checkNotNull(sprt.getId());

		if (sprtDAO.delete(sprt) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.sprt, sprt);
		}

		I18nUtil.deleteMap(i18nDAO, sprt);
	}
}
