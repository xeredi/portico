package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nUtil;
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
@Singleton
@Transactional
public class AspectoServiceImpl implements AspectoService {

	/** The aspc DAO. */
	@Inject
	private AspectoDAO aspcDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final PaginatedList<AspectoVO> selectList(AspectoCriterioVO aspcCriterioVO, int offset, int limit) {
		Preconditions.checkArgument(offset >= 0);
		Preconditions.checkArgument(limit > 0);

		final int count = aspcDAO.count(aspcCriterioVO);

		return new PaginatedList<AspectoVO>(
				count > offset ? aspcDAO.selectList(aspcCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<AspectoVO> selectList(AspectoCriterioVO aspcCriterioVO) {
		return aspcDAO.selectList(aspcCriterioVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<AspectoVO> selectTypeaheadList(AspectoCriterioVO criterio, int limit) {
		criterio.setTextoBusqueda("%" + criterio.getTextoBusqueda() + "%");

		if (criterio.getFechaVigencia() == null) {
			criterio.setFechaVigencia(Calendar.getInstance().getTime());
		}

		return aspcDAO.selectList(criterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public final AspectoVO selectObject(AspectoCriterioVO aspcCriterio) {
		return aspcDAO.selectObject(aspcCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
		I18nUtil.insertMap(i18nDAO, aspc, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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

		I18nUtil.insertMap(i18nDAO, aspc, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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

		I18nUtil.updateMap(i18nDAO, aspc, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void delete(AspectoVO aspc) throws InstanceNotFoundException {
		Preconditions.checkNotNull(aspc.getVersion().getId());

		I18nUtil.deleteMap(i18nDAO, aspc);

		if (aspcDAO.deleteVersion(aspc) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.aspc, aspc);
		}
	}
}
