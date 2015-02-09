package xeredi.integra.model.comun.bo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.ArchivoDAO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ArchivoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class FileServiceBO.
 */
public final class FileServiceBO {
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
}
