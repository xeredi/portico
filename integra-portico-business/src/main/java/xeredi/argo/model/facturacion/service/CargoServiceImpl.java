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

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.CargoDAO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class CargoServiceImpl implements CargoService {

	/** The crgo DAO. */
	@Inject
	private CargoDAO crgoDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final PaginatedList<CargoVO> selectList(@NonNull final CargoCriterioVO crgoCriterioVO, int offset,
			int limit) {
		final int count = crgoDAO.count(crgoCriterioVO);

		return new PaginatedList<CargoVO>(
				count > offset ? crgoDAO.selectList(crgoCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<CargoVO> selectTypeaheadList(@NonNull final CargoCriterioVO crgoCriterio, int limit) {
		crgoCriterio.setTextoBusqueda("%" + crgoCriterio.getTextoBusqueda() + "%");

		if (crgoCriterio.getFechaVigencia() == null) {
			crgoCriterio.setFechaVigencia(Calendar.getInstance().getTime());
		}

		return crgoDAO.selectList(crgoCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<CargoVO> selectList(@NonNull final CargoCriterioVO crgoCriterioVO) {
		return crgoDAO.selectList(crgoCriterioVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final CargoVO select(@NonNull final Long id, @NonNull final Date fref, final String idioma)
			throws InstanceNotFoundException {
		final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

		crgoCriterio.setId(id);
		crgoCriterio.setFechaVigencia(fref);
		crgoCriterio.setIdioma(idioma);

		final CargoVO crgo = selectObject(crgoCriterio);

		if (crgo == null) {
			throw new InstanceNotFoundException(MessageI18nKey.crgo, id);
		}

		return crgo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final CargoVO select(@NonNull final Long versionId, final String idioma) throws InstanceNotFoundException {
		final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

		crgoCriterio.setVersionId(versionId);
		crgoCriterio.setIdioma(idioma);

		final CargoVO crgo = selectObject(crgoCriterio);

		if (crgo == null) {
			throw new InstanceNotFoundException(MessageI18nKey.crgo, versionId);
		}

		return crgo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final CargoVO selectObject(@NonNull final CargoCriterioVO crgoCriterio) {
		return crgoDAO.selectObject(crgoCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final void insert(@NonNull final CargoVO crgo, @NonNull final Map<String, I18nVO> i18nMap)
			throws OverlapException {
		Preconditions.checkNotNull(crgo.getVersion());
		Preconditions.checkNotNull(crgo.getVersion().getFini());
		Preconditions.checkNotNull(crgo.getTpsr());
		Preconditions.checkNotNull(crgo.getTpsr().getId());

		DateUtil.truncTime(crgo.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(crgo.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (crgoDAO.exists(crgo)) {
			crgo.setId(crgoDAO.selectId(crgo));

			if (crgoDAO.existsOverlap(crgo)) {
				throw new OverlapException(MessageI18nKey.crgo, crgo);
			}
		} else {
			IgUtilBO.assignNextVal(crgo);

			crgoDAO.insert(crgo);
		}

		IgUtilBO.assignNextVal(crgo.getVersion());
		crgoDAO.insertVersion(crgo);
		I18nUtil.insertMap(i18nDAO, crgo, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final void update(@NonNull final CargoVO crgo, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException, OverlapException {
		Preconditions.checkNotNull(crgo.getVersion());
		Preconditions.checkNotNull(crgo.getVersion().getId());

		DateUtil.truncTime(crgo.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(crgo.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (crgoDAO.existsOverlap(crgo)) {
			throw new OverlapException(MessageI18nKey.crgo, crgo);
		}

		final int updated = crgoDAO.updateVersion(crgo);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.crgo, crgo);
		}

		I18nUtil.updateMap(i18nDAO, crgo, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final void delete(@NonNull final CargoVO crgo) throws InstanceNotFoundException {
		Preconditions.checkNotNull(crgo.getVersion());
		Preconditions.checkNotNull(crgo.getVersion().getId());

		if (crgoDAO.deleteVersion(crgo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.crgo, crgo);
		}

		I18nUtil.deleteMap(i18nDAO, crgo);
	}
}
