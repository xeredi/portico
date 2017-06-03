package xeredi.argo.model.facturacion.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoCargoDAO;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class AspectoCargoService {

	/** The ascr DAO. */
	private final AspectoCargoDAO ascrDAO;

	/**
	 * Instantiates a new aspecto cargo service.
	 *
	 * @param ascrDAO
	 *            the ascr DAO
	 */
	@Inject
	public AspectoCargoService(final AspectoCargoDAO ascrDAO) {
		super();
		this.ascrDAO = ascrDAO;
	}

	/**
	 * Select list.
	 *
	 * @param criterioVO
	 *            the criterio VO
	 * @return the list
	 */
	public final List<AspectoCargoVO> selectList(@NonNull final AspectoCargoCriterioVO criterioVO) {
		return ascrDAO.selectList(criterioVO);
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
	 * @return the aspecto cargo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final AspectoCargoVO select(@NonNull final Long id, @NonNull final Date fref, final String idioma)
			throws InstanceNotFoundException {
		final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

		ascrCriterio.setId(id);
		ascrCriterio.setFechaVigencia(fref);
		ascrCriterio.setIdioma(idioma);

		final AspectoCargoVO ascr = selectObject(ascrCriterio);

		if (ascr == null) {
			throw new InstanceNotFoundException(MessageI18nKey.ascr, id);
		}

		return ascr;
	}

	/**
	 * Select object.
	 *
	 * @param ascrCriterio
	 *            the ascr criterio
	 * @return the aspecto cargo VO
	 */
	public final AspectoCargoVO selectObject(@NonNull final AspectoCargoCriterioVO ascrCriterio) {
		return ascrDAO.selectObject(ascrCriterio);
	}

	/**
	 * Insert.
	 *
	 * @param ascr
	 *            the ascr
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public final void insert(@NonNull final AspectoCargoVO ascr) throws OverlapException {
		Preconditions.checkNotNull(ascr.getVersion());
		Preconditions.checkNotNull(ascr.getVersion().getFini());
		Preconditions.checkNotNull(ascr.getAspcId());
		Preconditions.checkNotNull(ascr.getCrgo());
		Preconditions.checkNotNull(ascr.getCrgo().getId());

		DateUtil.truncTime(ascr.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(ascr.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (ascrDAO.exists(ascr)) {
			ascr.setId(ascrDAO.selectId(ascr));

			if (ascrDAO.existsOverlap(ascr)) {
				throw new OverlapException(MessageI18nKey.ascr, ascr);
			}
		} else {
			IgUtilBO.assignNextVal(ascr);

			ascrDAO.insert(ascr);
		}

		IgUtilBO.assignNextVal(ascr.getVersion());

		ascrDAO.insertVersion(ascr);
	}

	/**
	 * Update.
	 *
	 * @param ascr
	 *            the ascr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	public final void update(@NonNull final AspectoCargoVO ascr) throws InstanceNotFoundException, OverlapException {
		Preconditions.checkNotNull(ascr.getId());
		Preconditions.checkNotNull(ascr.getVersion());
		Preconditions.checkNotNull(ascr.getVersion().getId());
		Preconditions.checkNotNull(ascr.getVersion().getFini());

		DateUtil.truncTime(ascr.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(ascr.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (ascrDAO.existsOverlap(ascr)) {
			throw new OverlapException(MessageI18nKey.ascr, ascr);
		}

		if (ascrDAO.updateVersion(ascr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.ascr, ascr);
		}
	}

	/**
	 * Delete.
	 *
	 * @param ascr
	 *            the ascr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public final void delete(@NonNull final AspectoCargoVO ascr) throws InstanceNotFoundException {
		Preconditions.checkNotNull(ascr.getVersion());
		Preconditions.checkNotNull(ascr.getVersion().getId());

		if (ascrDAO.deleteVersion(ascr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.ascr, ascr);
		}
	}
}
