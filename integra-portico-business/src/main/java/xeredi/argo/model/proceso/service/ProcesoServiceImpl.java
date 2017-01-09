package xeredi.argo.model.proceso.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

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

@Transactional(executorType = ExecutorType.BATCH)
public class ProcesoServiceImpl implements ProcesoService {

	@Inject
	private ProcesoDAO prbtDAO;

	@Inject
	private ProcesoItemDAO pritDAO;

	@Inject
	private ProcesoParametroDAO prpmDAO;

	@Inject
	private ProcesoMensajeDAO prmnDAO;

	@Inject
	private ArchivoInfoDAO arinDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<ProcesoVO> selectList(ProcesoCriterioVO prbtCriterioVO, int offset, int limit) {
		final int count = prbtDAO.count(prbtCriterioVO);

		return new PaginatedList<>(
				count > offset ? prbtDAO.selectList(prbtCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProcesoVO> selectList(ProcesoCriterioVO prbtCriterioVO) {
		return prbtDAO.selectList(prbtCriterioVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<ProcesoMensajeVO> selectPrmnList(ProcesoMensajeCriterioVO criterio, int offset, int limit) {
		final int count = prmnDAO.count(criterio);

		return new PaginatedList<ProcesoMensajeVO>(
				count > offset ? prmnDAO.selectList(criterio, new RowBounds(offset, limit)) : new ArrayList<>(), offset,
				limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public List<ArchivoInfoVO> selectArinEntradaList(Long prbtId) {
		final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

		archCriterio.setPrbtId(prbtId);
		archCriterio.setSentido(ArchivoSentido.E);

		return arinDAO.selectList(archCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ArchivoInfoVO> selectArinSalidaList(Long prbtId) {
		final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

		archCriterio.setPrbtId(prbtId);
		archCriterio.setSentido(ArchivoSentido.S);

		return arinDAO.selectList(archCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProcesoItemVO> selectPritEntradaList(Long prbtId) {
		final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

		pritCriterio.setPrbtId(prbtId);
		pritCriterio.setSentido(ItemSentido.E);

		return pritDAO.selectList(pritCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProcesoItemVO> selectPritSalidaList(Long prbtId) {
		final ProcesoItemCriterioVO pritCriterio = new ProcesoItemCriterioVO();

		pritCriterio.setPrbtId(prbtId);
		pritCriterio.setSentido(ItemSentido.S);

		return pritDAO.selectList(pritCriterio);
	}
}
