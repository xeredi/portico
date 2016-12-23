package xeredi.argo.model.seguridad.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface GrupoService.
 */
public interface GrupoService {

	/**
	 * Insert.
	 *
	 * @param grpo
	 *            the grpo
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(@NonNull final GrupoVO grpo) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param grpo
	 *            the grpo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final GrupoVO grpo) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param grpo
	 *            the grpo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final GrupoVO grpo) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param grpoCriterio
	 *            the grpo criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<GrupoVO> selectList(final GrupoCriterioVO grpoCriterio, final int offset, final int limit);

	/**
	 * Select list.
	 *
	 * @param grpoCriterio
	 *            the grpo criterio
	 * @return the list
	 */
	List<GrupoVO> selectList(final GrupoCriterioVO grpoCriterio);

	/**
	 * Select object.
	 *
	 * @param id
	 *            the id
	 * @return the grupo vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public GrupoVO select(@NonNull final Long id) throws InstanceNotFoundException;
}
