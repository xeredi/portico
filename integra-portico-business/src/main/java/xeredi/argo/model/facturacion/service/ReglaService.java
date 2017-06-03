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

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.service.I18nService;
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
public class ReglaService {

	/** The rgla DAO. */
	private final ReglaDAO rglaDAO;

	/** The i 18 n DAO. */
	private final I18nService i18nService;

	/**
	 * Instantiates a new regla service.
	 *
	 * @param rglaDAO
	 *            the rgla DAO
	 * @param i18nService
	 *            the i 18 n service
	 */
	@Inject
	public ReglaService(final ReglaDAO rglaDAO, final I18nService i18nService) {
		super();
		this.rglaDAO = rglaDAO;
		this.i18nService = i18nService;
	}

	/**
	 * Select list.
	 *
	 * @param rglaCriterioVO
	 *            the rgla criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ReglaVO> selectList(ReglaCriterioVO rglaCriterioVO, int offset, int limit) {
		Preconditions.checkArgument(offset >= 0);
		Preconditions.checkArgument(limit > 0);

		final int count = rglaDAO.count(rglaCriterioVO);

		return new PaginatedList<ReglaVO>(
				count > offset ? rglaDAO.selectList(rglaCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param rglaCriterioVO
	 *            the rgla criterio VO
	 * @return the list
	 */
	public List<ReglaVO> selectList(ReglaCriterioVO rglaCriterioVO) {
		return rglaDAO.selectList(rglaCriterioVO);
	}

	/**
	 * Select typeahead list.
	 *
	 * @param rglaCriterio
	 *            the rgla criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	public List<ReglaVO> selectTypeaheadList(ReglaCriterioVO rglaCriterio, int limit) {
		rglaCriterio.setTextoBusqueda("%" + rglaCriterio.getTextoBusqueda() + "%");

		if (rglaCriterio.getFechaVigencia() == null) {
			rglaCriterio.setFechaVigencia(Calendar.getInstance().getTime());
		}

		return rglaDAO.selectList(rglaCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
	}

	/**
	 * Insert.
	 *
	 * @param rgla
	 *            the rgla
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
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
		i18nService.insertMap(rgla, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param rgla
	 *            the rgla
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
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

		i18nService.updateMap(rgla, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param rgla
	 *            the rgla
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(ReglaVO rgla) throws InstanceNotFoundException {
		Preconditions.checkNotNull(rgla.getVersion());
		Preconditions.checkNotNull(rgla.getVersion().getId());

		final int updated = rglaDAO.deleteVersion(rgla);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.rgla, rgla);
		}

		i18nService.deleteMap(rgla);
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
	 * @return the regla VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
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
	 * Select object.
	 *
	 * @param rglaCriterio
	 *            the rgla criterio
	 * @return the regla VO
	 */
	public ReglaVO selectObject(ReglaCriterioVO rglaCriterio) {
		return rglaDAO.selectObject(rglaCriterio);
	}
}
