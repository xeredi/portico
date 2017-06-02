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
public class EntidadService {

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/**
	 * Select.
	 *
	 * @param entiId
	 *            the enti id
	 * @param idioma
	 *            the idioma
	 * @return the entidad VO
	 */
	public EntidadVO select(@NonNull final Long entiId, final String idioma) {
		final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

		entiCriterio.setId(entiId);
		entiCriterio.setIdioma(idioma);

		return entiDAO.selectObject(entiCriterio);
	}

	/**
	 * Select list.
	 *
	 * @param entiCriterio
	 *            the enti criterio
	 * @return the list
	 */
	public List<EntidadVO> selectList(@NonNull final EntidadCriterioVO entiCriterio) {
		return entiDAO.selectList(entiCriterio);
	}

	/**
	 * Select label values.
	 *
	 * @param entiCriterio
	 *            the enti criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final EntidadCriterioVO entiCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final EntidadVO enti : selectList(entiCriterio)) {
			list.add(new LabelValueVO(enti.getNombre(), enti.getId()));
		}

		return list;
	}
}
