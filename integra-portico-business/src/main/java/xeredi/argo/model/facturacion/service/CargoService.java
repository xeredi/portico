package xeredi.argo.model.facturacion.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nService;
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
public class CargoService {

	/** The crgo DAO. */
	@Inject
	private CargoDAO crgoDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Select list.
	 *
	 * @param crgoCriterioVO
	 *            the crgo criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public final PaginatedList<CargoVO> selectList(@NonNull final CargoCriterioVO crgoCriterioVO, int offset,
			int limit) {
		final int count = crgoDAO.count(crgoCriterioVO);

		return new PaginatedList<CargoVO>(
				count > offset ? crgoDAO.selectList(crgoCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select typeahead list.
	 *
	 * @param crgoCriterio
	 *            the crgo criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	public final List<CargoVO> selectTypeaheadList(@NonNull final CargoCriterioVO crgoCriterio, int limit) {
		crgoCriterio.setTextoBusqueda("%" + crgoCriterio.getTextoBusqueda() + "%");

		if (crgoCriterio.getFechaVigencia() == null) {
			crgoCriterio.setFechaVigencia(Calendar.getInstance().getTime());
		}

		return crgoDAO.selectList(crgoCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
	}

	/**
	 * Select list.
	 *
	 * @param crgoCriterioVO
	 *            the crgo criterio VO
	 * @return the list
	 */
	public final List<CargoVO> selectList(@NonNull final CargoCriterioVO crgoCriterioVO) {
		return crgoDAO.selectList(crgoCriterioVO);
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
	 * @return the cargo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
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
	 * Select.
	 *
	 * @param versionId
	 *            the version id
	 * @param idioma
	 *            the idioma
	 * @return the cargo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
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
	 * Select object.
	 *
	 * @param crgoCriterio
	 *            the crgo criterio
	 * @return the cargo VO
	 */
	public final CargoVO selectObject(@NonNull final CargoCriterioVO crgoCriterio) {
		return crgoDAO.selectObject(crgoCriterio);
	}

	/**
	 * Insert.
	 *
	 * @param crgo
	 *            the crgo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
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
		i18nService.insertMap(crgo, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param crgo
	 *            the crgo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
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

		i18nService.updateMap(crgo, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param crgo
	 *            the crgo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final void delete(@NonNull final CargoVO crgo) throws InstanceNotFoundException {
		Preconditions.checkNotNull(crgo.getVersion());
		Preconditions.checkNotNull(crgo.getVersion().getId());

		if (crgoDAO.deleteVersion(crgo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.crgo, crgo);
		}

		i18nService.deleteMap(crgo);
	}
}
