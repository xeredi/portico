package xeredi.integra.model.bo.facturacion;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.facturacion.ValoracionDAO;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;

import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
@Singleton
public class ValoracionBO implements Valoracion {

    /** The vlrc dao. */
    @Inject
    ValoracionDAO vlrcDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void delete(Long id) {
        final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
        final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
        final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();

        vlrcCriterioVO.setId(id);
        vlrlCriterioVO.setVlrc(vlrcCriterioVO);
        vlrdCriterioVO.setVlrl(vlrlCriterioVO);

    }

}
