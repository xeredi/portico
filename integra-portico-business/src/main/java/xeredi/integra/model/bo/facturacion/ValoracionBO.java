package xeredi.integra.model.bo.facturacion;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.facturacion.ServicioCargoDAO;
import xeredi.integra.model.dao.facturacion.ValoracionCargoDAO;
import xeredi.integra.model.dao.facturacion.ValoracionDAO;
import xeredi.integra.model.dao.facturacion.ValoracionDetalleDAO;
import xeredi.integra.model.dao.facturacion.ValoracionImpuestoDAO;
import xeredi.integra.model.dao.facturacion.ValoracionLineaDAO;
import xeredi.integra.model.vo.facturacion.ServicioCargoCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;

import com.google.common.base.Preconditions;
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

    /** The vlrl dao. */
    @Inject
    ValoracionLineaDAO vlrlDAO;

    /** The vlrd dao. */
    @Inject
    ValoracionDetalleDAO vlrdDAO;

    /** The vlri dao. */
    @Inject
    ValoracionImpuestoDAO vlriDAO;

    /** The vlrg dao. */
    @Inject
    ValoracionCargoDAO vlrgDAO;

    /** The srcr dao. */
    @Inject
    ServicioCargoDAO srcrDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void delete(Long id) {
        Preconditions.checkNotNull(id);

        final Set<Long> vlrcIds = new HashSet<Long>();
        final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
        final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
        final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();
        final ServicioCargoCriterioVO srcrCriterioVO = new ServicioCargoCriterioVO();

        vlrcIds.add(id);
        srcrCriterioVO.setVlrcIds(vlrcIds);
        vlrcCriterioVO.setId(id);
        vlrlCriterioVO.setVlrc(vlrcCriterioVO);
        vlrdCriterioVO.setVlrl(vlrlCriterioVO);

        srcrDAO.deleteValoracion(srcrCriterioVO);

        vlrdDAO.delete(vlrdCriterioVO);
        vlrlDAO.delete(vlrlCriterioVO);
        vlriDAO.delete(vlrcCriterioVO);
        vlrgDAO.delete(vlrcCriterioVO);
        vlrcDAO.delete(vlrcCriterioVO);
    }

}
