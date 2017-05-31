/**
 *
 */
package xeredi.argo.model.metamodelo.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

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
@Transactional(executorType = ExecutorType.REUSE)
@Singleton
public class AccionEntidadService {

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
	 * Insert.
	 *
	 * @param acen
	 *            the acen
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final AccionEntidadVO acen) throws DuplicateInstanceException {
		if (acenDAO.exists(acen)) {
			throw new DuplicateInstanceException(MessageI18nKey.acen, acen);
		}

		IgUtilBO.assignNextVal(acen);
		fncdDAO.insert(acen);
		acenDAO.insert(acen);
	}

	/**
	 * Update.
	 *
	 * @param acen
	 *            the acen
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final AccionEntidadVO acen) throws InstanceNotFoundException {
		Preconditions.checkNotNull(acen.getId());

		if (acenDAO.update(acen) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.acen, acen);
		}
	}

	/**
	 * Delete.
	 *
	 * @param acen
	 *            the acen
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
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
	 * Select list.
	 *
	 * @param acenCriterio
	 *            the acen criterio
	 * @return the list
	 */
	public List<AccionEntidadVO> selectList(@NonNull final AccionEntidadCriterioVO acenCriterio) {
		return acenDAO.selectList(acenCriterio);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the accion entidad VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
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
	 * Select object.
	 *
	 * @param acenCriterio
	 *            the acen criterio
	 * @return the accion entidad VO
	 */
	public AccionEntidadVO selectObject(@NonNull final AccionEntidadCriterioVO acenCriterio) {
		return acenDAO.selectObject(acenCriterio);
	}

}
