package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.AccionEspecialDAO;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialBO.
 */
public final class AccionEspecialBO {

	/**
	 * Checks if is user allowed.
	 *
	 * @param acesId
	 *            the aces id
	 * @param usroId
	 *            the usro id
	 * @return true, if is user allowed
	 */
	public boolean isUserAllowed(final @NonNull Long acesId, final @NonNull Long usroId) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);
			final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

			acesCriterio.setId(acesId);
			acesCriterio.setUsroId(usroId);

			return acesDAO.count(acesCriterio) > 0;
		}
	}

	/**
	 * Insert.
	 *
	 * @param aces
	 *            the aces
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(final @NonNull AccionEspecialVO aces, final Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);
			final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
			final IgBO igBO = new IgBO();

			if (acesDAO.exists(aces)) {
				throw new DuplicateInstanceException(MessageI18nKey.aces, aces);
			}

			aces.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

			fncdDAO.insert(aces);
			acesDAO.insert(aces);

            I18nBO.insertMap(session, I18nPrefix.aces, aces.getId(), i18nMap);

			session.commit();
		}
	}

	/**
	 * Update.
	 *
	 * @param aces
	 *            the aces
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(final @NonNull AccionEspecialVO aces, final Map<String, I18nVO> i18nMap) throws InstanceNotFoundException {
		Preconditions.checkNotNull(aces.getId());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);

			if (acesDAO.update(aces) == 0) {
				throw new InstanceNotFoundException(MessageI18nKey.aces, aces);
			}

            I18nBO.updateMap(session, I18nPrefix.aces, aces.getId(), i18nMap);

			session.commit();
		}
	}

	/**
	 * Delete.
	 *
	 * @param aces
	 *            the aces
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(final @NonNull AccionEspecialVO aces) throws InstanceNotFoundException {
		Preconditions.checkNotNull(aces.getId());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);
			final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
			final FuncionalidadGrupoDAO fngrDAO = session.getMapper(FuncionalidadGrupoDAO.class);

			final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

			fngrCriterio.setFncdId(aces.getId());

			if (acesDAO.delete(aces) == 0) {
				throw new InstanceNotFoundException(MessageI18nKey.aces, aces);
			}


            I18nBO.deleteMap(session, I18nPrefix.aces, aces.getId());

			fngrDAO.deleteList(fngrCriterio);
			fncdDAO.delete(aces);

			session.commit();
		}
	}

	/**
	 * Select list.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<AccionEspecialVO> selectList(final @NonNull AccionEspecialCriterioVO acesCriterio,
			final int offset, final int limit) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);
			final int count = acesDAO.count(acesCriterio);

			final List<AccionEspecialVO> acesList = (count > offset)
					? acesDAO.selectList(acesCriterio, new RowBounds(offset, limit)) : new ArrayList<>();

			return new PaginatedList<AccionEspecialVO>(acesList, offset, limit, count);
		}
	}

	/**
	 * Select list.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the list
	 */
	public List<AccionEspecialVO> selectList(final @NonNull AccionEspecialCriterioVO acesCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);

			return acesDAO.selectList(acesCriterio);
		}
	}

	/**
	 * Select object.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the accion especial VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public AccionEspecialVO selectObject(final @NonNull AccionEspecialCriterioVO acesCriterio)
			throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);
			final AccionEspecialVO aces = acesDAO.selectObject(acesCriterio);

			if (aces == null) {
				throw new InstanceNotFoundException(MessageI18nKey.aces, acesCriterio);
			}

			return aces;
		}
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the accion especial VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public AccionEspecialVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);
			final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

			acesCriterio.setId(id);
			acesCriterio.setIdioma(idioma);

			final AccionEspecialVO aces = acesDAO.selectObject(acesCriterio);

			if (aces == null) {
				throw new InstanceNotFoundException(MessageI18nKey.aces, acesCriterio);
			}

			return aces;
		}
	}

}
