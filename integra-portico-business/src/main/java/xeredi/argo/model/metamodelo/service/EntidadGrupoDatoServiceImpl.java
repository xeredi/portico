package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
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
public class EntidadGrupoDatoServiceImpl implements EntidadGrupoDatoService {

	/** The engd DAO. */
	@Inject
	private EntidadGrupoDatoDAO engdDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final EntidadGrupoDatoVO engdVO, @NonNull final Map<String, I18nVO> i18nMap) {
		Preconditions.checkNotNull(engdVO.getEntiId());
		Preconditions.checkNotNull(engdVO.getNumero());

		// FIXME Deberia controlar duplicados
		IgUtilBO.assignNextVal(engdVO);
		engdDAO.insert(engdVO);

		I18nUtil.insertMap(i18nDAO, engdVO, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final EntidadGrupoDatoVO engdVO, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(engdVO.getEntiId());
		Preconditions.checkNotNull(engdVO.getNumero());

		if (engdDAO.update(engdVO) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.engd, engdVO);
		}

		I18nUtil.updateMap(i18nDAO, engdVO, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final EntidadGrupoDatoVO engd) throws InstanceNotFoundException {
		if (engdDAO.delete(engd) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.engd, engd);
		}

		I18nUtil.deleteMap(i18nDAO, engd);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public List<EntidadGrupoDatoVO> selectList(@NonNull final EntidadGrupoDatoCriterioVO engdCriterio) {
		return engdDAO.selectList(engdCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LabelValueVO> selectLabelValues(@NonNull final EntidadGrupoDatoCriterioVO engdCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final EntidadGrupoDatoVO engd : selectList(engdCriterio)) {
			list.add(new LabelValueVO(engd.getEtiqueta(), engd.getNumero()));
		}

		return list;
	}

}
