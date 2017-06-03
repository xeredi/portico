package xeredi.argo.model.facturacion.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ReglaIncompatibleDAO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ReglaIncompatibleService {

	/** The rgin DAO. */
	@Inject
	private ReglaIncompatibleDAO rginDAO;

	/**
	 * Insert.
	 *
	 * @param rgin
	 *            the rgin
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public void insert(ReglaIncompatibleVO rgin) throws OverlapException {
		Preconditions.checkNotNull(rgin.getRgla1Id());
		Preconditions.checkNotNull(rgin.getRgla2());
		Preconditions.checkNotNull(rgin.getRgla2().getId());
		Preconditions.checkNotNull(rgin.getVersion());
		Preconditions.checkNotNull(rgin.getVersion().getFini());

		DateUtil.truncTime(rgin.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(rgin.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (rginDAO.exists(rgin)) {
			rgin.setId(rginDAO.selectId(rgin));

			if (rginDAO.existsOverlap(rgin)) {
				throw new OverlapException(MessageI18nKey.rgin, rgin);
			}
		} else {
			IgUtilBO.assignNextVal(rgin);
			rginDAO.insert(rgin);
		}

		IgUtilBO.assignNextVal(rgin.getVersion());
		rginDAO.insertVersion(rgin);
	}

	/**
	 * Update.
	 *
	 * @param rgin
	 *            the rgin
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public void update(ReglaIncompatibleVO rgin) throws InstanceNotFoundException, OverlapException {
		Preconditions.checkNotNull(rgin.getVersion());
		Preconditions.checkNotNull(rgin.getVersion().getId());
		Preconditions.checkNotNull(rgin.getVersion().getFini());

		DateUtil.truncTime(rgin.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(rgin.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (rginDAO.existsOverlap(rgin)) {
			throw new OverlapException(MessageI18nKey.rgin, rgin);
		}

		final int updated = rginDAO.updateVersion(rgin);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.rgin, rgin);
		}
	}

	/**
	 * Delete.
	 *
	 * @param rgin
	 *            the rgin
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(ReglaIncompatibleVO rgin) throws InstanceNotFoundException {
		Preconditions.checkNotNull(rgin.getVersion());
		Preconditions.checkNotNull(rgin.getVersion().getId());

		final int updated = rginDAO.deleteVersion(rgin);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.rgin, rgin);
		}
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param fref
	 *            the fref
	 * @return the regla incompatible VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ReglaIncompatibleVO select(Long id, Date fref) throws InstanceNotFoundException {
		final ReglaIncompatibleCriterioVO rginCriterio = new ReglaIncompatibleCriterioVO();

		rginCriterio.setId(id);
		rginCriterio.setFechaVigencia(fref);

		final ReglaIncompatibleVO rgin = selectObject(rginCriterio);

		if (rgin == null) {
			throw new InstanceNotFoundException(MessageI18nKey.rgin, id);
		}

		return rgin;
	}

	/**
	 * Select object.
	 *
	 * @param rginCriterio
	 *            the rgin criterio
	 * @return the regla incompatible VO
	 */
	public ReglaIncompatibleVO selectObject(ReglaIncompatibleCriterioVO rginCriterio) {
		return rginDAO.selectObject(rginCriterio);
	}

	/**
	 * Select list.
	 *
	 * @param rginCriterio
	 *            the rgin criterio
	 * @return the list
	 */
	public List<ReglaIncompatibleVO> selectList(ReglaIncompatibleCriterioVO rginCriterio) {
		return rginDAO.selectList(rginCriterio);
	}
}
