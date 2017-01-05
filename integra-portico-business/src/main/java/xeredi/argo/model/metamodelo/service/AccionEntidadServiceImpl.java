/**
 *
 */
package xeredi.argo.model.metamodelo.service;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.AccionEntidadDAO;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadServiceImpl.
 */
@Singleton
@Transactional
public class AccionEntidadServiceImpl implements AccionEntidadService {

	/** The acen DAO. */
	@Inject
	private AccionEntidadDAO acenDAO;

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
	public void insert(@NonNull final AccionEntidadVO acen) throws DuplicateInstanceException {
		if (acenDAO.exists(acen)) {
			throw new DuplicateInstanceException(MessageI18nKey.acen, acen);
		}

		IgUtilBO.assignNextVal(acen);
		fncdDAO.insert(acen);
		acenDAO.insert(acen);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final AccionEntidadVO acen) throws InstanceNotFoundException {
		Preconditions.checkNotNull(acen.getId());

		if (acenDAO.update(acen) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.acen, acen);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final AccionEntidadVO acen) throws InstanceNotFoundException {
		Preconditions.checkNotNull(acen.getId());

		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setFncdId(acen.getId());

		if (acenDAO.delete(acen) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.acen, acen);
		}

		fngrDAO.deleteList(fngrCriterio);
		fncdDAO.delete(acen);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AccionEntidadVO> selectList(@NonNull final AccionEntidadCriterioVO acenCriterio) {
		return acenDAO.selectList(acenCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccionEntidadVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

		acenCriterio.setId(id);
		acenCriterio.setIdioma(idioma);

		final AccionEntidadVO acen = selectObject(acenCriterio);

		if (acen == null) {
			throw new InstanceNotFoundException(MessageI18nKey.acen, id);
		}

		return acen;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccionEntidadVO selectObject(@NonNull final AccionEntidadCriterioVO acenCriterio) {
		return acenDAO.selectObject(acenCriterio);
	}

}
