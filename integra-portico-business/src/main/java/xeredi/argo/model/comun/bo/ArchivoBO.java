package xeredi.argo.model.comun.bo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

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
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FileServiceBO.
 */
public final class ArchivoBO {

    /**
     * Creates the.
     *
     * @param file
     *            the file
     * @param sentido
     *            the sentido
     * @return the archivo vo
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public ArchivoVO create(final @NonNull File file, final @NonNull ArchivoSentido sentido)
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

        final IgBO igBO = new IgBO();

        arch.getArin().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoDAO archDAO = session.getMapper(ArchivoDAO.class);

            archDAO.insert(arch);

            session.commit();
        }

        return arch;
    }

    /**
     * Insert.
     *
     * @param arch
     *            the arch
     */
    public void insert(final @NonNull ArchivoVO arch) {
        Preconditions.checkNotNull(arch.getArin());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoDAO archDAO = session.getMapper(ArchivoDAO.class);
            final IgBO igBO = new IgBO();

            arch.getArin().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            archDAO.insert(arch);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param archId
     *            the arch id
     * @return the input stream
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public InputStream selectStream(final @NonNull Long archId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoDAO archDAO = session.getMapper(ArchivoDAO.class);
            final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

            archCriterio.setId(archId);

            final ArchivoVO arch = archDAO.selectObject(archCriterio);

            if (arch == null) {
                throw new InstanceNotFoundException(MessageI18nKey.arch, archId);
            }

            return GzipUtil.decompress(arch.getArchivo());
        }
    }

    /**
     * Select.
     *
     * @param archId
     *            the arch id
     * @return the archivo info vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ArchivoInfoVO select(final @NonNull Long archId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoInfoDAO arinDAO = session.getMapper(ArchivoInfoDAO.class);
            final ArchivoCriterioVO arinCriterio = new ArchivoCriterioVO();

            arinCriterio.setId(archId);

            final ArchivoInfoVO arin = arinDAO.selectObject(arinCriterio);

            if (arin == null) {
                throw new InstanceNotFoundException(MessageI18nKey.arch, archId);
            }

            return arin;
        }
    }

    /**
     * Select info list.
     *
     * @param archCriterio
     *            the arch criterio
     * @return the list
     */
    public List<ArchivoInfoVO> selectList(final @NonNull ArchivoCriterioVO archCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoInfoDAO arinDAO = session.getMapper(ArchivoInfoDAO.class);

            return arinDAO.selectList(archCriterio);
        }
    }
}
