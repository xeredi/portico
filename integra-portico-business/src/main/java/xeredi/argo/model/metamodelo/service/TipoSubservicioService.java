package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoSubservicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class TipoSubservicioService {

	/** The tpss DAO. */
	@Inject
	private TipoSubservicioDAO tpssDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Select label values.
	 *
	 * @param tpssCriterio
	 *            the tpss criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(TipoSubservicioCriterioVO tpssCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoSubservicioVO tpss : selectList(tpssCriterio)) {
			list.add(new LabelValueVO(tpss.getNombre(), tpss.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpssCriterio
	 *            the tpss criterio
	 * @return the list
	 */
	public List<TipoSubservicioVO> selectList(TipoSubservicioCriterioVO tpssCriterio) {
		return tpssDAO.selectList(tpssCriterio);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo subservicio VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoSubservicioVO select(Long id, String idioma) throws InstanceNotFoundException {
		final TipoSubservicioCriterioVO entiCriterio = new TipoSubservicioCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoSubservicioVO enti = tpssDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpss, id);
		}

		return enti;
	}

	/**
	 * Insert.
	 *
	 * @param tpss
	 *            the tpss
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(TipoSubservicioVO tpss, Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
		Preconditions.checkNotNull(tpss.getTpsrId());

		if (entiDAO.exists(tpss)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpss, tpss);
		}

		IgUtilBO.assignNextVal(tpss);
		tpss.setTipo(TipoEntidad.S);

		entiDAO.insert(tpss);
		tpssDAO.insert(tpss);
		i18nService.insertMap(tpss, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param tpss
	 *            the tpss
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(TipoSubservicioVO tpss, Map<String, I18nVO> i18nMap) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpss.getId());

		if (tpssDAO.update(tpss) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpss, tpss);
		}

		entiDAO.update(tpss);
		i18nService.updateMap(tpss, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param tpss
	 *            the tpss
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(TipoSubservicioVO tpss) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpss.getId());

		if (tpssDAO.delete(tpss) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpss, tpss);
		}

		entiDAO.delete(tpss);
		i18nService.deleteMap(tpss);
	}

}
