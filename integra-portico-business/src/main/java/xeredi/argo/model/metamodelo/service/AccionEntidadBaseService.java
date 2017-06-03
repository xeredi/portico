package xeredi.argo.model.metamodelo.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.argo.model.metamodelo.dao.AccionEntidadBaseDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadBaseServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class AccionEntidadBaseService {

	/** The aebs DAO. */
	@Inject
	private AccionEntidadBaseDAO aebsDAO;

	/**
	 * Select list.
	 *
	 * @param aebsCriterio
	 *            the aebs criterio
	 * @return the list
	 */
	public List<AccionEntidadBaseVO> selectList(AccionEntidadBaseCriterioVO aebsCriterio) {
		return aebsDAO.selectList(aebsCriterio);
	}

}
