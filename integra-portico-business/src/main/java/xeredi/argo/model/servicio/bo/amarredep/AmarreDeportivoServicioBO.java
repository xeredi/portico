package xeredi.argo.model.servicio.bo.amarredep;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.dao.amarredep.AmarreDeportivoServicioDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreDeportivoServicioBO.
 */
public final class AmarreDeportivoServicioBO extends ServicioBO {

    /**
     * Instantiates a new amarre deportivo servicio BO.
     *
     * @param ausroId
     *            the ausro id
     */
    public AmarreDeportivoServicioBO(final @NonNull Long ausroId) {
        super(Entidad.AMARRE_DEP_SRV.getId(), ausroId);
    }

    /**
     * Select generate.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<ServicioMaestroVO> selectGenerate(final ServicioCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AmarreDeportivoServicioDAO samadDAO = session.getMapper(AmarreDeportivoServicioDAO.class);

            return samadDAO.selectGenerateList(criterio);
        }
    }
}
