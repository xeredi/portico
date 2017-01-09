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
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.util.DateUtil;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ReglaServiceImpl implements ReglaService {

	/** The rgla DAO. */
	@Inject
	private ReglaDAO rglaDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<ReglaVO> selectList(ReglaCriterioVO rglaCriterioVO, int offset, int limit) {
		Preconditions.checkArgument(offset >= 0);
		Preconditions.checkArgument(limit > 0);

		final int count = rglaDAO.count(rglaCriterioVO);

		return new PaginatedList<ReglaVO>(
				count > offset ? rglaDAO.selectList(rglaCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ReglaVO> selectList(ReglaCriterioVO rglaCriterioVO) {
		return rglaDAO.selectList(rglaCriterioVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ReglaVO> selectTypeaheadList(ReglaCriterioVO rglaCriterio, int limit) {
		rglaCriterio.setTextoBusqueda("%" + rglaCriterio.getTextoBusqueda() + "%");

		if (rglaCriterio.getFechaVigencia() == null) {
			rglaCriterio.setFechaVigencia(Calendar.getInstance().getTime());
		}

		return rglaDAO.selectList(rglaCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(ReglaVO rgla, Map<String, I18nVO> i18nMap) throws OverlapException {
		Preconditions.checkNotNull(rgla.getVersion());
		Preconditions.checkNotNull(rgla.getVersion().getFini());
		Preconditions.checkNotNull(rgla.getCrgo());
		Preconditions.checkNotNull(rgla.getCrgo().getId());
		Preconditions.checkNotNull(rgla.getEnti());
		Preconditions.checkNotNull(rgla.getEnti().getId());
		Preconditions.checkNotNull(rgla.getTipo());

		DateUtil.truncTime(rgla.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(rgla.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (rglaDAO.exists(rgla)) {
			rgla.setId(rglaDAO.selectId(rgla));

			if (rglaDAO.existsOverlap(rgla)) {
				throw new OverlapException(MessageI18nKey.rgla, rgla);
			}
		} else {
			IgUtilBO.assignNextVal(rgla);
			rglaDAO.insert(rgla);
		}

		IgUtilBO.assignNextVal(rgla.getVersion());
		rglaDAO.insertVersion(rgla);
		I18nUtil.insertMap(i18nDAO, rgla, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ReglaVO rgla, Map<String, I18nVO> i18nMap) throws InstanceNotFoundException, OverlapException {
		Preconditions.checkNotNull(rgla.getVersion());
		Preconditions.checkNotNull(rgla.getVersion().getId());

		DateUtil.truncTime(rgla.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(rgla.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		if (rglaDAO.existsOverlap(rgla)) {
			throw new OverlapException(MessageI18nKey.rgla, rgla);
		}

		final int updated = rglaDAO.updateVersion(rgla);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.rgla, rgla);
		}

		I18nUtil.updateMap(i18nDAO, rgla, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(ReglaVO rgla) throws InstanceNotFoundException {
		Preconditions.checkNotNull(rgla.getVersion());
		Preconditions.checkNotNull(rgla.getVersion().getId());

		final int updated = rglaDAO.deleteVersion(rgla);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.rgla, rgla);
		}

		I18nUtil.deleteMap(i18nDAO, rgla);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReglaVO select(Long id, Date fref, String idioma) throws InstanceNotFoundException {
		final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

		rglaCriterio.setId(id);
		rglaCriterio.setFechaVigencia(fref);
		rglaCriterio.setIdioma(idioma);

		final ReglaVO rgla = selectObject(rglaCriterio);

		if (rgla == null) {
			throw new InstanceNotFoundException(MessageI18nKey.rgla, id);
		}

		return rgla;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReglaVO selectObject(ReglaCriterioVO rglaCriterio) {
		return rglaDAO.selectObject(rglaCriterio);
	}
}
