package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioLupaCriterioVO;
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
    void insert(final @Nonnull SubservicioVO ssrvVO);

    /**
     * Update.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @return the int
     */
    int update(final @Nonnull SubservicioVO ssrvVO);

    /**
     * Update estado.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @return the int
     */
    int updateEstado(final @Nonnull SubservicioVO ssrvVO);

    /**
     * Delete.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int delete(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Exists.
     *
     * @param ssrvVO
     *            the ssrv vo
     * @return true, if successful
     */
    boolean exists(final @Nonnull SubservicioVO ssrvVO);

    /**
     * Select count.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int selectCount(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    List<SubservicioVO> selectList(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<SubservicioVO> selectList(final @Nonnull SubservicioCriterioVO ssrvCriterioVO, final RowBounds bounds);

    /**
     * Select lupa list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<SubservicioVO> selectLupaList(final @Nonnull SubservicioLupaCriterioVO ssrvCriterioVO,
            final @Nonnull RowBounds bounds);

    /**
     * Select.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the subservicio vo
     */
    SubservicioVO selectObject(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);
}
