package xeredi.argo.model.comun.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.dao.ConfigurationDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ConfigurationCriterioVO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.ConfigurationVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
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
    public List<ConfigurationVO> selectList() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);
            final ConfigurationCriterioVO confCriterio = new ConfigurationCriterioVO();

            return confDAO.selectList(confCriterio);
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
    public ConfigurationVO select(@NonNull final ConfigurationKey key) throws InstanceNotFoundException {
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
    public void update(@NonNull final ConfigurationVO vo) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ConfigurationDAO confDAO = session.getMapper(ConfigurationDAO.class);

            if (confDAO.update(vo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.conf, vo.getKey());
            }

            session.commit();
        }
    }

}
