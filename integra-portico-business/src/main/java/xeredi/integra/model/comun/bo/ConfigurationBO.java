package xeredi.integra.model.comun.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.ConfigurationDAO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ConfigurationCriterioVO;
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

            return confDAO.selectAll();
        }
    }

    /**
     * Select.
     *
     * @param key
     *            the key
     * @return the configuration vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final ConfigurationVO select(final @NonNull ConfigurationKey key) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);
            final ConfigurationCriterioVO confCriterio = new ConfigurationCriterioVO();

            confCriterio.setKey(key);

            final ConfigurationVO conf = confDAO.selectObject(confCriterio);

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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void update(final @NonNull ConfigurationVO vo) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

            if (confDAO.update(vo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.conf, vo.getKey());
            }

            session.commit();
        }
    }

}
