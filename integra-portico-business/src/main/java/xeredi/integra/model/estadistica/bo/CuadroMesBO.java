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

    /** The cdms dao. */
    CuadroMesDAO cdmsDAO;

    /**
     * Select map.
     *
     * @param peprId
     *            the pepr id
     * @return the map
     */
    public final Map<String, List<CuadroMesVO>> selectMap(final Long peprId) {
        Preconditions.checkNotNull(peprId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        cdmsDAO = session.getMapper(CuadroMesDAO.class);

        try {
            final Map<String, List<CuadroMesVO>> cdmsMap = new HashMap<>();

            for (final CuadroMesVO cdmsVO : cdmsDAO.selectList(peprId)) {
                final String cocuKey = cdmsVO.getCocu().getParametro();

                if (!cdmsMap.containsKey(cocuKey)) {
                    cdmsMap.put(cocuKey, new ArrayList<CuadroMesVO>());
                }

                cdmsMap.get(cocuKey).add(cdmsVO);
            }

            return cdmsMap;
        } finally {
            session.close();
        }
    }
}
