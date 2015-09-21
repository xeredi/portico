package xeredi.argo.model.estadistica.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.estadistica.dao.CuadroMesDAO;
import xeredi.argo.model.estadistica.vo.CuadroMesVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesBO.
 */
public class CuadroMesBO {
    /**
     * Select map.
     *
     * @param peprId
     *            the pepr id
     * @return the map
     */
    public final Map<String, List<CuadroMesVO>> selectMap(final Long peprId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CuadroMesDAO cdmsDAO = session.getMapper(CuadroMesDAO.class);
            final Map<String, List<CuadroMesVO>> cdmsMap = new HashMap<>();
            final PeriodoProcesoCriterioVO peprCriterio = new PeriodoProcesoCriterioVO();

            peprCriterio.setId(peprId);

            for (final CuadroMesVO cdmsVO : cdmsDAO.selectList(peprCriterio)) {
                final String cocuKey = cdmsVO.getCocu();

                if (!cdmsMap.containsKey(cocuKey)) {
                    cdmsMap.put(cocuKey, new ArrayList<CuadroMesVO>());
                }

                cdmsMap.get(cocuKey).add(cdmsVO);
            }

            return cdmsMap;
        }
    }
}
