package xeredi.integra.model.servicio.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.dao.ServicioTramiteDAO;
import xeredi.integra.model.servicio.vo.ServicioTramiteCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioTramiteBO.
 */
public final class ServicioTramiteBO {

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the servicio tramite vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ServicioTramiteVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioTramiteDAO srtrDAO = session.getMapper(ServicioTramiteDAO.class);
            final ServicioTramiteCriterioVO srtrCriterio = new ServicioTramiteCriterioVO();

            srtrCriterio.setId(id);
            srtrCriterio.setIdioma(idioma);

            final ServicioTramiteVO srtr = srtrDAO.selectObject(srtrCriterio);

            if (srtr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.srtr, id);
            }

            return srtr;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<ServicioTramiteVO> selectList(final @NonNull ServicioTramiteCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ServicioTramiteDAO srtrDAO = session.getMapper(ServicioTramiteDAO.class);

            return srtrDAO.selectList(criterio);
        }
    }
}
