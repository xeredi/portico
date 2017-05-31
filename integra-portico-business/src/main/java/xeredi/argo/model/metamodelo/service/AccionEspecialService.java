package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.AccionEspecialDAO;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
@Singleton
public class AccionEspecialService {

	/** The aces DAO. */
	@Inject
	private AccionEspecialDAO acesDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/** The fncd DAO. */
	@Inject
	private FuncionalidadDAO fncdDAO;

	/** The fngr DAO. */
	@Inject
	private FuncionalidadGrupoDAO fngrDAO;

	/**
	 * Insert.
	 *
	 * @param aces
	 *            the aces
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final AccionEspecialVO aces, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (acesDAO.exists(aces)) {
			throw new DuplicateInstanceException(MessageI18nKey.aces, aces);
		}

		IgUtilBO.assignNextVal(aces);

		fncdDAO.insert(aces);
		acesDAO.insert(aces);

		I18nUtil.insertMap(i18nDAO, aces, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param aces
	 *            the aces
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final AccionEspecialVO aces, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(aces.getId());

		if (acesDAO.update(aces) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.aces, aces);
		}

		I18nUtil.updateMap(i18nDAO, aces, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param aces
	 *            the aces
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final AccionEspecialVO aces) throws InstanceNotFoundException {
		Preconditions.checkNotNull(aces.getId());

		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setFncdId(aces.getId());

		if (acesDAO.delete(aces) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.aces, aces);
		}

		I18nUtil.deleteMap(i18nDAO, aces);

		fngrDAO.deleteList(fngrCriterio);
		fncdDAO.delete(aces);
	}

	/**
	 * Select list.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the list
	 */
	public List<AccionEspecialVO> selectList(@NonNull final AccionEspecialCriterioVO acesCriterio) {
		return acesDAO.selectList(acesCriterio);
	}

	/**
	 * Select object.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the accion especial VO
	 */
	public AccionEspecialVO selectObject(@NonNull final AccionEspecialCriterioVO acesCriterio) {
		return acesDAO.selectObject(acesCriterio);
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
	public AccionEspecialVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

		acesCriterio.setId(id);
		acesCriterio.setIdioma(idioma);

		final AccionEspecialVO aces = selectObject(acesCriterio);

		if (aces == null) {
			throw new InstanceNotFoundException(MessageI18nKey.aces, id);
		}

		return aces;
	}

}
