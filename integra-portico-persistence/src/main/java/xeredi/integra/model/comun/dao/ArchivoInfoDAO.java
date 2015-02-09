package xeredi.integra.model.comun.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ArchivoInfoDAO.
 */
public interface ArchivoInfoDAO {

    /**
     * Select list.
     *
     * @param arinCriterio
     *            the arin criterio
     * @return the list
     */
    List<ArchivoInfoVO> selectList(final @Nonnull ArchivoCriterioVO arinCriterio);
}
