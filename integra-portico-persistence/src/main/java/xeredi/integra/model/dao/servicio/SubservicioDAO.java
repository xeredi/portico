package xeredi.integra.model.dao.servicio;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.servicio.SubservicioCriterioVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioDAO.
 */
public interface SubservicioDAO {

    /**
     * Insert.
     *
     * @param ssrvVO
     *            the ssrv vo
     */
    void insert(final SubservicioVO ssrvVO);

    /**
     * Update.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @return the int
     */
    int update(final SubservicioVO ssrvVO);

    /**
     * Update estado.
     * 
     * @param ssrvVO
     *            the ssrv vo
     * @return the int
     */
    int updateEstado(final SubservicioVO ssrvVO);

    /**
     * Delete.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int delete(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Exists.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @return true, if successful
     */
    boolean exists(final SubservicioVO ssrvVO);

    /**
     * Select count.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int selectCount(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the subservicio vo
     */
    SubservicioVO selectObject(final SubservicioCriterioVO ssrvCriterioVO);
}
