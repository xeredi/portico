package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

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
public class ValoracionDetalleServiceImpl implements ValoracionDetalleService {

	@Inject
	private ValoracionDetalleDAO vlrdDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<ValoracionDetalleVO> selectList(ValoracionDetalleCriterioVO vlrdCriterio, int offset,
			int limit) {
		final int count = vlrdDAO.count(vlrdCriterio);

		return new PaginatedList<ValoracionDetalleVO>(
				count > offset ? vlrdDAO.selectList(vlrdCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ValoracionDetalleVO> selectList(ValoracionDetalleCriterioVO vlrdCriterio) {
		return vlrdDAO.selectList(vlrdCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
		// TODO Auto-generated method stub

	}

}
