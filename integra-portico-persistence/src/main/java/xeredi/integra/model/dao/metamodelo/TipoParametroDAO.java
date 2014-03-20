package xeredi.integra.model.dao.metamodelo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.metamodelo.TipoParametroCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoParametroDAO.
 */
public interface TipoParametroDAO {

    /**
     * Select all.
     * 
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the list
     */
    List<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO);

    /**
     * Select all.
     * 
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO, final RowBounds bounds);

    /**
     * Select label values.
     * 
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the list
     */
    List<LabelValueVO> selectLabelValues(final TipoParametroCriterioVO tpprCriterioVO);

    /**
     * Select.
     * 
     * @param tpprId
     *            the tppr id
     * @return the tipo parametro vo
     */
    TipoParametroVO select(final Long tpprId);

    /**
     * Count.
     * 
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the int
     */
    int count(final TipoParametroCriterioVO tpprCriterioVO);

    /**
     * Insert.
     * 
     * @param tpprVO
     *            the tppr vo
     */
    void insert(final TipoParametroVO tpprVO);

    /**
     * Update.
     * 
     * @param tpprVO
     *            the tppr vo
     * @return the int
     */
    int update(final TipoParametroVO tpprVO);

    /**
     * Delete.
     * 
     * @param tpprId
     *            the tppr id
     * @return the int
     */
    int delete(final Long tpprId);

}
