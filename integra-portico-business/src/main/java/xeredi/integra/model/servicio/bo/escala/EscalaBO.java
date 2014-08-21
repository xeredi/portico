package xeredi.integra.model.servicio.bo.escala;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.servicio.dao.escala.EscalaDAO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EscalaBO.
 */
public final class EscalaBO {

    /**
     * Obtener numero manifiesto aeat.
     * 
     * @param srvcId
     *            the srvc id
     * @return the string
     */
    public String obtenerNumeroManifiestoAeat(final Long srvcId) {
        Preconditions.checkNotNull(srvcId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);

            return escaDAO.selectNumeroManifiestoAeat(srvcId);
        }
    }
}
