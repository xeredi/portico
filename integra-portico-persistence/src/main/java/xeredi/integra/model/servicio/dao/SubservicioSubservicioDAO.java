package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioSubservicioDAO.
 */
public interface SubservicioSubservicioDAO {

    /**
     * Insert.
     *
     * @param ssssVO
     *            the ssss vo
     */
    void insert(final @Nonnull SubservicioSubservicioVO ssssVO);

    /**
     * Delete.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int delete(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    List<SubservicioSubservicioVO> selectList(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);
}
