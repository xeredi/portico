package xeredi.argo.model.facturacion.service;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import xeredi.argo.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionImpuestoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ValoracionImpuestoServiceImpl implements ValoracionImpuestoService {

	/** The vlri DAO. */
	@Inject
	private ValoracionImpuestoDAO vlriDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ValoracionImpuestoVO> selectList(ValoracionCriterioVO vlrcCriterio) {
		return vlriDAO.selectList(vlrcCriterio);
	}
}