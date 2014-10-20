package xeredi.integra.model.comun.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.ConfigurationDAO;
import xeredi.integra.model.comun.vo.ConfigurationVO;
import xeredi.util.mybatis.SqlMapperLocator;

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
    public final List<ConfigurationVO> selectList() {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

        try {
            return confDAO.selectList();
        } finally {
            session.close();
        }
    }

    /**
     * Select.
     *
     * @param key
     *            the key
     * @return the configuration vo
     */
    public final ConfigurationVO select(final String key) {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

        try {
            return confDAO.select(key);
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    public final int update(final ConfigurationVO vo) {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

        try {
            final int updated = confDAO.update(vo);

            session.commit();

            return updated;
        } finally {
            session.close();
        }
    }

}
