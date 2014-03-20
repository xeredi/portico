package xeredi.integra.model.bo.proceso;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.comun.IgBO;
import xeredi.integra.model.dao.proceso.ProcesoArchivoDAO;
import xeredi.integra.model.dao.proceso.ProcesoDAO;
import xeredi.integra.model.dao.proceso.ProcesoItemDAO;
import xeredi.integra.model.dao.proceso.ProcesoMensajeDAO;
import xeredi.integra.model.dao.proceso.ProcesoParametroDAO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.proceso.ArchivoSentido;
import xeredi.integra.model.vo.proceso.ItemSentido;
import xeredi.integra.model.vo.proceso.ProcesoArchivoVO;
import xeredi.integra.model.vo.proceso.ProcesoCriterioVO;
import xeredi.integra.model.vo.proceso.ProcesoEstado;
import xeredi.integra.model.vo.proceso.ProcesoItemVO;
import xeredi.integra.model.vo.proceso.ProcesoMensajeVO;
import xeredi.integra.model.vo.proceso.ProcesoModulo;
import xeredi.integra.model.vo.proceso.ProcesoParametroVO;
import xeredi.integra.model.vo.proceso.ProcesoTipo;
import xeredi.integra.model.vo.proceso.ProcesoVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoBO.
 */
@Singleton
public class ProcesoBO implements Proceso {

    /** The prbt dao. */
    @Inject
    ProcesoDAO prbtDAO;

    /** The prpm dao. */
    @Inject
    ProcesoParametroDAO prpmDAO;

    /** The prar dao. */
    @Inject
    ProcesoArchivoDAO prarDAO;

    /** The prit dao. */
    @Inject
    ProcesoItemDAO pritDAO;

