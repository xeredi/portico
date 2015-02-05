package xeredi.integra.model.proceso.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.proceso.dao.ProcesoArchivoDAO;
import xeredi.integra.model.proceso.dao.ProcesoDAO;
import xeredi.integra.model.proceso.dao.ProcesoItemDAO;
import xeredi.integra.model.proceso.dao.ProcesoMensajeDAO;
import xeredi.integra.model.proceso.dao.ProcesoParametroDAO;
import xeredi.integra.model.proceso.vo.ArchivoSentido;
import xeredi.integra.model.proceso.vo.ItemSentido;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoEstado;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoParametroVO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoBO.
 */
public class ProcesoBO {
    /**
     * Crear.
     *
     * @param prbtVO
     *            the prbt vo
     */
    public final void crear(final @Nonnull ProcesoVO prbtVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoParametroDAO prpmDAO = session.getMapper(ProcesoParametroDAO.class);

            final IgBO igBO = new IgBO();

            prbtVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
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

            session.commit();
        }
    }

    /**
     * Proteger.
     *
     * @param modulo
     *            the modulo
     * @param tipo
     *            the tipo
     * @return the proceso vo
     */
    public ProcesoVO proteger(final @Nonnull ProcesoModulo modulo, final @Nonnull ProcesoTipo tipo) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoParametroDAO prpmDAO = session.getMapper(ProcesoParametroDAO.class);

            final ProcesoCriterioVO prbtCriterioVO = new ProcesoCriterioVO();

            prbtCriterioVO.setEstado(ProcesoEstado.C);
            prbtCriterioVO.setModulo(modulo);
            prbtCriterioVO.setTipo(tipo);

            final List<ProcesoVO> prbtList = prbtDAO.selectPaginatedList(prbtCriterioVO, new RowBounds(
                    RowBounds.NO_ROW_OFFSET, 1));

            if (!prbtList.isEmpty()) {
                final ProcesoVO prbtVO = prbtList.get(0);

                prbtDAO.updateIniciar(prbtVO.getId());

                prbtVO.getPrarEntradaList().addAll(prarDAO.selectList(prbtVO.getId()));
                prbtVO.getPritEntradaList().addAll(pritDAO.selectList(prbtVO.getId()));

                final List<ProcesoParametroVO> prpmList = prpmDAO.selectList(prbtVO.getId());

                for (final ProcesoParametroVO prpmVO : prpmList) {
                    prbtVO.getPrpmMap().put(prpmVO.getNombre(), prpmVO.getValor());
                }

                session.commit();

                return prbtVO;
            }
        }

        return null;
    }

    /**
     * Finalizar.
     *
     * @param prbtVO
     *            the prbt vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void finalizar(final @Nonnull ProcesoVO prbtVO) throws InstanceNotFoundException,
    OperacionNoPermitidaException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoMensajeDAO prmnDAO = session.getMapper(ProcesoMensajeDAO.class);

            final ProcesoVO prbtActualVO = prbtDAO.select(prbtVO.getId());

            if (prbtActualVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prbt, prbtVO.getId());
            }

            if (prbtActualVO.getEstado() != ProcesoEstado.E) {
                throw new OperacionNoPermitidaException(MessageI18nKey.prbt, MessageI18nKey.prbt_finalizar,
                        prbtVO.getId());
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

            session.commit();
        }
    }

    /**
     * Cancelar.
     *
     * @param prbtId
     *            the prbt id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void cancelar(final @Nonnull Long prbtId) throws InstanceNotFoundException,
            OperacionNoPermitidaException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoMensajeDAO prmnDAO = session.getMapper(ProcesoMensajeDAO.class);
            final ProcesoParametroDAO prpmDAO = session.getMapper(ProcesoParametroDAO.class);

            final ProcesoVO prbtVO = prbtDAO.select(prbtId);

            if (prbtVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prbt, prbtId);
            }

            if (prbtVO.getEstado() == ProcesoEstado.E) {
                throw new OperacionNoPermitidaException(MessageI18nKey.prbt, MessageI18nKey.prbt_cancelar, prbtVO);
            }

            prarDAO.delete(prbtId);
            pritDAO.delete(prbtId);
            prmnDAO.delete(prbtId);
            prpmDAO.delete(prbtId);
            prbtDAO.delete(prbtId);

            session.commit();
        }
    }

    /**
     * Select list.
     *
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<ProcesoVO> selectList(final @Nonnull ProcesoCriterioVO prbtCriterioVO, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final int count = prbtDAO.selectCount(prbtCriterioVO);
            final List<ProcesoVO> prbtList = new ArrayList<>();

            if (count > offset) {
                prbtList.addAll(prbtDAO.selectPaginatedList(prbtCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<>(prbtList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param prbtCriterioVO
     *            the prbt criterio vo
     * @return the list
     */
    public final List<ProcesoVO> selectList(final @Nonnull ProcesoCriterioVO prbtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);

            return prbtDAO.selectList(prbtCriterioVO);
        }
    }

    /**
     * Select.
     *
     * @param prbtId
     *            the prbt id
     * @return the proceso vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final ProcesoVO select(final @Nonnull Long prbtId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoMensajeDAO prmnDAO = session.getMapper(ProcesoMensajeDAO.class);
            final ProcesoParametroDAO prpmDAO = session.getMapper(ProcesoParametroDAO.class);

            final ProcesoVO prbtVO = prbtDAO.select(prbtId);

            if (prbtVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prbt, prbtId);
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

    /**
     * Select prmn list.
     *
     * @param prbtId
     *            the prbt id
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ProcesoMensajeVO> selectPrmnList(final @Nonnull Long prbtId, final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoMensajeDAO prmnDAO = session.getMapper(ProcesoMensajeDAO.class);
            final List<ProcesoMensajeVO> prmnList = new ArrayList<>();
            final int count = prmnDAO.count(prbtId);

            if (count >= offset) {
                prmnList.addAll(prmnDAO.selectPaginatedList(prbtId, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ProcesoMensajeVO>(prmnList, offset, limit, count);
        }
    }
}
