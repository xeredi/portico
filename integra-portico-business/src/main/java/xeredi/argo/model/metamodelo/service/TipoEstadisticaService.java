package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoEstadisticaDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class TipoEstadisticaService {

	/** The tpes DAO. */
	@Inject
	private TipoEstadisticaDAO tpesDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Select label values.
	 *
	 * @param tpesCriterio
	 *            the tpes criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(final TipoEstadisticaCriterioVO tpesCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoEstadisticaVO tpes : selectList(tpesCriterio)) {
			list.add(new LabelValueVO(tpes.getNombre(), tpes.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpesCriterio
	 *            the tpes criterio
	 * @return the list
	 */
	public List<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio) {
		return tpesDAO.selectList(tpesCriterio);
	}

	/**
	 * Select list.
	 *
	 * @param tpesCriterio
	 *            the tpes criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio,
			int offset, int limit) {
		final int count = tpesDAO.count(tpesCriterio);

		return new PaginatedList<>(
				count > offset ? tpesDAO.selectList(tpesCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo estadistica VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoEstadisticaVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final TipoEstadisticaCriterioVO entiCriterio = new TipoEstadisticaCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoEstadisticaVO enti = tpesDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpes, id);
		}

		return enti;
	}

	/**
	 * Insert.
	 *
	 * @param tpes
	 *            the tpes
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (entiDAO.exists(tpes)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpes, tpes);
		}

		IgUtilBO.assignNextVal(tpes);
		tpes.setTipo(TipoEntidad.E);

		entiDAO.insert(tpes);
		tpesDAO.insert(tpes);

		i18nService.insertMap(tpes, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param tpes
	 *            the tpes
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpes.getId());

		if (entiDAO.update(tpes) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpes, tpes);
		}

		i18nService.updateMap(tpes, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param tpes
	 *            the tpes
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TipoEstadisticaVO tpes) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpes.getId());

		if (tpesDAO.delete(tpes) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpes, tpes);
		}

		i18nService.deleteMap(tpes);

		entiDAO.delete(tpes);
	}

}
