package xeredi.integra.model.servicio.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

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
     * @param sstr
     *            the sstr
     * @return the int
     */
    int updateEstado(final SubservicioTramiteVO sstr);

    /**
     * Delete.
     *
     * @param ssrvCriterio
     *            the ssrv criterio
     * @return the int
     */
    int deleteList(final SubservicioCriterioVO ssrvCriterio);

    /**
     * Delete.
     *
     * @param ssrv
     *            the ssrv
     * @return the int
     */
    int delete(final SubservicioVO ssrv);

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
     * @return the list
     */
    List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO);

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
     * Select lupa list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<SubservicioVO> selectLupaList(final SubservicioLupaCriterioVO ssrvCriterioVO, final RowBounds bounds);

    /**
     * Select.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the subservicio vo
     */
    SubservicioVO selectObject(final SubservicioCriterioVO ssrvCriterioVO);
}
