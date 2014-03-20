package xeredi.integra.model.bo.estadistica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.estadistica.CuadroMesDAO;
import xeredi.integra.model.vo.estadistica.CuadroMesVO;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesBO.
 */
@Singleton
public class CuadroMesBO implements CuadroMes {

    /** The cdms dao. */
    @Inject
    CuadroMesDAO cdmsDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final Map<String, List<CuadroMesVO>> selectMap(final Long peprId) {
        Preconditions.checkNotNull(peprId);

        final List<CuadroMesVO> cdmsList = cdmsDAO.selectList(peprId);
        final Map<String, List<CuadroMesVO>> cdmsMap = new HashMap<>();

        for (final CuadroMesVO cdmsVO : cdmsList) {
            final String cocuKey = cdmsVO.getCocu().getParametro();

            if (!cdmsMap.containsKey(cocuKey)) {
                cdmsMap.put(cocuKey, new ArrayList<CuadroMesVO>());
            }

            cdmsMap.get(cocuKey).add(cdmsVO);
        }

        return cdmsMap;
    }
}
