package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.dao.ModuloDAO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;
import xeredi.argo.model.seguridad.dao.FuncionalidadGrupoDAO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ModuloService {

	/** The mdlo DAO. */
	@Inject
	private ModuloDAO mdloDAO;

	/** The fncd DAO. */
	@Inject
	private FuncionalidadDAO fncdDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/** The fngr DAO. */
	@Inject
	private FuncionalidadGrupoDAO fngrDAO;

	/**
	 * Insert.
	 *
	 * @param mdlo
	 *            the mdlo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final ModuloVO mdlo, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (mdloDAO.exists(mdlo)) {
			throw new DuplicateInstanceException(MessageI18nKey.mdlo, mdlo);
		}

		IgUtilBO.assignNextVal(mdlo);
		fncdDAO.insert(mdlo);
		mdloDAO.insert(mdlo);

		i18nService.insertMap(mdlo, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param mdlo
	 *            the mdlo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final ModuloVO mdlo, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(mdlo.getId());

		if (mdloDAO.update(mdlo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.mdlo, mdlo);
		}

		i18nService.updateMap(mdlo, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param mdlo
	 *            the mdlo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final ModuloVO mdlo) throws InstanceNotFoundException {
		Preconditions.checkNotNull(mdlo.getId());

		if (mdloDAO.delete(mdlo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.mdlo, mdlo);
		}

		i18nService.deleteMap(mdlo);

		final FuncionalidadGrupoCriterioVO fngrCriterio = new FuncionalidadGrupoCriterioVO();

		fngrCriterio.setFncdId(mdlo.getId());

		fngrDAO.deleteList(fngrCriterio);
		fncdDAO.delete(mdlo);
	}

	/**
	 * Select list.
	 *
	 * @param mdloCriterio
	 *            the mdlo criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ModuloVO> selectList(@NonNull final ModuloCriterioVO mdloCriterio, int offset, int limit) {
		final int count = mdloDAO.count(mdloCriterio);

		return new PaginatedList<ModuloVO>(
				count > offset ? mdloDAO.selectList(mdloCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param mdloCriterio
	 *            the mdlo criterio
	 * @return the list
	 */
	public List<ModuloVO> selectList(@NonNull final ModuloCriterioVO mdloCriterio) {
		return mdloDAO.selectList(mdloCriterio);
	}

	/**
	 * Select object.
	 *
	 * @param mdloCriterio
	 *            the mdlo criterio
	 * @return the modulo VO
	 */
	public ModuloVO selectObject(@NonNull final ModuloCriterioVO mdloCriterio) {
		return mdloDAO.selectObject(mdloCriterio);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the modulo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ModuloVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

		mdloCriterio.setId(id);
		mdloCriterio.setIdioma(idioma);

		final ModuloVO mdlo = selectObject(mdloCriterio);

		if (mdlo == null) {
			throw new InstanceNotFoundException(MessageI18nKey.mdlo, id);
		}

		return mdlo;
	}

}
