package xeredi.integra.model.comun.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ConfigurationCriterioVO;
import xeredi.integra.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConfigurationDAO.
 */
public interface ConfigurationDAO extends CrudDAO<ConfigurationVO, ConfigurationCriterioVO> {
    /**
     * Select list.
     *
     * @return the list
     */
    List<ConfigurationVO> selectAll();
}
