package xeredi.argo.model.comun.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.dao.ConfigurationDAO;
import xeredi.argo.model.comun.vo.ConfigurationCriterioVO;
import xeredi.argo.model.comun.vo.ConfigurationVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationBO.
 */
public final class ConfigurationBO {

	/**
	 * Select list.
	 *
	 * @return the list
	 */
	public List<ConfigurationVO> selectList() {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);
			final ConfigurationCriterioVO confCriterio = new ConfigurationCriterioVO();

			return confDAO.selectList(confCriterio);
		}
	}
}
