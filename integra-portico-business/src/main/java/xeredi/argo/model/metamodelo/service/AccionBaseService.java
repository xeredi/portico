package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;

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
import xeredi.argo.model.metamodelo.dao.AccionBaseDAO;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class AccionBaseService {

	/** The acbs DAO. */
	@Inject
	private AccionBaseDAO acbsDAO;

	/** The fncd DAO. */
	@Inject
	private FuncionalidadDAO fncdDAO;

	/** The fngr DAO. */
	@Inject
	private FuncionalidadGrupoDAO fngrDAO;

	/**
	 * Insert.
	 *
	 * @param acbs
	 *            the acbs
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final AccionBaseVO acbs) throws DuplicateInstanceException {
		if (acbsDAO.exists(acbs)) {
			throw new DuplicateInstanceException(MessageI18nKey.acbs, acbs);
		}

		IgUtilBO.assignNextVal(acbs);
		fncdDAO.insert(acbs);
		acbsDAO.insert(acbs);
	}

	/**
	 * Update.
	 *
	 * @param acbs
	 *            the acbs
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final AccionBaseVO acbs) throws InstanceNotFoundException {
		Preconditions.checkNotNull(acbs.getId());

		if (acbsDAO.update(acbs) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.acbs, acbs);
		}
	}

	/**
	 * Delete.
	 *
	 * @param acbs
	 *            the acbs
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final AccionBaseVO acbs) throws InstanceNotFoundException {
		Preconditions.checkNotNull(acbs.getId());

		if (acbsDAO.delete(acbs) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.acbs, acbs);
		}

		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setFncdId(acbs.getId());

		fngrDAO.deleteList(fngrCriterio);
		fncdDAO.delete(acbs);
	}

	/**
	 * Select list.
	 *
	 * @param acbsCriterio
	 *            the acbs criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<AccionBaseVO> selectList(@NonNull final AccionBaseCriterioVO acbsCriterio, int offset,
			int limit) {
		final int count = acbsDAO.count(acbsCriterio);

		return new PaginatedList<AccionBaseVO>(
				(count > offset) ? acbsDAO.selectList(acbsCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param acbsCriterio
	 *            the acbs criterio
	 * @return the list
	 */
	public List<AccionBaseVO> selectList(@NonNull final AccionBaseCriterioVO acbsCriterio) {
		return acbsDAO.selectList(acbsCriterio);
	}

	/**
	 * Select object.
	 *
	 * @param acbsCriterio
	 *            the acbs criterio
	 * @return the accion base VO
	 */
	public AccionBaseVO selectObject(@NonNull final AccionBaseCriterioVO acbsCriterio) {
		return acbsDAO.selectObject(acbsCriterio);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the accion base VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public AccionBaseVO select(@NonNull final Long id) throws InstanceNotFoundException {
		final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

		acbsCriterio.setId(id);

		final AccionBaseVO acbs = acbsDAO.selectObject(acbsCriterio);

		if (acbs == null) {
			throw new InstanceNotFoundException(MessageI18nKey.acbs, id);
		}

		return acbs;
	}
}
