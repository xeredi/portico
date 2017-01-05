package xeredi.argo.model.facturacion.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

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
@Singleton
@Transactional
public class ReglaIncompatibleServiceImpl implements ReglaIncompatibleService {

	/** The rgin DAO. */
	@Inject
	private ReglaIncompatibleDAO rginDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public void delete(ReglaIncompatibleVO rgin) throws InstanceNotFoundException {
		Preconditions.checkNotNull(rgin.getVersion());
		Preconditions.checkNotNull(rgin.getVersion().getId());

		final int updated = rginDAO.deleteVersion(rgin);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.rgin, rgin);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public ReglaIncompatibleVO selectObject(ReglaIncompatibleCriterioVO rginCriterio) {
		return rginDAO.selectObject(rginCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ReglaIncompatibleVO> selectList(ReglaIncompatibleCriterioVO rginCriterio) {
		return rginDAO.selectList(rginCriterio);
	}
}
