package xeredi.argo.model.metamodelo.bo;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.dao.FuncionalidadDAO;
import xeredi.argo.model.metamodelo.vo.FuncionalidadCriterioVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionalidadBO.
 */
public final class FuncionalidadBO {

    /**
     * Checks if is user allowed.
     *
     * @param fncdId
     *            the fncd id
     * @param usroId
     *            the usro id
     * @return true, if is user allowed
     */
    public boolean isUserAllowed(@NonNull final Long fncdId, @NonNull final Long usroId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FuncionalidadDAO fncdDAO = session.getMapper(FuncionalidadDAO.class);
            final FuncionalidadCriterioVO fncdCriterio = new FuncionalidadCriterioVO();

            fncdCriterio.setId(fncdId);
            fncdCriterio.setUsroId(usroId);

            return fncdDAO.count(fncdCriterio) > 0;
        }
    }
}
