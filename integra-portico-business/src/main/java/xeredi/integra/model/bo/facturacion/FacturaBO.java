package xeredi.integra.model.bo.facturacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.facturacion.FacturaCargoDAO;
import xeredi.integra.model.dao.facturacion.FacturaDAO;
import xeredi.integra.model.dao.facturacion.FacturaImpuestoDAO;
import xeredi.integra.model.dao.facturacion.FacturaLineaDAO;
import xeredi.integra.model.dao.facturacion.FacturaServicioDAO;
import xeredi.integra.model.vo.facturacion.FacturaCargoVO;
import xeredi.integra.model.vo.facturacion.FacturaCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaImpuestoVO;
import xeredi.integra.model.vo.facturacion.FacturaLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaLineaVO;
import xeredi.integra.model.vo.facturacion.FacturaServicioVO;
import xeredi.integra.model.vo.facturacion.FacturaVO;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaBO.
 */
public class FacturaBO implements Factura {

    /** The fctr dao. */
    @Inject
    FacturaDAO fctrDAO;

    /** The fctg dao. */
    @Inject
    FacturaCargoDAO fctgDAO;

    /** The fcti dao. */
    @Inject
    FacturaImpuestoDAO fctiDAO;

    /** The fcts dao. */
    @Inject
    FacturaServicioDAO fctsDAO;

    /** The fctl dao. */
    @Inject
    FacturaLineaDAO fctlDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public List<FacturaImpresionVO> selectImprimir(final Set<Long> fctrIds) {
        Preconditions.checkNotNull(fctrIds);
        Preconditions.checkArgument(!fctrIds.isEmpty());

        final List<FacturaImpresionVO> list = new ArrayList<>();

        for (final Long fctrId : fctrIds) {
            final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();
            final FacturaLineaCriterioVO fctlCriterioVO = new FacturaLineaCriterioVO();

            fctrCriterioVO.setId(fctrId);
            fctlCriterioVO.setFctr(fctrCriterioVO);

            final FacturaVO fctr = fctrDAO.select(fctrId);

            if (fctr != null) {
                final List<FacturaCargoVO> fctgList = fctgDAO.selectList(fctrCriterioVO);
                final List<FacturaImpuestoVO> fctiList = fctiDAO.selectList(fctrCriterioVO);
                final List<FacturaServicioVO> fctsList = fctsDAO.selectList(fctrCriterioVO);
                final List<FacturaLineaVO> fctlList = fctlDAO.selectList(fctlCriterioVO);

                final Map<Long, FacturaServicioVO> fctsMap = new HashMap<>();

                for (final FacturaServicioVO fcts : fctsList) {
                    fctsMap.put(fcts.getId(), fcts);
                }

                list.add(new FacturaImpresionVO(fctr, fctgList, fctiList, fctlList, fctsMap));
            }
        }

        return list;
    }

}
