package xeredi.argo.model.proceso.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.ArchivoInfoDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OperacionNoPermitidaException;
import xeredi.argo.model.comun.vo.ArchivoCriterioVO;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.OrderByElement.OrderByType;
import xeredi.argo.model.proceso.dao.ProcesoDAO;
import xeredi.argo.model.proceso.dao.ProcesoItemDAO;
import xeredi.argo.model.proceso.dao.ProcesoMensajeDAO;
import xeredi.argo.model.proceso.dao.ProcesoParametroDAO;
import xeredi.argo.model.proceso.vo.ItemSentido;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO.ProcesoOrderByColumn;
import xeredi.argo.model.proceso.vo.ProcesoEstado;
import xeredi.argo.model.proceso.vo.ProcesoItemCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoService.
 */
@Transactional(executorType = ExecutorType.BATCH)
public class ProcesoService {

	/** The prbt DAO. */
	@Inject
	private ProcesoDAO prbtDAO;

	/** The prit DAO. */
	@Inject
	private ProcesoItemDAO pritDAO;

	/** The prpm DAO. */
	@Inject
	private ProcesoParametroDAO prpmDAO;

	/** The prmn DAO. */
	@Inject
	private ProcesoMensajeDAO prmnDAO;

	/** The arin DAO. */
	@Inject
	private ArchivoInfoDAO arinDAO;

	/**
	 * Crear.
	 *
	 * @param usroId
	 *            the usro id
	 * @param tipo
	 *            the tipo
	 * @param parametroMap
	 *            the parametro map
	 * @param itemEntradaTipo
	 *            the item entrada tipo
	 * @param itemEntradaList
	 *            the item entrada list
	 * @return the proceso VO
	 */
	public ProcesoVO crear(Long usroId, ProcesoTipo tipo, Map<String, String> parametroMap, ItemTipo itemEntradaTipo,
			List<Long> itemEntradaList) {
		final UsuarioVO usro = new UsuarioVO();

		usro.setId(usroId);

		final ProcesoVO prbt = new ProcesoVO();

		IgUtilBO.assignNextVal(prbt);

		prbt.setUsro(usro);
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
			Preconditions.checkNotNull(itemEntradaTipo);

			for (final Long itemId : itemEntradaList) {
				final ProcesoItemVO prit = new ProcesoItemVO();

				prit.setPrbtId(prbt.getId());
				prit.setSentido(ItemSentido.E);
				prit.setItemId(itemId);
				prit.setTipo(itemEntradaTipo);

				pritDAO.insert(prit);
			}
		}

