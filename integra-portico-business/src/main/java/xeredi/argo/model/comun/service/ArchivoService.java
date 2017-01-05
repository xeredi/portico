package xeredi.argo.model.comun.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ArchivoCriterioVO;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ArchivoService.
 */
public interface ArchivoService {

	/**
	 * Creates the.
	 *
	 * @param file
	 *            the file
	 * @param sentido
	 *            the sentido
	 * @return the archivo VO
	 * @throws ApplicationException
	 *             the application exception
	 */
	public ArchivoVO create(@NonNull final File file, @NonNull final ArchivoSentido sentido)
			throws ApplicationException;

	/**
	 * Insert.
	 *
	 * @param arch
	 *            the arch
	 */
	public void insert(@NonNull final ArchivoVO arch);

	/**
	 * Select stream.
	 *
	 * @param archId
	 *            the arch id
	 * @return the input stream
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public InputStream selectStream(@NonNull final Long archId) throws InstanceNotFoundException;

	/**
	 * Select.
	 *
	 * @param archId
	 *            the arch id
	 * @return the archivo info VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ArchivoInfoVO select(@NonNull final Long archId) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param archCriterio
	 *            the arch criterio
	 * @return the list
	 */
	public List<ArchivoInfoVO> selectList(@NonNull final ArchivoCriterioVO archCriterio);
}
