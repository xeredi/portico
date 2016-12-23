package xeredi.argo.model.comun.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConfigurationService.
 */
public interface ConfigurationService {
	/**
	 * Select list.
	 *
	 * @return the list
	 */
	public List<ConfigurationVO> selectList();

	/**
	 * Select.
	 *
	 * @param key
	 *            the key
	 * @return the configuration vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ConfigurationVO select(@NonNull final ConfigurationKey key) throws InstanceNotFoundException;

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final ConfigurationVO vo) throws InstanceNotFoundException;

}
