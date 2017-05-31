package xeredi.argo.model.comun.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.ConfigurationDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ConfigurationCriterioVO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.ConfigurationVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
@Singleton
public class ConfigurationService {

	/** The conf DAO. */
	@Inject
	private ConfigurationDAO confDAO;

	/**
	 * Select list.
	 *
	 * @return the list
	 */
	public List<ConfigurationVO> selectList() {
		final ConfigurationCriterioVO confCriterio = new ConfigurationCriterioVO();

		return confDAO.selectList(confCriterio);
	}

	/**
	 * Select.
	 *
	 * @param key
	 *            the key
	 * @return the configuration VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ConfigurationVO select(@NonNull final ConfigurationKey key) throws InstanceNotFoundException {
		final ConfigurationCriterioVO confCriterio = new ConfigurationCriterioVO();

		confCriterio.setKey(key);

		final ConfigurationVO conf = confDAO.selectObject(confCriterio);

		if (conf == null) {
			throw new InstanceNotFoundException(MessageI18nKey.conf, key);
		}

		return conf;
	}

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final ConfigurationVO vo) throws InstanceNotFoundException {
		if (confDAO.update(vo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.conf, vo.getKey());
		}
	}
}
