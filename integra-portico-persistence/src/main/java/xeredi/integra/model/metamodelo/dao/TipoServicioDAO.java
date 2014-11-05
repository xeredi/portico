package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoServicioDAO.
 */
public interface TipoServicioDAO {

    /**
     * Select list.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @return the list
     */
    List<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO);

    /**
     * Select list.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoServicioVO> selectPaginatedList(final TipoServicioCriterioVO tpsrCriterioVO, final RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the tipo servicio vo
     */
    TipoServicioVO selectObject(final TipoServicioCriterioVO entiCriterioVO);

    /**
     * Count.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @return the int
     */
    int count(final TipoServicioCriterioVO tpsrCriterioVO);

    /**
     * Insert.
     *
     * @param tpsrVO
     *            the tpsr vo
     */
    void insert(final TipoServicioVO tpsrVO);

    /**
     * Update.
     *
     * @param tpsrVO
     *            the tpsr vo
     * @return the int
     */
    int update(final TipoServicioVO tpsrVO);

    /**
     * Delete.
     *
     * @param tpsrId
     *            the tpsr id
     * @return the int
     */
    int delete(final Long tpsrId);

}
