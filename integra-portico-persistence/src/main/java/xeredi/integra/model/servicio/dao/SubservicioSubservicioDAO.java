package xeredi.integra.model.servicio.dao;

import java.util.List;

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
    void insert(final SubservicioSubservicioVO ssssVO);

    /**
     * Delete.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int delete(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select list.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    List<SubservicioSubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO);
}
