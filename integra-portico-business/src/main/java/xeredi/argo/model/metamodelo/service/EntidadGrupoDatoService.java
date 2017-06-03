package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class EntidadGrupoDatoService {

	/** The engd DAO. */
	@Inject
	private EntidadGrupoDatoDAO engdDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Insert.
	 *
	 * @param engdVO
	 *            the engd VO
	 * @param i18nMap
	 *            the i 18 n map
	 */
	public void insert(@NonNull final EntidadGrupoDatoVO engdVO, @NonNull final Map<String, I18nVO> i18nMap) {
		Preconditions.checkNotNull(engdVO.getEntiId());
		Preconditions.checkNotNull(engdVO.getNumero());

		// FIXME Deberia controlar duplicados
		IgUtilBO.assignNextVal(engdVO);
		engdDAO.insert(engdVO);

		i18nService.insertMap(engdVO, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param engdVO
	 *            the engd VO
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final EntidadGrupoDatoVO engdVO, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(engdVO.getEntiId());
		Preconditions.checkNotNull(engdVO.getNumero());

		if (engdDAO.update(engdVO) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.engd, engdVO);
		}

		i18nService.updateMap(engdVO, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param engd
	 *            the engd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final EntidadGrupoDatoVO engd) throws InstanceNotFoundException {
		if (engdDAO.delete(engd) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.engd, engd);
		}

		i18nService.deleteMap(engd);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the entidad grupo dato VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public EntidadGrupoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final EntidadGrupoDatoCriterioVO engdCriterioVO = new EntidadGrupoDatoCriterioVO();

		engdCriterioVO.setId(id);
		engdCriterioVO.setIdioma(idioma);

		final EntidadGrupoDatoVO engdVO = engdDAO.selectObject(engdCriterioVO);

		if (engdVO == null) {
			throw new InstanceNotFoundException(MessageI18nKey.engd, id);
		}

		return engdVO;
	}

	/**
	 * Select list.
	 *
	 * @param engdCriterio
	 *            the engd criterio
	 * @return the list
	 */
	public List<EntidadGrupoDatoVO> selectList(@NonNull final EntidadGrupoDatoCriterioVO engdCriterio) {
		return engdDAO.selectList(engdCriterio);
	}

	/**
	 * Select label values.
	 *
	 * @param engdCriterio
	 *            the engd criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final EntidadGrupoDatoCriterioVO engdCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final EntidadGrupoDatoVO engd : selectList(engdCriterio)) {
			list.add(new LabelValueVO(engd.getEtiqueta(), engd.getNumero()));
		}

		return list;
	}

}
