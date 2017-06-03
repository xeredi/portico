package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ValoracionDetalleService {

	/** The vlrd DAO. */
	private final ValoracionDetalleDAO vlrdDAO;

	/**
	 * Instantiates a new valoracion detalle service.
	 *
	 * @param vlrdDAO
	 *            the vlrd DAO
	 */
	@Inject
	public ValoracionDetalleService(final ValoracionDetalleDAO vlrdDAO) {
		super();
		this.vlrdDAO = vlrdDAO;
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the valoracion detalle VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ValoracionDetalleVO select(Long id, String idioma) throws InstanceNotFoundException {
		final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

		vlrdCriterio.setId(id);
		vlrdCriterio.setIdioma(idioma);

		final ValoracionDetalleVO vlrd = vlrdDAO.selectObject(vlrdCriterio);

		if (vlrd == null) {
			throw new InstanceNotFoundException(MessageI18nKey.vlrd, id);
		}

		return vlrd;
	}

	/**
	 * Select list.
	 *
	 * @param vlrdCriterio
	 *            the vlrd criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ValoracionDetalleVO> selectList(ValoracionDetalleCriterioVO vlrdCriterio, int offset,
			int limit) {
		final int count = vlrdDAO.count(vlrdCriterio);

		return new PaginatedList<ValoracionDetalleVO>(
				count > offset ? vlrdDAO.selectList(vlrdCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param vlrdCriterio
	 *            the vlrd criterio
	 * @return the list
	 */
	public List<ValoracionDetalleVO> selectList(ValoracionDetalleCriterioVO vlrdCriterio) {
		return vlrdDAO.selectList(vlrdCriterio);
	}

	/**
	 * Insert.
	 *
	 * @param vlrd
	 *            the vlrd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void insert(ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
		// TODO Auto-generated method stub

	}

	/**
	 * Update.
	 *
	 * @param vlrd
	 *            the vlrd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
		// TODO Auto-generated method stub

	}

	/**
	 * Delete.
	 *
	 * @param vlrd
	 *            the vlrd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
		// TODO Auto-generated method stub

	}

}
