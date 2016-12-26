package xeredi.argo.model.comun.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.SuperpuertoDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
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
}
