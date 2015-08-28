package xeredi.integra.model.proceso.bo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.dao.ArchivoDAO;
import xeredi.integra.model.comun.dao.ArchivoInfoDAO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.ArchivoSentido;
import xeredi.integra.model.comun.vo.ArchivoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.proceso.dao.ProcesoArchivoDAO;
import xeredi.integra.model.proceso.dao.ProcesoDAO;
import xeredi.integra.model.proceso.dao.ProcesoItemDAO;
import xeredi.integra.model.proceso.dao.ProcesoMensajeDAO;
import xeredi.integra.model.proceso.dao.ProcesoParametroDAO;
import xeredi.integra.model.proceso.vo.ItemSentido;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoEstado;
import xeredi.integra.model.proceso.vo.ProcesoItemCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;
import xeredi.integra.model.proceso.vo.ProcesoParametroVO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.integra.model.util.GzipUtil;
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
     * @param tipo
     *            the tipo
     * @param parametroMap
     *            the parametro map
     * @param itemEntradaTipo
     *            the item entrada tipo
     * @param itemEntradaList
     *            the item entrada list
     * @param fileEntrada
     *            the file entrada
     * @return the proceso vo
     */
    public final ProcesoVO crear(final ProcesoTipo tipo, final Map<String, String> parametroMap,
            final ItemTipo itemEntradaTipo, final List<Long> itemEntradaList, final File fileEntrada) {
        // Lectura del Archivo (si lo hay)
        byte[] buffer = null;

        try {
            buffer = GzipUtil.compress(fileEntrada);
        } catch (final IOException ex) {
            throw new Error(ex);
        }

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoParametroDAO prpmDAO = session.getMapper(ProcesoParametroDAO.class);
            final ArchivoDAO archDAO = session.getMapper(ArchivoDAO.class);

            final IgBO igBO = new IgBO();
            final ProcesoVO prbt = new ProcesoVO();

            prbt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            prbt.setModulo(tipo.getModulo());
            prbt.setTipo(tipo);
            prbt.setEstado(ProcesoEstado.C);

            prbtDAO.insert(prbt);

            if (parametroMap != null) {
                for (final String prpmNombre : parametroMap.keySet()) {
                    final ProcesoParametroVO prpm = new ProcesoParametroVO();

                    prpm.setPrbtId(prbt.getId());
                    prpm.setNombre(prpmNombre);
                    prpm.setValor(parametroMap.get(prpmNombre));

                    prpmDAO.insert(prpm);
                }
            }

            if (itemEntradaList != null) {
                for (final Long itemId : itemEntradaList) {
                    final ProcesoItemVO prit = new ProcesoItemVO();

                    prit.setPrbtId(prbt.getId());
                    prit.setSentido(ItemSentido.E);
                    prit.setItemId(itemId);
                    prit.setTipo(itemEntradaTipo);

                    pritDAO.insert(prit);
                }
            }

            if (buffer != null) {
                final ArchivoVO arch = new ArchivoVO();
                final ArchivoInfoVO arin = new ArchivoInfoVO();
                final ProcesoArchivoVO prar = new ProcesoArchivoVO();

                arin.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                arin.setNombre(fileEntrada.getName());
                arin.setSentido(ArchivoSentido.E);
                arin.setTamanio((int) fileEntrada.length());
                arin.setFalta(Calendar.getInstance().getTime());

                arch.setArin(arin);
                arch.setArchivo(buffer);

                prar.setPrbtId(prbt.getId());
                prar.setArchId(arin.getId());

                archDAO.insert(arch);
                prarDAO.insert(prar);
            }

            session.commit();

            return prbt;
        }
    }

    /**
     * Proteger.
     *
     * @param tipo
     *            the tipo
     * @return the proceso vo
     */
    public ProcesoVO proteger(final ProcesoTipo tipo) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);

            final ProcesoCriterioVO prbtCriterioVO = new ProcesoCriterioVO();

            prbtCriterioVO.setEstado(ProcesoEstado.C);
            prbtCriterioVO.setModulo(tipo.getModulo());
            prbtCriterioVO.setTipo(tipo);

            final List<ProcesoVO> prbtList = prbtDAO.selectList(prbtCriterioVO,
                    new RowBounds(RowBounds.NO_ROW_OFFSET, 1));

            if (!prbtList.isEmpty()) {
                final ProcesoVO prbtVO = prbtList.get(0);

                prbtDAO.updateIniciar(prbtVO.getId());

                session.commit();

                return prbtVO;
            }
        }

        return null;
    }

    /**
     * Finalizar.
     *
     * @param prbtId
     *            the prbt id
     * @param prmnList
     *            the prmn list
     * @param itemSalidaTipo
     *            the item salida tipo
     * @param itemSalidaList
     *            the item salida list
     * @param fileSalida
     *            the file salida
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void finalizar(final Long prbtId, final List<ProcesoMensajeVO> prmnList, final ItemTipo itemSalidaTipo,
            final List<Long> itemSalidaList, final File fileSalida)
                    throws InstanceNotFoundException, OperacionNoPermitidaException {
        // Lectura del Archivo (si lo hay)
        byte[] buffer = null;

        try {
            buffer = GzipUtil.compress(fileSalida);
        } catch (final IOException ex) {
            throw new Error(ex);
        }

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoMensajeDAO prmnDAO = session.getMapper(ProcesoMensajeDAO.class);
            final ArchivoDAO archDAO = session.getMapper(ArchivoDAO.class);

            final IgBO igBO = new IgBO();

            final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

            prbtCriterio.setId(prbtId);

            final ProcesoVO prbt = prbtDAO.selectObject(prbtCriterio);

            if (prbt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prbt, prbtId);
            }

            if (prbt.getEstado() != ProcesoEstado.E) {
                throw new OperacionNoPermitidaException(MessageI18nKey.prbt, MessageI18nKey.prbt_finalizar, prbtId);
            }

            prbtDAO.updateFinalizar(prbtId);

            if (prmnList != null) {
                for (final ProcesoMensajeVO prmn : prmnList) {
                    prmn.setPrbtId(prbtId);

                    prmnDAO.insert(prmn);
                }
            }

            if (itemSalidaList != null) {
                for (final Long itemId : itemSalidaList) {
                    final ProcesoItemVO prit = new ProcesoItemVO();

                    prit.setPrbtId(prbtId);
                    prit.setItemId(itemId);
                    prit.setSentido(ItemSentido.S);
                    prit.setTipo(itemSalidaTipo);

                    pritDAO.insert(prit);
                }
            }

            if (buffer != null) {
                final ArchivoVO arch = new ArchivoVO();
                final ArchivoInfoVO arin = new ArchivoInfoVO();
                final ProcesoArchivoVO prar = new ProcesoArchivoVO();

                arin.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                arin.setNombre(fileSalida.getName());
                arin.setSentido(ArchivoSentido.S);
                arin.setTamanio((int) fileSalida.length());
                arin.setFalta(Calendar.getInstance().getTime());

                arch.setArin(arin);
                arch.setArchivo(buffer);

                prar.setPrbtId(prbt.getId());
                prar.setArchId(arin.getId());

                archDAO.insert(arch);
                prarDAO.insert(prar);
            }

            session.commit();
        }
    }

    /**
     * Cancelar.
     *
     * @param prbt
     *            the prbt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void cancelar(final @NonNull ProcesoVO prbt)
            throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(prbt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

            prbtCriterio.setId(prbt.getId());

            final ProcesoVO prbtVO = prbtDAO.selectObject(prbtCriterio);

            if (prbtVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prbt, prbt);
            }

            if (prbtVO.getEstado() == ProcesoEstado.E) {
                throw new OperacionNoPermitidaException(MessageI18nKey.prbt, MessageI18nKey.prbt_cancelar, prbtVO);
            }

            final ProcesoMensajeDAO prmnDAO = session.getMapper(ProcesoMensajeDAO.class);
            final ProcesoMensajeCriterioVO prmnCriterio = new ProcesoMensajeCriterioVO();

            prmnCriterio.setPrbtId(prbt.getId());

            prmnDAO.deleteList(prmnCriterio);

            final ProcesoArchivoDAO prarDAO = session.getMapper(ProcesoArchivoDAO.class);

            prarDAO.deleteList(prbtCriterio);

            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

            pritCriterio.setPrbtId(prbt.getId());

            pritDAO.deleteList(pritCriterio);

            final ProcesoParametroDAO prpmDAO = session.getMapper(ProcesoParametroDAO.class);

            prpmDAO.deleteList(prbtCriterio);
            prbtDAO.delete(prbt);

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
    public final PaginatedList<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final int count = prbtDAO.count(prbtCriterioVO);
            final List<ProcesoVO> prbtList = new ArrayList<>();

            if (count > offset) {
                prbtList.addAll(prbtDAO.selectList(prbtCriterioVO, new RowBounds(offset, limit)));
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
    public final List<ProcesoVO> selectList(final ProcesoCriterioVO prbtCriterioVO) {
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
    public final ProcesoVO select(final @NonNull Long prbtId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoDAO prbtDAO = session.getMapper(ProcesoDAO.class);
            final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

            prbtCriterio.setId(prbtId);

            final ProcesoVO prbt = prbtDAO.selectObject(prbtCriterio);

            if (prbt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prbt, prbtId);
            }

            return prbt;
        }
    }

    /**
     * Select prmn list.
     *
     * @param criterio
     *            the criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ProcesoMensajeVO> selectPrmnList(final ProcesoMensajeCriterioVO criterio, final int offset,
            final int limit) {
        Preconditions.checkNotNull(criterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoMensajeDAO prmnDAO = session.getMapper(ProcesoMensajeDAO.class);
            final List<ProcesoMensajeVO> prmnList = new ArrayList<>();
            final int count = prmnDAO.count(criterio);

            if (count >= offset) {
                prmnList.addAll(prmnDAO.selectList(criterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ProcesoMensajeVO>(prmnList, offset, limit, count);
        }
    }

    /**
     * Select prpm map.
     *
     * @param prbtId
     *            the prbt id
     * @return the map
     */
    public Map<String, ProcesoParametroVO> selectPrpmMap(final @NonNull Long prbtId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoParametroDAO prpmDAO = session.getMapper(ProcesoParametroDAO.class);
            final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

            prbtCriterio.setId(prbtId);

            final List<ProcesoParametroVO> prpmList = prpmDAO.selectList(prbtCriterio);
            final Map<String, ProcesoParametroVO> prpmMap = new HashMap<>();

            for (final ProcesoParametroVO prpm : prpmList) {
                prpmMap.put(prpm.getNombre(), prpm);
            }

            return prpmMap;
        }
    }

    /**
     * Select prar entrada list.
     *
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    public List<ArchivoInfoVO> selectArinEntradaList(final Long prbtId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoInfoDAO arinDAO = session.getMapper(ArchivoInfoDAO.class);
            final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

            archCriterio.setPrbtId(prbtId);
            archCriterio.setSentido(ArchivoSentido.E);

            return arinDAO.selectList(archCriterio);
        }
    }

    /**
     * Select prar salida list.
     *
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    public List<ArchivoInfoVO> selectArinSalidaList(final Long prbtId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoInfoDAO arinDAO = session.getMapper(ArchivoInfoDAO.class);
            final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

            archCriterio.setPrbtId(prbtId);
            archCriterio.setSentido(ArchivoSentido.S);

            return arinDAO.selectList(archCriterio);
        }
    }

    /**
     * Select prit entrada list.
     *
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    public List<ProcesoItemVO> selectPritEntradaList(final Long prbtId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

            pritCriterio.setPrbtId(prbtId);
            pritCriterio.setSentido(ItemSentido.E);

            return pritDAO.selectList(pritCriterio);
        }
    }

    /**
     * Select prit salida list.
     *
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    public List<ProcesoItemVO> selectPritSalidaList(final Long prbtId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ProcesoItemDAO pritDAO = session.getMapper(ProcesoItemDAO.class);
            final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

            pritCriterio.setPrbtId(prbtId);
            pritCriterio.setSentido(ItemSentido.S);

            return pritDAO.selectList(pritCriterio);
        }
    }

}
