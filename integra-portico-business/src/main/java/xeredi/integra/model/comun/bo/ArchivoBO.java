package xeredi.integra.model.comun.bo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.ArchivoDAO;
import xeredi.integra.model.comun.dao.ArchivoInfoDAO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.ArchivoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class FileServiceBO.
 */
public final class ArchivoBO {
    /**
     * Select.
     *
     * @param archId
     *            the arch id
     * @return the input stream
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public InputStream select(final Long archId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoDAO archDAO = session.getMapper(ArchivoDAO.class);

            final ArchivoVO arch = archDAO.select(archId);

            if (arch == null) {
                throw new InstanceNotFoundException(MessageI18nKey.arch, archId);
            }

            return new ByteArrayInputStream(arch.getArchivo());
        }
    }

    /**
     * Select info.
     *
     * @param archCriterio
     *            the arch criterio
     * @return the archivo info vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ArchivoInfoVO selectInfo(final ArchivoCriterioVO archCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoInfoDAO arinDAO = session.getMapper(ArchivoInfoDAO.class);

            final ArchivoInfoVO arin = arinDAO.selectObject(archCriterio);

            if (arin == null) {
                throw new InstanceNotFoundException(MessageI18nKey.arch, archCriterio.getId());
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
    public List<ArchivoInfoVO> selectInfoList(final ArchivoCriterioVO archCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ArchivoInfoDAO arinDAO = session.getMapper(ArchivoInfoDAO.class);

            return arinDAO.selectList(archCriterio);
        }
    }
}
