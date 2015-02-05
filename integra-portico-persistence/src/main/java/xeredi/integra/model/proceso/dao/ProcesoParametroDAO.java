package xeredi.integra.model.proceso.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.proceso.vo.ProcesoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoParametroDAO.
 */
public interface ProcesoParametroDAO {

    /**
     * Insert.
     *
     * @param prpmVO
     *            the prpm vo
     */
    void insert(final @Nonnull ProcesoParametroVO prpmVO);

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
    List<ProcesoParametroVO> selectList(final @Nonnull Long prbtId);

}
