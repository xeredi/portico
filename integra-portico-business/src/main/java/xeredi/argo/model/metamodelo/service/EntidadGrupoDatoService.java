package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadGrupoDatoService.
 */
public interface EntidadGrupoDatoService {

	/**
	 * Insert.
	 *
	 * @param engdVO
	 *            the engd VO
	 * @param i18nMap
	 *            the i 18 n map
	 */
	public void insert(@NonNull final EntidadGrupoDatoVO engdVO, @NonNull final Map<String, I18nVO> i18nMap);

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
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param engd
	 *            the engd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final EntidadGrupoDatoVO engd) throws InstanceNotFoundException;

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
	public EntidadGrupoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param engdCriterio
	 *            the engd criterio
	 * @return the list
	 */
	public List<EntidadGrupoDatoVO> selectList(@NonNull final EntidadGrupoDatoCriterioVO engdCriterio);

	/**
	 * Select label values.
	 *
	 * @param engdCriterio
	 *            the engd criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final EntidadGrupoDatoCriterioVO engdCriterio);

}
