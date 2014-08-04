package xeredi.integra.model.dao.maestro;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.maestro.ParametroCriterioVO;
import xeredi.integra.model.vo.maestro.ParametroLupaCriterioVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroDAO.
 */
public interface ParametroDAO {

    /**
     * Eists.
     *
     * @param prmtVO
     *            the prmt vo
     * @return true, if successful
     */
    boolean exists(final ParametroVO prmtVO);

    /**
     * Intersects.
     *
     * @param prmtVO
     *            the prmt vo
     * @return true, if successful
     */
    boolean intersects(final ParametroVO prmtVO);

    /**
     * Insert.
     *
     * @param prmtVO
     *            the prmt vo
     */
    void insert(final ParametroVO prmtVO);

    /**
     * Update.
     *
     * @param prmtVO
     *            the prmt vo
     */
    void update(final ParametroVO prmtVO);

    /**
     * Update delete.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     */
    void updateDelete(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select object.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the parametro vo
     */
    ParametroVO selectObject(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select id.
     *
     * @param prmtVO
     *            the prmt vo
     * @return the long
     */
    Long selectId(final ParametroVO prmtVO);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    @MapKey("parametro")
    Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    @MapKey("id")
    Map<Long, ParametroVO> selectMap(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select count.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the long
     */
    int selectCount(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select lupa list.
     *
     * @param prmtLupaCriterioVO
     *            the prmt lupa criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<LabelValueVO> selectLupaList(final ParametroLupaCriterioVO prmtLupaCriterioVO, final RowBounds bounds);

}
