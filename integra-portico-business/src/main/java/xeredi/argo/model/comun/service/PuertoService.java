package xeredi.argo.model.comun.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.PuertoDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
@Singleton
public class PuertoService {

	/** The prto DAO. */
	@Inject
	private PuertoDAO prtoDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the puerto VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public PuertoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setId(id);
		prtoCriterio.setIdioma(idioma);

		final PuertoVO prto = selectObject(prtoCriterio);

		if (prto == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prto, id);
		}

		return prto;
	}

	/**
	 * Select object.
	 *
	 * @param prtoCriterio
	 *            the prto criterio
	 * @return the puerto VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public PuertoVO selectObject(@NonNull final PuertoCriterioVO prtoCriterio) throws InstanceNotFoundException {
		final PuertoVO prto = prtoDAO.selectObject(prtoCriterio);

		if (prto == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prto, prtoCriterio);
		}

		return prto;
	}

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<PuertoVO> selectList(@NonNull final PuertoCriterioVO criterio) {
		return prtoDAO.selectList(criterio);
	}

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<PuertoVO> selectList(@NonNull final PuertoCriterioVO criterio, int offset, int limit) {
		final int count = prtoDAO.count(criterio);

		return new PaginatedList<PuertoVO>(
				count >= offset ? prtoDAO.selectList(criterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Insert.
	 *
	 * @param prto
	 *            the prto
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final PuertoVO prto, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		Preconditions.checkNotNull(prto.getCodigo());
		Preconditions.checkNotNull(prto.getCodigoCorto());
		Preconditions.checkNotNull(prto.getSprt());
		Preconditions.checkNotNull(prto.getSprt().getId());

		if (prtoDAO.exists(prto)) {
			throw new DuplicateInstanceException(MessageI18nKey.prto, prto);
		}

		IgUtilBO.assignNextVal(prto);
		prtoDAO.insert(prto);
		i18nService.insertMap(prto, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param prto
	 *            the prto
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final PuertoVO prto, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(prto.getId());
		Preconditions.checkNotNull(prto.getCodigoCorto());
		Preconditions.checkNotNull(prto.getSprt());
		Preconditions.checkNotNull(prto.getSprt().getId());

		if (prtoDAO.update(prto) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.prto, prto);
		}

		i18nService.updateMap(prto, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param prto
	 *            the prto
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(final @NonNull PuertoVO prto) throws InstanceNotFoundException {
		Preconditions.checkNotNull(prto.getId());

		if (prtoDAO.delete(prto) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.prto, prto);
		}

		i18nService.deleteMap(prto);
	}
}
