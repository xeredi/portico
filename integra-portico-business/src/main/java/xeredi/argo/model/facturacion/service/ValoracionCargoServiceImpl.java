package xeredi.argo.model.facturacion.service;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import xeredi.argo.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCargoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ValoracionCargoServiceImpl implements ValoracionCargoService {

	/** The vlrg DAO. */
	@Inject
	private ValoracionCargoDAO vlrgDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ValoracionCargoVO> selectList(ValoracionCriterioVO vlrcCriterio) {
		return vlrgDAO.selectList(vlrcCriterio);
	}
}
