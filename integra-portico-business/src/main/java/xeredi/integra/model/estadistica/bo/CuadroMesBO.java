package xeredi.integra.model.estadistica.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.estadistica.dao.CuadroMesDAO;
import xeredi.integra.model.estadistica.vo.CuadroMesVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

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
        Preconditions.checkNotNull(peprId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final CuadroMesDAO cdmsDAO = session.getMapper(CuadroMesDAO.class);
            final Map<String, List<CuadroMesVO>> cdmsMap = new HashMap<>();

            for (final CuadroMesVO cdmsVO : cdmsDAO.selectList(peprId)) {
                final String cocuKey = cdmsVO.getCocu().getParametro();

                if (!cdmsMap.containsKey(cocuKey)) {
                    cdmsMap.put(cocuKey, new ArrayList<CuadroMesVO>());
                }

                cdmsMap.get(cocuKey).add(cdmsVO);
            }

            return cdmsMap;
        }
    }
}
