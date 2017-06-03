package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ValoracionService {

	/** The vlrc DAO. */
	@Inject
	private ValoracionDAO vlrcDAO;

	/** The vlrl DAO. */
	@Inject
	private ValoracionLineaDAO vlrlDAO;

	/** The vlrd DAO. */
	@Inject
	private ValoracionDetalleDAO vlrdDAO;

	/**
	 * Insert.
	 *
	 * @param vlrc
	 *            the vlrc
	 */
	public void insert(@NonNull final ValoracionVO vlrc) {
		IgUtilBO.assignNextVal(vlrc);

		vlrcDAO.insert(vlrc);
		vlrcDAO.updateImporte(vlrc.getId());
	}

	/**
	 * Update.
	 *
	 * @param vlrc
	 *            the vlrc
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final ValoracionVO vlrc) throws InstanceNotFoundException {
		Preconditions.checkNotNull(vlrc.getId());

		if (vlrcDAO.update(vlrc) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.vlrc, vlrc.getId());
		}

		vlrcDAO.updateImporte(vlrc.getId());
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final Long id) throws InstanceNotFoundException {
		final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

		vlrdCriterio.setVlrcId(id);
		vlrdDAO.deleteList(vlrdCriterio);

		final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

		vlrlCriterio.setVlrcId(id);
		vlrlDAO.deleteList(vlrlCriterio);

		final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

		vlrcCriterioVO.setId(id);
		vlrcDAO.deleteList(vlrcCriterioVO);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the valoracion VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ValoracionVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

		vlrcCriterio.setId(id);
		vlrcCriterio.setIdioma(idioma);

		final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

		if (vlrc == null) {
			throw new InstanceNotFoundException(MessageI18nKey.vlrc, id);
		}

		return vlrc;
	}

	/**
	 * Select list.
	 *
	 * @param vlrcCriterioVO
	 *            the vlrc criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ValoracionVO> selectList(ValoracionCriterioVO vlrcCriterioVO, int offset, int limit) {
		Preconditions.checkArgument(offset >= 0);
		Preconditions.checkArgument(limit > 0);

		final int count = vlrcDAO.count(vlrcCriterioVO);

		return new PaginatedList<ValoracionVO>(
				count > offset ? vlrcDAO.selectList(vlrcCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param vlrcCriterioVO
	 *            the vlrc criterio VO
	 * @return the list
	 */
	public List<ValoracionVO> selectList(ValoracionCriterioVO vlrcCriterioVO) {
		return vlrcDAO.selectList(vlrcCriterioVO);
	}
}
