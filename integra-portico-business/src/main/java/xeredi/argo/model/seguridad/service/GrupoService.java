package xeredi.argo.model.seguridad.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.dao.GrupoDAO;
import xeredi.argo.model.seguridad.dao.UsuarioGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class GrupoService {

	/** The grpo DAO. */
	@Inject
	private GrupoDAO grpoDAO;

	/** The fngr DAO. */
	@Inject
	private FuncionalidadGrupoDAO fngrDAO;

	/** The usgr DAO. */
	@Inject
	private UsuarioGrupoDAO usgrDAO;

	/**
	 * Insert.
	 *
	 * @param grpo
	 *            the grpo
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final GrupoVO grpo) throws DuplicateInstanceException {
		if (grpoDAO.exists(grpo)) {
			throw new DuplicateInstanceException(MessageI18nKey.grpo, grpo);
		}

		IgUtilBO.assignNextVal(grpo);
		grpoDAO.insert(grpo);

		// Permisos del grupo
		if (grpo.getFncdIds() != null) {
			for (final Long fncdId : grpo.getFncdIds()) {
				final FuncionalidadGrupoVO fngr = new FuncionalidadGrupoVO();

				fngr.setFncdId(fncdId);
				fngr.setGrpoId(grpo.getId());

				fngrDAO.insert(fngr);
			}
		}
	}

	/**
	 * Update.
	 *
	 * @param grpo
	 *            the grpo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final GrupoVO grpo) throws InstanceNotFoundException {
		Preconditions.checkNotNull(grpo.getId());

		if (grpoDAO.update(grpo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.grpo, grpo);
		}

		// Permisos: Se borran los de la BD y se sustituyen por los que
		// vengan en el grupo
		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setGrpoId(grpo.getId());

		fngrDAO.deleteList(fngrCriterio);

		if (grpo.getFncdIds() != null) {
			for (final Long fncdId : grpo.getFncdIds()) {
				final FuncionalidadGrupoVO fngr = new FuncionalidadGrupoVO();

				fngr.setFncdId(fncdId);
				fngr.setGrpoId(grpo.getId());

				fngrDAO.insert(fngr);
			}
		}
	}

	/**
	 * Delete.
	 *
	 * @param grpo
	 *            the grpo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final GrupoVO grpo) throws InstanceNotFoundException {
		Preconditions.checkNotNull(grpo.getId());

		// Borrado de las asociaciones con permisos
		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setGrpoId(grpo.getId());

		fngrDAO.deleteList(fngrCriterio);

		// Borrado de las asociaciones con usuarios
		final UsuarioGrupoCriterioVO usgrCriterio = new UsuarioGrupoCriterioVO();

		usgrCriterio.setGrpoId(grpo.getId());

		usgrDAO.deleteList(usgrCriterio);

		if (grpoDAO.delete(grpo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.grpo, grpo);
		}
	}

	/**
	 * Select list.
	 *
	 * @param grpoCriterio
	 *            the grpo criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<GrupoVO> selectList(@NonNull final GrupoCriterioVO grpoCriterio, int offset, int limit) {
		final int count = grpoDAO.count(grpoCriterio);

		return new PaginatedList<>(
				count > offset ? grpoDAO.selectList(grpoCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param grpoCriterio
	 *            the grpo criterio
	 * @return the list
	 */
	public List<GrupoVO> selectList(@NonNull final GrupoCriterioVO grpoCriterio) {
		return grpoDAO.selectList(grpoCriterio);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the grupo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public GrupoVO select(@NonNull final Long id) throws InstanceNotFoundException {
		final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

		grpoCriterio.setId(id);

		final GrupoVO grpo = grpoDAO.selectObject(grpoCriterio);

		if (grpo == null) {
			throw new InstanceNotFoundException(MessageI18nKey.grpo, id);
		}

		final Set<Long> fncdIds = new HashSet<>();
		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setGrpoId(id);

		for (final FuncionalidadGrupoVO fncd : fngrDAO.selectList(fngrCriterio)) {
			fncdIds.add(fncd.getFncdId());
		}

		grpo.setFncdIds(fncdIds);

		return grpo;
	}
}
