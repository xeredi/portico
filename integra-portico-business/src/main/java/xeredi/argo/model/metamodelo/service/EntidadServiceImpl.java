package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class EntidadServiceImpl implements EntidadService {

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntidadVO select(@NonNull final Long entiId, final String idioma) {
		final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

		entiCriterio.setId(entiId);
		entiCriterio.setIdioma(idioma);

		return entiDAO.selectObject(entiCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EntidadVO> selectList(@NonNull final EntidadCriterioVO entiCriterio) {
		return entiDAO.selectList(entiCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LabelValueVO> selectLabelValues(@NonNull final EntidadCriterioVO entiCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final EntidadVO enti : selectList(entiCriterio)) {
			list.add(new LabelValueVO(enti.getNombre(), enti.getId()));
		}

		return list;
	}
}
