package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoServicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class TipoServicioService {

	/** The tpsr DAO. */
	@Inject
	private TipoServicioDAO tpsrDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Select label values.
	 *
	 * @param criterioVO
	 *            the criterio VO
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(TipoServicioCriterioVO criterioVO) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoServicioVO tpsr : selectList(criterioVO)) {
			list.add(new LabelValueVO(tpsr.getNombre(), tpsr.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpsrCriterio
	 *            the tpsr criterio
	 * @return the list
	 */
	public List<TipoServicioVO> selectList(TipoServicioCriterioVO tpsrCriterio) {
		return tpsrDAO.selectList(tpsrCriterio);
	}

	/**
	 * Select list.
	 *
	 * @param tpsrCriterio
	 *            the tpsr criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<TipoServicioVO> selectList(TipoServicioCriterioVO tpsrCriterio, int offset, int limit) {
		final int count = tpsrDAO.count(tpsrCriterio);

		return new PaginatedList<>(
				count > offset ? tpsrDAO.selectList(tpsrCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo servicio VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoServicioVO select(Long id, String idioma) throws InstanceNotFoundException {
		final TipoServicioCriterioVO entiCriterio = new TipoServicioCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoServicioVO enti = tpsrDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsr, id);
		}

		return enti;
	}

	/**
	 * Insert.
	 *
	 * @param tpsr
	 *            the tpsr
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(TipoServicioVO tpsr, Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
		if (entiDAO.exists(tpsr)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpsr, tpsr);
		}

		IgUtilBO.assignNextVal(tpsr);
		tpsr.setTipo(TipoEntidad.T);

		entiDAO.insert(tpsr);
		tpsrDAO.insert(tpsr);
		i18nService.insertMap(tpsr, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param tpsr
	 *            the tpsr
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(TipoServicioVO tpsr, Map<String, I18nVO> i18nMap) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpsr.getId());

		if (tpsrDAO.update(tpsr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsr);
		}

		entiDAO.update(tpsr);
		i18nService.updateMap(tpsr, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param tpsr
	 *            the tpsr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(TipoServicioVO tpsr) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpsr.getId());

		if (tpsrDAO.delete(tpsr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsr);
		}

		i18nService.deleteMap(tpsr);
		entiDAO.delete(tpsr);
	}
}
