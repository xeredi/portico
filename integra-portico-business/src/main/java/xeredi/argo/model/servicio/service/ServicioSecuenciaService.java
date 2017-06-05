package xeredi.argo.model.servicio.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaService.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ServicioSecuenciaService {

	/** The srsc DAO. */
	private final ServicioSecuenciaDAO srscDAO;

	/**
	 * Instantiates a new servicio secuencia service.
	 *
	 * @param srscDAO
	 *            the srsc DAO
	 */
	@Inject
	protected ServicioSecuenciaService(final ServicioSecuenciaDAO srscDAO) {
		super();
		this.srscDAO = srscDAO;
	}

	/**
	 * Insert.
	 *
	 * @param srsc
	 *            the srsc
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(final ServicioSecuenciaVO srsc) throws DuplicateInstanceException {
		if (srscDAO.exists(srsc)) {
			throw new DuplicateInstanceException(MessageI18nKey.srsc, srsc);
		}

		srscDAO.insert(srsc);
	}

	/**
	 * Update.
	 *
	 * @param srsc
	 *            the srsc
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(final ServicioSecuenciaVO srsc) throws InstanceNotFoundException {
		if (srscDAO.update(srsc) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.srsc, srsc);
		}
	}

	/**
	 * Delete.
	 *
	 * @param srsc
	 *            the srsc
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(final ServicioSecuenciaVO srsc) throws InstanceNotFoundException {
		if (srscDAO.delete(srsc) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.srsc, srsc);
		}
	}

	/**
	 * Select.
	 *
	 * @param srscCriterio
	 *            the srsc criterio
	 * @return the servicio secuencia VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ServicioSecuenciaVO select(final ServicioSecuenciaCriterioVO srscCriterio) throws InstanceNotFoundException {
		final ServicioSecuenciaVO srsc = srscDAO.selectObject(srscCriterio);

		if (srsc == null) {
			throw new InstanceNotFoundException(MessageI18nKey.srsc, srscCriterio);
		}

		return srsc;
	}

	/**
	 * Select list.
	 *
	 * @param srscCriterio
	 *            the srsc criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ServicioSecuenciaVO> selectList(final ServicioSecuenciaCriterioVO srscCriterio,
			final int offset, final int limit) {
		final int count = srscDAO.count(srscCriterio);

		return new PaginatedList<>(
				count > offset ? srscDAO.selectList(srscCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}
}
