package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.IgDAO;
import xeredi.integra.model.comun.vo.IgVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class IgBO.
 */
public final class IgBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(IgBO.class);

    /** The Constant MAP. */
    private static final Map<String, IgVO> MAP = new HashMap<>();

    /**
     * Next val.
     *
     * @param nombre
     *            the nombre
     * @return the long
     */
    public synchronized Long nextVal(final String nombre) {
        Preconditions.checkNotNull(nombre);

        IgVO vo = MAP.get(nombre);

        if (vo == null) {
            try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
                if (LOG.isDebugEnabled()) {
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
                if (LOG.isDebugEnabled()) {
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
