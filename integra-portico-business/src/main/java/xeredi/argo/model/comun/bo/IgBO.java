package xeredi.argo.model.comun.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.IgDAO;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.comun.vo.IgVO;
import xeredi.argo.model.comun.vo.VersionVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class IgBO.
 */
public final class IgBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(IgBO.class);

    /** The Constant SQ_INTEGRA. */
    public static final String SQ_INTEGRA = "sq_integra";

    /** The Constant MAP. */
    private static final Map<String, IgVO> MAP = new HashMap<>();

    /**
     * Assign next val.
     *
     * @param identifiable
     *            the identifiable
     */
    public synchronized void assignNextVal(final Identifiable identifiable) {
        identifiable.setId(nextVal(SQ_INTEGRA));
    }

    /**
     * Assign next val.
     *
     * @param version
     *            the version
     */
    public synchronized void assignNextVal(final VersionVO version) {
        version.setId(nextVal(SQ_INTEGRA));
    }

    /**
     * Next val.
     *
     * @param nombre
     *            the nombre
     * @return the long
     */
    public synchronized Long nextVal(final @NonNull String nombre) {
        IgVO vo = MAP.get(nombre);

        if (vo == null) {
            try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
                if (LOG.isTraceEnabled()) {
                    LOG.debug("Inicializar secuencia: " + nombre);
                }

                final IgDAO igDAO = session.getMapper(IgDAO.class);
                final int updated = igDAO.update(nombre);

                if (updated == 0) {
                    throw new Error("No se encuentra secuencia para: " + nombre);
                }

                vo = igDAO.select(nombre);

                session.commit();
            }

            vo.setInicio(vo.getUltimo() - vo.getCache());
            vo.setFin(vo.getUltimo());
            vo.setUltimo(vo.getInicio());

            MAP.put(nombre, vo);
        }

        if (vo.getUltimo() + vo.getIncremento() > vo.getFin()) {
            try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
                if (LOG.isTraceEnabled()) {
                    LOG.debug("Actualizar secuencia: " + nombre);
                }

                final IgDAO igDAO = session.getMapper(IgDAO.class);
                final int updated = igDAO.update(nombre);

                if (updated == 0) {
                    throw new Error("No se encuentra secuencia para: " + nombre);
                }

                vo = igDAO.select(nombre);

                session.commit();
            }

            vo.setInicio(vo.getUltimo() - vo.getCache());
            vo.setFin(vo.getUltimo());
            vo.setUltimo(vo.getInicio());

            MAP.put(nombre, vo);
        }

        vo.setUltimo(vo.getUltimo() + vo.getIncremento());

        return vo.getUltimo();
    }
}
