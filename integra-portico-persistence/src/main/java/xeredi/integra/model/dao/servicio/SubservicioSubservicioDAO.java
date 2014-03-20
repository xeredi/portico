package xeredi.integra.model.dao.servicio;

import java.util.List;

import xeredi.integra.model.vo.servicio.SubservicioCriterioVO;
import xeredi.integra.model.vo.servicio.SubservicioSubservicioVO;

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