		return prbt;
	}

	/**
	 * Proteger.
	 *
	 * @param tipo
	 *            the tipo
	 * @return the proceso VO
	 */
	public ProcesoVO proteger(ProcesoTipo tipo) {
		final ProcesoCriterioVO prbtCriterioVO = new ProcesoCriterioVO();

		prbtCriterioVO.setEstado(ProcesoEstado.C);
		prbtCriterioVO.setModulo(tipo.getModulo());
		prbtCriterioVO.setTipo(tipo);
		prbtCriterioVO.addOrderBy(ProcesoOrderByColumn.prbt_falta.name(), OrderByType.ASC);

		final List<ProcesoVO> prbtList = prbtDAO.selectList(prbtCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET, 1));

		if (!prbtList.isEmpty()) {
			final ProcesoVO prbtVO = prbtList.get(0);

			prbtDAO.updateIniciar(prbtVO.getId());

			return prbtVO;
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
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OperacionNoPermitidaException
	 *             the operacion no permitida exception
	 */
	public void finalizar(Long prbtId, List<ProcesoMensajeVO> prmnList, ItemTipo itemSalidaTipo,
			List<Long> itemSalidaList) throws InstanceNotFoundException, OperacionNoPermitidaException {
		final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

		prbtCriterio.setId(prbtId);

		final ProcesoVO prbt = prbtDAO.selectObject(prbtCriterio);

		if (prbt == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prbt, prbtId);
		}

		if (prbt.getEstado() != ProcesoEstado.E) {
			throw new OperacionNoPermitidaException(MessageI18nKey.prbt, MessageI18nKey.prbt_finalizar, prbtId);
		}

		if (prmnList != null) {
			for (final ProcesoMensajeVO prmn : prmnList) {
				switch (prmn.getNivel()) {
				case E:
					prbt.setErroresCnt(prbt.getErroresCnt() + 1);

					break;
				case W:
					prbt.setAlertasCnt(prbt.getAlertasCnt() + 1);

					break;
				case I:
					prbt.setMensajesCnt(prbt.getMensajesCnt() + 1);

					break;
				default:
					throw new Error("MensajeNivel no válido: " + prmn.getNivel());
				}

				prmn.setPrbtId(prbtId);

				prmnDAO.insert(prmn);
			}
		}

		prbtDAO.updateFinalizar(prbt);

		if (itemSalidaList != null) {
			Preconditions.checkNotNull(itemSalidaTipo);

			for (final Long itemId : itemSalidaList) {
				final ProcesoItemVO prit = new ProcesoItemVO();

				prit.setPrbtId(prbtId);
				prit.setItemId(itemId);
				prit.setSentido(ItemSentido.S);
				prit.setTipo(itemSalidaTipo);

				pritDAO.insert(prit);
			}
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
	public void cancelar(ProcesoVO prbt) throws InstanceNotFoundException, OperacionNoPermitidaException {
		Preconditions.checkNotNull(prbt.getId());

		final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

		prbtCriterio.setId(prbt.getId());

		final ProcesoVO prbtVO = prbtDAO.selectObject(prbtCriterio);

		if (prbtVO == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prbt, prbt);
		}

		if (prbtVO.getEstado() == ProcesoEstado.E) {
			throw new OperacionNoPermitidaException(MessageI18nKey.prbt, MessageI18nKey.prbt_cancelar, prbtVO);
		}

		final ProcesoMensajeCriterioVO prmnCriterio = new ProcesoMensajeCriterioVO();

		prmnCriterio.setPrbtId(prbt.getId());

		prmnDAO.deleteList(prmnCriterio);

		final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

		pritCriterio.setPrbtId(prbt.getId());

		pritDAO.deleteList(pritCriterio);

		prpmDAO.deleteList(prbtCriterio);
		prbtDAO.delete(prbt);
	}

	/**
	 * Select list.
	 *
	 * @param prbtCriterioVO
	 *            the prbt criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ProcesoVO> selectList(ProcesoCriterioVO prbtCriterioVO, int offset, int limit) {
		final int count = prbtDAO.count(prbtCriterioVO);

		return new PaginatedList<>(
				count > offset ? prbtDAO.selectList(prbtCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param prbtCriterioVO
	 *            the prbt criterio VO
	 * @return the list
	 */
	public List<ProcesoVO> selectList(ProcesoCriterioVO prbtCriterioVO) {
		return prbtDAO.selectList(prbtCriterioVO);
	}

	/**
	 * Select.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the proceso VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ProcesoVO select(Long prbtId) throws InstanceNotFoundException {
		final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

		prbtCriterio.setId(prbtId);

		final ProcesoVO prbt = prbtDAO.selectObject(prbtCriterio);

		if (prbt == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prbt, prbtId);
		}

		return prbt;
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
	public PaginatedList<ProcesoMensajeVO> selectPrmnList(ProcesoMensajeCriterioVO criterio, int offset, int limit) {
		final int count = prmnDAO.count(criterio);

		return new PaginatedList<ProcesoMensajeVO>(
				count > offset ? prmnDAO.selectList(criterio, new RowBounds(offset, limit)) : new ArrayList<>(), offset,
				limit, count);
	}

	/**
	 * Select prpm map.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the map
	 */
	public Map<String, ProcesoParametroVO> selectPrpmMap(Long prbtId) {
		final ProcesoCriterioVO prbtCriterio = new ProcesoCriterioVO();

		prbtCriterio.setId(prbtId);

		final List<ProcesoParametroVO> prpmList = prpmDAO.selectList(prbtCriterio);
		final Map<String, ProcesoParametroVO> prpmMap = new HashMap<>();

		for (final ProcesoParametroVO prpm : prpmList) {
			prpmMap.put(prpm.getNombre(), prpm);
		}

		return prpmMap;
	}

	/**
	 * Select arin entrada list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	public List<ArchivoInfoVO> selectArinEntradaList(Long prbtId) {
		final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

		archCriterio.setPrbtId(prbtId);
		archCriterio.setSentido(ArchivoSentido.E);

		return arinDAO.selectList(archCriterio);
	}

	/**
	 * Select arin salida list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	public List<ArchivoInfoVO> selectArinSalidaList(Long prbtId) {
		final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

		archCriterio.setPrbtId(prbtId);
		archCriterio.setSentido(ArchivoSentido.S);

		return arinDAO.selectList(archCriterio);
	}

	/**
	 * Select prit entrada list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	public List<ProcesoItemVO> selectPritEntradaList(Long prbtId) {
		final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

		pritCriterio.setPrbtId(prbtId);
		pritCriterio.setSentido(ItemSentido.E);

		return pritDAO.selectList(pritCriterio);
	}

	/**
	 * Select prit salida list.
	 *
	 * @param prbtId
	 *            the prbt id
	 * @return the list
	 */
	public List<ProcesoItemVO> selectPritSalidaList(Long prbtId) {
		final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

		pritCriterio.setPrbtId(prbtId);
		pritCriterio.setSentido(ItemSentido.S);

		return pritDAO.selectList(pritCriterio);
	}
}
