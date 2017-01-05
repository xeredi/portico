package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

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
@Singleton
@Transactional
public class AccionEspecialServiceImpl implements AccionEspecialService {

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
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final AccionEspecialVO aces, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(aces.getId());

		if (acesDAO.update(aces) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.aces, aces);
		}

		I18nUtil.updateMap(i18nDAO, aces, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public List<AccionEspecialVO> selectList(@NonNull final AccionEspecialCriterioVO acesCriterio) {
		return acesDAO.selectList(acesCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccionEspecialVO selectObject(@NonNull final AccionEspecialCriterioVO acesCriterio) {
		return acesDAO.selectObject(acesCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
