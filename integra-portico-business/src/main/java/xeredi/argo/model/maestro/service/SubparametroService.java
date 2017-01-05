package xeredi.argo.model.maestro.service;

import java.util.Date;
import java.util.List;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroService.
 */
public interface SubparametroService {

	/**
	 * Insert.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void insert(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail) throws OverlapException;

	/**
	 * Duplicate.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void duplicate(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail) throws OverlapException;

	/**
	 * Update.
	 *
	 * @param sprm
	 *            the sprm
	 * @param tpspDetail
	 *            the tpsp detail
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void update(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail)
			throws InstanceNotFoundException, OverlapException;

	/**
	 * Delete.
	 *
	 * @param sprm
	 *            the sprm
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(final SubparametroVO sprm) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param sprmCriterioVO
	 *            the sprm criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param sprmCriterioVO
	 *            the sprm criterio VO
	 * @return the list
	 */
	List<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO);

	/**
	 * Select object.
	 *
	 * @param sprmId
	 *            the sprm id
	 * @param idioma
	 *            the idioma
	 * @param fechaVigencia
	 *            the fecha vigencia
	 * @return the subparametro VO
	 */
	SubparametroVO selectObject(final Long sprmId, final String idioma, final Date fechaVigencia);

}
