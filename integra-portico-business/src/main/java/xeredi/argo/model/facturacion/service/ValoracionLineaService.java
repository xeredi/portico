package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoDAO;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ValoracionLineaService {

	/** The vlrc DAO. */
	@Inject
	private ValoracionDAO vlrcDAO;

	/** The vlrl DAO. */
	@Inject
	private ValoracionLineaDAO vlrlDAO;

	/** The vlrd DAO. */
	@Inject
	private ValoracionDetalleDAO vlrdDAO;

	/** The rgla DAO. */
	@Inject
	private ReglaDAO rglaDAO;

	/** The aspc DAO. */
	@Inject
	private AspectoDAO aspcDAO;

	/** The ssrv DAO. */
	@Inject
	private SubservicioDAO ssrvDAO;

	/**
	 * Select object.
	 *
	 * @param vlrlCriterio
	 *            the vlrl criterio
	 * @return the valoracion linea VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ValoracionLineaVO selectObject(@NonNull final ValoracionLineaCriterioVO vlrlCriterio)
			throws InstanceNotFoundException {
		final ValoracionLineaVO vlrl = vlrlDAO.selectObject(vlrlCriterio);

		if (vlrl == null) {
			throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrlCriterio);
		}

		return vlrl;
	}

	/**
	 * Exists hija.
	 *
	 * @param vlrlId
	 *            the vlrl id
	 * @return true, if successful
	 */
	public boolean existsHija(@NonNull final Long vlrlId) {
		return vlrlDAO.existsDependencia(vlrlId);
	}

	/**
	 * Select list.
	 *
	 * @param vlrlCriterio
	 *            the vlrl criterio
	 * @return the list
	 */
	public List<ValoracionLineaVO> selectList(@NonNull final ValoracionLineaCriterioVO vlrlCriterio) {
		return vlrlDAO.selectList(vlrlCriterio);
	}

	/**
	 * Select list.
	 *
	 * @param vlrlCriterio
	 *            the vlrl criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ValoracionLineaVO> selectList(@NonNull final ValoracionLineaCriterioVO vlrlCriterio,
			int offset, int limit) {
		final int count = vlrlDAO.count(vlrlCriterio);

		return new PaginatedList<ValoracionLineaVO>(
				count > offset ? vlrlDAO.selectList(vlrlCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Insert.
	 *
	 * @param vlrl
	 *            the vlrl
	 */
	public void insert(@NonNull final ValoracionLineaVO vlrl) {
		Preconditions.checkNotNull(vlrl.getVlrcId());
		Preconditions.checkNotNull(vlrl.getRgla());
		Preconditions.checkNotNull(vlrl.getRgla().getId());
		Preconditions.checkNotNull(vlrl.getImpuesto());
		Preconditions.checkNotNull(vlrl.getImpuesto().getId());

		// Validacion de datos
		final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

		vlrcCriterio.setId(vlrl.getVlrcId());

		final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

		if (vlrc == null) {
			throw new Error("Valoracion no encontrada: " + vlrl.getVlrcId());
		}

		if (!vlrlDAO.isRglaValida(vlrl)) {
			throw new Error("Regla no valida para el aspecto de la valoracion");
		}

		final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

		rglaCriterioVO.setId(vlrl.getRgla().getId());
		rglaCriterioVO.setFechaVigencia(vlrc.getFref());

		final ReglaVO rgla = rglaDAO.selectObject(rglaCriterioVO);

		if (rgla == null) {
			throw new Error("Regla no encontrada: " + vlrl.getRgla());
		}

		if (rgla.getTipo() != ReglaTipo.T) {
			Preconditions.checkNotNull(vlrl.getPadreId());
		}

		final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

		aspcCriterio.setId(vlrc.getAspc().getId());
		aspcCriterio.setFechaVigencia(vlrc.getFref());

		final AspectoVO aspc = aspcDAO.selectObject(aspcCriterio);
		final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

		// ssrvCriterioVO.setFechaVigencia(vlrc.getFref());

		if (rgla.getEnti().getTipo() == TipoEntidad.S) {
			if (!aspc.getVersion().isAgrupaDetalles()) {
				Preconditions.checkNotNull(vlrl.getSsrv());
				Preconditions.checkNotNull(vlrl.getSsrv().getId());

				ssrvCriterioVO.setId(vlrl.getSsrv().getId());

				final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterioVO);

				if (ssrv.getEntiId() != rgla.getEnti().getId()) {
					throw new Error("Subservicio no valido para la regla");
				}
			}
		}

		// Grabacion de datos

		IgUtilBO.assignNextVal(vlrl);

		if (rgla.getTipo() == ReglaTipo.T) {
			vlrl.setPadreId(vlrl.getId());
		}

		vlrlDAO.insert(vlrl);
		vlrcDAO.updateImporte(vlrl.getVlrcId());
	}

	/**
	 * Update.
	 *
	 * @param vlrl
	 *            the vlrl
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final ValoracionLineaVO vlrl) throws InstanceNotFoundException {
		Preconditions.checkNotNull(vlrl.getId());
		Preconditions.checkNotNull(vlrl.getVlrcId());

		final int updated = vlrlDAO.update(vlrl);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrl.getId());
		}

		vlrcDAO.updateImporte(vlrl.getVlrcId());
	}

	/**
	 * Delete.
	 *
	 * @param vlrl
	 *            the vlrl
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final ValoracionLineaVO vlrl) throws InstanceNotFoundException {
		Preconditions.checkNotNull(vlrl.getId());
		Preconditions.checkNotNull(vlrl.getVlrcId());

		if (vlrlDAO.existsDependencia(vlrl.getId())) {
			throw new Error("No se puede borrar la linea '" + vlrl.getId() + "' porque tiene lineas dependientes");
		}

		final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

		vlrdCriterio.setVlrlId(vlrl.getId());
		vlrdCriterio.setVlrcId(vlrl.getVlrcId());

		vlrdDAO.deleteList(vlrdCriterio);

		final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

		vlrlCriterio.setId(vlrl.getId());
		vlrlCriterio.setVlrcId(vlrl.getVlrcId());

		if (vlrlDAO.deleteList(vlrlCriterio) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrl.getId());
		}

		vlrcDAO.updateImporte(vlrl.getVlrcId());
	}

}
