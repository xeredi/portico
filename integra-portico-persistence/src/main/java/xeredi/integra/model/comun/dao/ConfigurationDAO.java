package xeredi.integra.model.comun.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConfigurationDAO.
 */
public interface ConfigurationDAO {

    /**
     * Select list.
     *
     * @return the list
     */
    List<ConfigurationVO> selectList();

    /**
     * Update.
     *
     * @return the int
     */
    int update(final ConfigurationVO vo);

    /**
     * Select.
     *
     * @param key
     *            the key
     * @return the configuration vo
     */
    ConfigurationVO select(final String key);
}