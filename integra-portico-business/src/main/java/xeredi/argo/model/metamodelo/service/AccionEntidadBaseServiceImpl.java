package xeredi.argo.model.metamodelo.service;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import xeredi.argo.model.metamodelo.dao.AccionEntidadBaseDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadBaseServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class AccionEntidadBaseServiceImpl implements AccionEntidadBaseService {

	/** The aebs DAO. */
	@Inject
	private AccionEntidadBaseDAO aebsDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AccionEntidadBaseVO> selectList(AccionEntidadBaseCriterioVO aebsCriterio) {
		return aebsDAO.selectList(aebsCriterio);
	}

}
