package xeredi.argo.model.facturacion.bo;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionImpuestoBO.
 */
public final class ValoracionImpuestoBO {
    /**
     * Select vlri list.
     *
     * @param vlrcCriterio
     *            the vlrc criterio
     * @return the list
     */
    public List<ValoracionImpuestoVO> selectList(final @NonNull ValoracionCriterioVO vlrcCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);

            return vlriDAO.selectList(vlrcCriterio);
        }
    }
}
