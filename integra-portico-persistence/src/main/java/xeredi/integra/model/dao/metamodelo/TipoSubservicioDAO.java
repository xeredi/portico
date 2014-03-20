package xeredi.integra.model.dao.metamodelo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.metamodelo.TipoSubservicioCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoSubservicioDAO.
 */
public interface TipoSubservicioDAO {

    /**
     * Insert.
     * 
     * @param tpssVO
     *            the tpss vo
     */
    void insert(final TipoSubservicioVO tpssVO);

    /**
     * Update.
     * 
     * @param tpssVO
     *            the tpss vo
     * @return the int
     */
    int update(final TipoSubservicioVO tpssVO);

    /**
     * Delete.
     * 
     * @param tpssId
     *            the tpss id
     * @return the int
     */
    int delete(final Long tpssId);

    /**
     * Count.
     * 
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @return the int
     */
    int count(final TipoSubservicioCriterioVO tpssCriterioVO);

    /**
     * Select list.
     * 
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @return the list
     */
    List<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO);

    /**
     * Select list.
     * 
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO, final RowBounds bounds);

    /**
     * Select label values.
     * 
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @return the list
     */
    List<LabelValueVO> selectLabelValues(final TipoSubservicioCriterioVO tpssCriterioVO);

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo subservicio vo
     */
    TipoSubservicioVO select(final Long id);
}
