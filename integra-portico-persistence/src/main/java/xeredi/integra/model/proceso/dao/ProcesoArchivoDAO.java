package xeredi.integra.model.proceso.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoArchivoDAO.
 */
public interface ProcesoArchivoDAO {

    /**
     * Insert.
     *
     * @param prarVO
     *            the prar vo
     */
    void insert(final @Nonnull ProcesoArchivoVO prarVO);

    /**
     * Delete.
     *
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int delete(final @Nonnull Long prbtId);

    /**
     * Select list.
     *
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    List<ProcesoArchivoVO> selectList(final @Nonnull Long prbtId);
}
