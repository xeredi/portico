package xeredi.integra.model.servicio.bo.manifiesto;

import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.metamodelo.proxy.TramiteDetailVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.bo.AbstractServicioBO;
import xeredi.integra.model.servicio.dao.manifiesto.BlDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoBO.
 */
public final class ManifiestoBO extends AbstractServicioBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final ServicioVO srvcVO,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
        final BlDAO blDAO = session.getMapper(BlDAO.class);

        final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        srvcCriterio.setId(srvcVO.getId());
        ssrvCriterio.setSrvc(srvcCriterio);

        // blDAO.updateRecalcularEstado(ssrvCriterio);
        // blDAO.updateRecalcularTipoIva(ssrvCriterio);

        // TODO Recalcular estado manifiesto
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final Long srvcId) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void statechangePostOperations(final @NonNull SqlSession session, final @NonNull ServicioVO srvc,
            final @NonNull TramiteDetailVO trmtDetail) throws ModelException {
        Preconditions.checkNotNull(srvc.getId());
        Preconditions.checkNotNull(trmtDetail.getTrmt());
        Preconditions.checkNotNull(trmtDetail.getTrmt().getEstadoDest());

        final ManifiestoSubservicioDAO maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
        final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        srvcCriterio.setId(srvc.getId());
        ssrvCriterio.setSrvc(srvcCriterio);

        switch (trmtDetail.getTrmt().getEstadoDest()) {
        case "B":
            maniSsrvDAO.updateBloquear(ssrvCriterio);

            break;
        case "C":
            maniSsrvDAO.updateCompletar(ssrvCriterio);

            break;
        case "I":
            maniSsrvDAO.updateIniciar(ssrvCriterio);

            break;
        case "A":
            maniSsrvDAO.updateAnular(ssrvCriterio);

            break;
        default:
            throw new Error("Estado desconocido de manifiesto: " + trmtDetail.getTrmt().getEstadoDest());
        }
    }

    /**
     * Select resumen.
     *
     * @param maniId
     *            the mani id
     * @return the resumen totales vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ResumenTotalesVO selectResumen(final Long maniId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ManifiestoResumenDAO resumenDAO = session.getMapper(ManifiestoResumenDAO.class);
            final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

            totalCriterioVO.setManiId(maniId);

            final ResumenTotalesVO totalVO = resumenDAO.selectObject(totalCriterioVO);

            if (totalVO == null) {
                throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(), totalCriterioVO);
            }

            return totalVO;
        }
    }
}
