package xeredi.integra.model.servicio.bo.buquepesca;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.dao.buquepesca.BuquePescaServicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioMaestroVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioBuquePescaBO.
 */
public final class BuquePescaServicioBO extends ServicioBO {

    /**
     * Select generate.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<ServicioMaestroVO> selectGenerate(final ServicioCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final BuquePescaServicioDAO sbupDAO = session.getMapper(BuquePescaServicioDAO.class);

            return sbupDAO.selectGenerateList(criterio);
        }
    }
}
