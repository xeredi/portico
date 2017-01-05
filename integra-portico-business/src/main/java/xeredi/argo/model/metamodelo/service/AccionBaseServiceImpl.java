package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

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
@Singleton
@Transactional
public class AccionBaseServiceImpl implements AccionBaseService {

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
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final AccionBaseVO acbs) throws DuplicateInstanceException {
		if (acbsDAO.exists(acbs)) {
			throw new DuplicateInstanceException(MessageI18nKey.acbs, acbs);
		}

		IgUtilBO.assignNextVal(acbs);
		fncdDAO.insert(acbs);
		acbsDAO.insert(acbs);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final AccionBaseVO acbs) throws InstanceNotFoundException {
		Preconditions.checkNotNull(acbs.getId());

		if (acbsDAO.update(acbs) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.acbs, acbs);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<AccionBaseVO> selectList(@NonNull final AccionBaseCriterioVO acbsCriterio, int offset,
			int limit) {
		final int count = acbsDAO.count(acbsCriterio);

		return new PaginatedList<AccionBaseVO>(
				(count > offset) ? acbsDAO.selectList(acbsCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AccionBaseVO> selectList(@NonNull final AccionBaseCriterioVO acbsCriterio) {
		return acbsDAO.selectList(acbsCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccionBaseVO selectObject(@NonNull final AccionBaseCriterioVO acbsCriterio) {
		return acbsDAO.selectObject(acbsCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
