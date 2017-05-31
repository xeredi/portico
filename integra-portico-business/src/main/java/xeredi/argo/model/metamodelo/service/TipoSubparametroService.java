package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoSubparametroDAO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
@Singleton
public class TipoSubparametroService {

	/** The tpsp DAO. */
	@Inject
	private TipoSubparametroDAO tpspDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/** The enen DAO. */
	@Inject
	private EntidadEntidadDAO enenDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * Select label values.
	 *
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues() {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoSubparametroVO tpsp : selectList(new TipoSubparametroCriterioVO())) {
			list.add(new LabelValueVO(tpsp.getNombre(), tpsp.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpspCriterioVO
	 *            the tpsp criterio VO
	 * @return the list
	 */
	public List<TipoSubparametroVO> selectList(TipoSubparametroCriterioVO tpspCriterioVO) {
		return tpspDAO.selectList(tpspCriterioVO);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo subparametro VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoSubparametroVO select(Long id, String idioma) throws InstanceNotFoundException {
		final TipoSubparametroCriterioVO entiCriterio = new TipoSubparametroCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoSubparametroVO enti = tpspDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsp, id);
		}

		return enti;
	}

	/**
	 * Insert.
	 *
	 * @param enti
	 *            the enti
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(TipoSubparametroVO enti, Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
		Preconditions.checkNotNull(enti.getTpprId());

		if (entiDAO.exists(enti)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpsp, enti);
		}

		IgUtilBO.assignNextVal(enti);
		enti.setTipo(TipoEntidad.B);

		entiDAO.insert(enti);
		tpspDAO.insert(enti);

		final EntidadEntidadVO enen = new EntidadEntidadVO();

		enen.setEntiPadreId(enti.getTpprId());
		enen.setEntiHija(enti);
		enen.setOrden(0); // FIXME Corregir

		enenDAO.insert(enen);

		I18nUtil.insertMap(i18nDAO, enti, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param tpsp
	 *            the tpsp
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(TipoSubparametroVO tpsp, Map<String, I18nVO> i18nMap) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpsp.getId());

		if (tpspDAO.update(tpsp) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsp, tpsp);
		}

		entiDAO.update(tpsp);
		I18nUtil.updateMap(i18nDAO, tpsp, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param enti
	 *            the enti
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(TipoSubparametroVO enti) throws InstanceNotFoundException {
		Preconditions.checkNotNull(enti.getId());
		Preconditions.checkNotNull(enti.getTpprId());

		if (tpspDAO.delete(enti) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsp, enti);
		}

		final EntidadEntidadVO enen = new EntidadEntidadVO();

		enen.setEntiPadreId(enti.getTpprId());
		enen.setEntiHija(enti);

		enenDAO.delete(enen);
		entiDAO.delete(enti);
		I18nUtil.deleteMap(i18nDAO, enti);
	}
}
