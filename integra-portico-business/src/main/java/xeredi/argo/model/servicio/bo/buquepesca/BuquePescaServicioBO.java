package xeredi.argo.model.servicio.bo.buquepesca;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.dao.buquepesca.BuquePescaServicioDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioBuquePescaBO.
 */
public final class BuquePescaServicioBO extends ServicioBO {

    /**
     * Instantiates a new buque pesca servicio BO.
     *
     * @param ausroId
     *            the ausro id
     */
    public BuquePescaServicioBO(final @NonNull Long ausroId) {
        super(Entidad.BUQUE_PESCA_SRV.getId(), ausroId);
    }

    /**
     * Select generate.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<ServicioMaestroVO> selectGenerate(final @NonNull ServicioCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final BuquePescaServicioDAO sbupDAO = session.getMapper(BuquePescaServicioDAO.class);

            return sbupDAO.selectGenerateList(criterio);
        }
    }
}
