package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoDAO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class AspectoService {

	/** The aspc DAO. */
	@Inject
	private AspectoDAO aspcDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Select list.
	 *
	 * @param aspcCriterioVO
	 *            the aspc criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public final PaginatedList<AspectoVO> selectList(AspectoCriterioVO aspcCriterioVO, int offset, int limit) {
		Preconditions.checkArgument(offset >= 0);
		Preconditions.checkArgument(limit > 0);

		final int count = aspcDAO.count(aspcCriterioVO);

		return new PaginatedList<AspectoVO>(
				count > offset ? aspcDAO.selectList(aspcCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param aspcCriterioVO
	 *            the aspc criterio VO
	 * @return the list
	 */
	public final List<AspectoVO> selectList(AspectoCriterioVO aspcCriterioVO) {
		return aspcDAO.selectList(aspcCriterioVO);
	}

	/**
	 * Select typeahead list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	public final List<AspectoVO> selectTypeaheadList(AspectoCriterioVO criterio, int limit) {
		criterio.setTextoBusqueda("%" + criterio.getTextoBusqueda() + "%");

		if (criterio.getFechaVigencia() == null) {
			criterio.setFechaVigencia(Calendar.getInstance().getTime());
		}

		return aspcDAO.selectList(criterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param fref
	 *            the fref
	 * @param idioma
	 *            the idioma
	 * @return the aspecto VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final AspectoVO select(Long id, Date fref, String idioma) throws InstanceNotFoundException {
		final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

		aspcCriterio.setId(id);
		aspcCriterio.setFechaVigencia(fref);
		aspcCriterio.setIdioma(idioma);

		final AspectoVO aspc = selectObject(aspcCriterio);

		if (aspc == null) {
			throw new InstanceNotFoundException(MessageI18nKey.aspc, id);
		}

		return aspc;
	}

	/**
	 * Select object.
	 *
	 * @param aspcCriterio
	 *            the aspc criterio
	 * @return the aspecto VO
	 */
	public final AspectoVO selectObject(AspectoCriterioVO aspcCriterio) {
		return aspcDAO.selectObject(aspcCriterio);
	}

	/**
	 * Insert.
	 *
	 * @param aspc
	 *            the aspc
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public final void insert(AspectoVO aspc, Map<String, I18nVO> i18nMap) throws OverlapException {
		Preconditions.checkNotNull(aspc.getVersion());
		Preconditions.checkNotNull(aspc.getVersion().getFini());
		Preconditions.checkNotNull(aspc.getTpsr());
		Preconditions.checkNotNull(aspc.getTpsr().getId());

		DateUtil.truncTime(aspc.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(aspc.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (aspcDAO.exists(aspc)) {
			aspc.setId(aspcDAO.selectId(aspc));

			if (aspcDAO.existsOverlap(aspc)) {
				throw new OverlapException(MessageI18nKey.aspc, aspc);
			}
		} else {
			IgUtilBO.assignNextVal(aspc);

			aspcDAO.insert(aspc);
		}

		IgUtilBO.assignNextVal(aspc.getVersion());
		aspcDAO.insertVersion(aspc);
		i18nService.insertMap(aspc, i18nMap);
	}

	/**
	 * Duplicate.
	 *
	 * @param aspc
	 *            the aspc
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public final void duplicate(AspectoVO aspc, Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
		Preconditions.checkNotNull(aspc.getVersion());

		DateUtil.truncTime(aspc.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(aspc.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (aspcDAO.exists(aspc)) {
			throw new DuplicateInstanceException(MessageI18nKey.aspc, aspc);
		}

		IgUtilBO.assignNextVal(aspc);
		IgUtilBO.assignNextVal(aspc.getVersion());

		aspcDAO.insert(aspc);
		aspcDAO.insertVersion(aspc);

		i18nService.insertMap(aspc, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param aspc
	 *            the aspc
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public final void update(AspectoVO aspc, Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException, OverlapException {
		Preconditions.checkNotNull(aspc.getVersion());
		Preconditions.checkNotNull(aspc.getId());
		Preconditions.checkNotNull(aspc.getVersion().getId());

		DateUtil.truncTime(aspc.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(aspc.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (aspcDAO.existsOverlap(aspc)) {
			throw new OverlapException(MessageI18nKey.aspc, aspc);
		}

		final int updated = aspcDAO.updateVersion(aspc);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.aspc, aspc);
		}

		i18nService.updateMap(aspc, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param aspc
	 *            the aspc
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final void delete(AspectoVO aspc) throws InstanceNotFoundException {
		Preconditions.checkNotNull(aspc.getVersion().getId());

		i18nService.deleteMap(aspc);

		if (aspcDAO.deleteVersion(aspc) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.aspc, aspc);
		}
	}
}
