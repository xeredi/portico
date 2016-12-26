package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

public interface EntidadService {
	/**
	 * Select.
	 *
	 * @param entiId
	 *            the enti id
	 * @param idioma
	 *            the idioma
	 * @return the entidad vo
	 */
	public EntidadVO select(@NonNull final Long entiId, final String idioma);

	/**
	 * Select list.
	 *
	 * @param entiCriterio
	 *            the enti criterio vo
	 * @return the list
	 */
	public List<EntidadVO> selectList(@NonNull final EntidadCriterioVO entiCriterio);

	/**
	 * Select label values.
	 *
	 * @param entiCriterio
	 *            the enti criterio vo
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final EntidadCriterioVO entiCriterio);
}
