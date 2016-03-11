package xeredi.argo.model.facturacion.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionCargoBO.
 */
public final class ValoracionCargoBO {
    /**
     * Select list.
     *
     * @param vlrcCriterio
     *            the vlrc criterio
     * @return the list
     */
    public List<ValoracionCargoVO> selectList(final @NonNull ValoracionCriterioVO vlrcCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);

            return vlrgDAO.selectList(vlrcCriterio);
        }
    }
}
