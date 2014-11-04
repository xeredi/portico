package xeredi.integra.model.comun.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.ConfigurationDAO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.ConfigurationVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
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
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

            return confDAO.selectList();
        }
    }

    /**
     * Select.
     *
     * @param key
     *            the key
     * @return the configuration vo
     */
    public final ConfigurationVO select(final ConfigurationKey key) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

            final ConfigurationVO conf = confDAO.select(key);

            if (conf == null) {
                throw new InstanceNotFoundException(MessageI18nKey.conf, key);
            }

            return conf;
        }
    }

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    public final int update(final ConfigurationVO vo) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

            final int updated = confDAO.update(vo);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.conf, vo.getKey());
            }

            session.commit();

            return updated;
        }
    }

}
