package xeredi.argo.model.comun.service;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

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
@Singleton
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

	/** The conf DAO. */
	@Inject
	private ConfigurationDAO confDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ConfigurationVO> selectList() {
		final ConfigurationCriterioVO confCriterio = new ConfigurationCriterioVO();

		return confDAO.selectList(confCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final ConfigurationVO vo) throws InstanceNotFoundException {
		if (confDAO.update(vo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.conf, vo.getKey());
		}
	}
}
