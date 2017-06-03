package xeredi.argo.model.facturacion.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.argo.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCargoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ValoracionCargoService {

	/** The vlrg DAO. */
	private final ValoracionCargoDAO vlrgDAO;

	/**
	 * Instantiates a new valoracion cargo service.
	 *
	 * @param vlrgDAO
	 *            the vlrg DAO
	 */
	@Inject
	public ValoracionCargoService(final ValoracionCargoDAO vlrgDAO) {
		super();
		this.vlrgDAO = vlrgDAO;
	}

	/**
	 * Select list.
	 *
	 * @param vlrcCriterio
	 *            the vlrc criterio
	 * @return the list
	 */
	public List<ValoracionCargoVO> selectList(ValoracionCriterioVO vlrcCriterio) {
		return vlrgDAO.selectList(vlrcCriterio);
	}
}