    /** The prmn dao. */
    @Inject
    ProcesoMensajeDAO prmnDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void crear(final ProcesoVO prbtVO) {
        Preconditions.checkNotNull(prbtVO);

        final IgBO igBO = new IgBO();

        prbtVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
        prbtDAO.insert(prbtVO);

        for (final String prpmNombre : prbtVO.getPrpmMap().keySet()) {
            final ProcesoParametroVO prpmVO = new ProcesoParametroVO();

            prpmVO.setPrbtId(prbtVO.getId());
            prpmVO.setNombre(prpmNombre);
            prpmVO.setValor(prbtVO.getPrpmMap().get(prpmNombre));

            prpmDAO.insert(prpmVO);
        }

        for (final ProcesoArchivoVO prarVO : prbtVO.getPrarEntradaList()) {
            prarVO.setPrbtId(prbtVO.getId());
            prarVO.setSentido(ArchivoSentido.E);

            prarDAO.insert(prarVO);
        }

        for (final ProcesoItemVO pritVO : prbtVO.getPritEntradaList()) {
            pritVO.setPrbtId(prbtVO.getId());
            pritVO.setSentido(ItemSentido.E);

            pritDAO.insert(pritVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public ProcesoVO proteger(final ProcesoModulo modulo, final ProcesoTipo tipo) {
        Preconditions.checkNotNull(modulo);
        Preconditions.checkNotNull(tipo);

        final ProcesoCriterioVO prbtCriterioVO = new ProcesoCriterioVO();

        prbtCriterioVO.setEstado(ProcesoEstado.C);
        prbtCriterioVO.setModulo(modulo);
        prbtCriterioVO.setTipo(tipo);

        final ProcesoVO prbtVO = prbtDAO.selectObject(prbtCriterioVO);

        if (prbtVO != null) {
            prbtDAO.updateIniciar(prbtVO.getId());

            prbtVO.getPrarEntradaList().addAll(prarDAO.selectList(prbtVO.getId()));
            prbtVO.getPritEntradaList().addAll(pritDAO.selectList(prbtVO.getId()));

            final List<ProcesoParametroVO> prpmList = prpmDAO.selectList(prbtVO.getId());

            for (final ProcesoParametroVO prpmVO : prpmList) {
                prbtVO.getPrpmMap().put(prpmVO.getNombre(), prpmVO.getValor());
            }
        }

        return prbtVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void finalizar(final ProcesoVO prbtVO) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(prbtVO);

        final ProcesoVO prbtActualVO = prbtDAO.select(prbtVO.getId());

        if (prbtActualVO == null) {
            throw new InstanceNotFoundException(ProcesoVO.class.getName(), prbtVO.getId());
        }

        if (prbtActualVO.getEstado() != ProcesoEstado.E) {
            throw new OperacionNoPermitidaException(ProcesoVO.class.getName(), prbtVO.getId());
        }

        prbtDAO.updateFinalizar(prbtVO.getId());

        for (final ProcesoArchivoVO prarVO : prbtVO.getPrarSalidaList()) {
            prarVO.setPrbtId(prbtVO.getId());
            prarVO.setSentido(ArchivoSentido.S);

            prarDAO.insert(prarVO);
        }

        for (final ProcesoItemVO pritVO : prbtVO.getPritSalidaList()) {
            pritVO.setPrbtId(prbtVO.getId());
            pritVO.setSentido(ItemSentido.S);

            pritDAO.insert(pritVO);
        }

        for (final ProcesoMensajeVO prmnVO : prbtVO.getPrmnList()) {
            prmnVO.setPrbtId(prbtVO.getId());

            prmnDAO.insert(prmnVO);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void cancelar(final Long prbtId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(prbtId);

        final ProcesoVO prbtVO = prbtDAO.select(prbtId);

        if (prbtVO == null) {
            throw new InstanceNotFoundException(ProcesoVO.class.getName(), prbtId);
        }

        if (prbtVO.getEstado() == ProcesoEstado.E) {
            throw new OperacionNoPermitidaException(ProcesoVO.class.getName(), prbtVO);
        }

        prarDAO.delete(prbtId);
        pritDAO.delete(prbtId);
        prmnDAO.delete(prbtId);
        prpmDAO.delete(prbtId);

        prbtDAO.delete(prbtId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(prbtCriterioVO);

        final int count = prbtDAO.selectCount(prbtCriterioVO);
        final List<ProcesoVO> prbtList = new ArrayList<>();

        if (count > offset) {
            prbtList.addAll(prbtDAO.selectList(prbtCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<>(prbtList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final List<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO) {
        return prbtDAO.selectList(prbtCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final ProcesoVO select(final Long prbtId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prbtId);

        final ProcesoVO prbtVO = prbtDAO.select(prbtId);

        if (prbtVO == null) {
            throw new InstanceNotFoundException(ProcesoVO.class.getName(), prbtId);
        }

        final List<ProcesoArchivoVO> prarList = prarDAO.selectList(prbtId);

        for (final ProcesoArchivoVO prarVO : prarList) {
            if (prarVO.getSentido() == ArchivoSentido.E) {
                prbtVO.getPrarEntradaList().add(prarVO);
            } else {
                prbtVO.getPrarSalidaList().add(prarVO);
            }
        }

        final List<ProcesoItemVO> pritList = pritDAO.selectList(prbtId);

        for (final ProcesoItemVO pritVO : pritList) {
            if (pritVO.getSentido() == ItemSentido.E) {
                prbtVO.getPritEntradaList().add(pritVO);
            } else {
                prbtVO.getPritSalidaList().add(pritVO);
            }
        }

        prbtVO.getPrmnList().addAll(prmnDAO.selectList(prbtId));

        final List<ProcesoParametroVO> prpmList = prpmDAO.selectList(prbtId);

        for (final ProcesoParametroVO prpmVO : prpmList) {
            prbtVO.getPrpmMap().put(prpmVO.getNombre(), prpmVO.getValor());
        }

        return prbtVO;
    }
}
