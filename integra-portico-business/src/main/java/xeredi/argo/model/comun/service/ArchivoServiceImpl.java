package xeredi.argo.model.comun.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.ArchivoDAO;
import xeredi.argo.model.comun.dao.ArchivoInfoDAO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.vo.ArchivoCriterioVO;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.util.GzipUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ArchivoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ArchivoServiceImpl implements ArchivoService {

	/** The arch DAO. */
	@Inject
	private ArchivoDAO archDAO;

	/** The arin DAO. */
	@Inject
	private ArchivoInfoDAO arinDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArchivoVO create(@NonNull final File file, @NonNull final ArchivoSentido sentido)
			throws ApplicationException {
		final ArchivoVO arch = new ArchivoVO();

		try {
			arch.setArchivo(GzipUtil.compress(file));
			arch.getArin().setFalta(Calendar.getInstance().getTime());
			arch.getArin().setNombre(file.getName());
			arch.getArin().setTamanio(file.length());
			arch.getArin().setSentido(sentido);
		} catch (final IOException ex) {
			throw new InternalErrorException(ex);
		}

		IgUtilBO.assignNextVal(arch.getArin());
		archDAO.insert(arch);

		return arch;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final ArchivoVO arch) {
		Preconditions.checkNotNull(arch.getArin());

		IgUtilBO.assignNextVal(arch.getArin());
		archDAO.insert(arch);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputStream selectStream(@NonNull final Long archId) throws InstanceNotFoundException {
		final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

		archCriterio.setId(archId);

		final ArchivoVO arch = archDAO.selectObject(archCriterio);

		if (arch == null) {
			throw new InstanceNotFoundException(MessageI18nKey.arch, archId);
		}

		return GzipUtil.decompress(arch.getArchivo());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArchivoInfoVO select(@NonNull final Long archId) throws InstanceNotFoundException {
		final ArchivoCriterioVO arinCriterio = new ArchivoCriterioVO();

		arinCriterio.setId(archId);

		final ArchivoInfoVO arin = arinDAO.selectObject(arinCriterio);

		if (arin == null) {
			throw new InstanceNotFoundException(MessageI18nKey.arch, archId);
		}

		return arin;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ArchivoInfoVO> selectList(@NonNull final ArchivoCriterioVO archCriterio) {
		return arinDAO.selectList(archCriterio);
	}
}
