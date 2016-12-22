package xeredi.argo.model.comun.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.SuperpuertoDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.util.PaginatedList;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoBO.
 */
public final class SuperpuertoBO {

	/**
	 * Select object.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the superpuerto vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public SuperpuertoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

		sprtCriterio.setId(id);
		sprtCriterio.setIdioma(idioma);

		return selectObject(sprtCriterio);
	}

	/**
	 * Select object.
	 *
	 * @param sprtCriterio
	 *            the sprt criterio
	 * @return the superpuerto vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public SuperpuertoVO selectObject(@NonNull final SuperpuertoCriterioVO sprtCriterio)
			throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);
			final SuperpuertoVO sprt = sprtDAO.selectObject(sprtCriterio);

			if (sprt == null) {
				throw new InstanceNotFoundException(MessageI18nKey.sprt, sprtCriterio);
			}

			return sprt;
		}
	}

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<SuperpuertoVO> selectList(@NonNull final SuperpuertoCriterioVO criterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

			return sprtDAO.selectList(criterio);
		}
	}

	/**
	 * Select list.
	 *
	 * <img src="doc-files/SuperpuertoBO_selectList.png" alt="Sequence Diagram">
	 *
	 * @param criterio
	 *            the criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<SuperpuertoVO> selectList(@NonNull final SuperpuertoCriterioVO criterio, final int offset,
			final int limit) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);
			final int count = sprtDAO.count(criterio);

			return new PaginatedList<SuperpuertoVO>(
					count >= offset ? sprtDAO.selectList(criterio, new RowBounds(offset, limit)) : new ArrayList<>(),
					offset, limit, count);
		}
	}

	/**
	 * Insert.
	 *
	 * @param sprt
	 *            the sprt
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final SuperpuertoVO sprt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		Preconditions.checkNotNull(sprt.getCodigo());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

			if (sprtDAO.exists(sprt)) {
				throw new DuplicateInstanceException(MessageI18nKey.sprt, sprt);
			}

			IgUtilBO.assignNextVal(sprt);
			sprtDAO.insert(sprt);
			I18nUtilBO.insertMap(session, sprt, i18nMap);

			session.commit();
		}
	}

	/**
	 * Update.
	 *
	 * @param sprt
	 *            the sprt
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final SuperpuertoVO sprt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(sprt.getId());
		Preconditions.checkNotNull(sprt.getCodigo());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

			if (!sprtDAO.exists(sprt)) {
				throw new InstanceNotFoundException(MessageI18nKey.sprt, sprt);
			}

			I18nUtilBO.updateMap(session, sprt, i18nMap);

			session.commit();
		}
	}

	/**
	 * Delete.
	 *
	 * @param sprt
	 *            the sprt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final SuperpuertoVO sprt) throws InstanceNotFoundException {
		Preconditions.checkNotNull(sprt.getId());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

			if (sprtDAO.delete(sprt) == 0) {
				throw new InstanceNotFoundException(MessageI18nKey.sprt, sprt);
			}

			I18nUtilBO.deleteMap(session, sprt);

			session.commit();
		}
	}
}
