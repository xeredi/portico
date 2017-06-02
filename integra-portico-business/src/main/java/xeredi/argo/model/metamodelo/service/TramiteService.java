package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.dao.TramiteDAO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class TramiteService {

	/** The trmt DAO. */
	@Inject
	private TramiteDAO trmtDAO;

	/** The fncd DAO. */
	@Inject
	private FuncionalidadDAO fncdDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/** The fngr DAO. */
	@Inject
	private FuncionalidadGrupoDAO fngrDAO;

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<TramiteVO> selectList(@NonNull final TramiteCriterioVO criterio) {
		return trmtDAO.selectList(criterio);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tramite VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TramiteVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final TramiteCriterioVO criterio = new TramiteCriterioVO();

		criterio.setId(id);
		criterio.setIdioma(idioma);

		final TramiteVO trmt = trmtDAO.selectObject(criterio);

		if (trmt == null) {
			throw new InstanceNotFoundException(MessageI18nKey.trmt, id);
		}

		return trmt;
	}

	/**
	 * Insert.
	 *
	 * @param trmt
	 *            the trmt
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TramiteVO trmt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (trmtDAO.exists(trmt)) {
			throw new DuplicateInstanceException(MessageI18nKey.trmt, trmt);
		}

		IgUtilBO.assignNextVal(trmt);
		fncdDAO.insert(trmt);
		trmtDAO.insert(trmt);

		I18nUtil.insertMap(i18nDAO, trmt, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param trmt
	 *            the trmt
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TramiteVO trmt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(trmt.getId());

		if (trmtDAO.update(trmt) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.trmt, trmt.getId());
		}

		I18nUtil.updateMap(i18nDAO, trmt, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param trmt
	 *            the trmt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TramiteVO trmt) throws InstanceNotFoundException {
		Preconditions.checkNotNull(trmt.getId());

		if (trmtDAO.delete(trmt) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.trmt, trmt);
		}

		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setFncdId(trmt.getId());

		fngrDAO.deleteList(fngrCriterio);
		fncdDAO.delete(trmt);

		I18nUtil.deleteMap(i18nDAO, trmt);
	}
}
