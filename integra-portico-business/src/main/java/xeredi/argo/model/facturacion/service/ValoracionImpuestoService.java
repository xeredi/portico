package xeredi.argo.model.facturacion.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.argo.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionImpuestoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ValoracionImpuestoService {

	/** The vlri DAO. */
	private final ValoracionImpuestoDAO vlriDAO;

	/**
	 * Instantiates a new valoracion impuesto service.
	 *
	 * @param vlriDAO
	 *            the vlri DAO
	 */
	@Inject
	public ValoracionImpuestoService(final ValoracionImpuestoDAO vlriDAO) {
		super();
		this.vlriDAO = vlriDAO;
	}

	/**
	 * Select list.
	 *
	 * @param vlrcCriterio
	 *            the vlrc criterio
	 * @return the list
	 */
	public List<ValoracionImpuestoVO> selectList(ValoracionCriterioVO vlrcCriterio) {
		return vlriDAO.selectList(vlrcCriterio);
	}
}
