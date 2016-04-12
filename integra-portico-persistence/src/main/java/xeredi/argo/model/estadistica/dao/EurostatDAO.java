package xeredi.argo.model.estadistica.dao;

import java.util.List;

import xeredi.argo.model.estadistica.vo.EurostatCriterioVO;
import xeredi.argo.model.estadistica.vo.EurostatVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EurostatDAO.
 */
public interface EurostatDAO {

    /**
     * Select a1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectA1List(final EurostatCriterioVO criterio);

    /**
     * Select a2 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectA2List(final EurostatCriterioVO criterio);

    /**
     * Select a3 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectA3List(final EurostatCriterioVO criterio);

    /**
     * Select b1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectB1List(final EurostatCriterioVO criterio);

    /**
     * Select c1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectC1List(final EurostatCriterioVO criterio);

    /**
     * Select d1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectD1List(final EurostatCriterioVO criterio);

    /**
     * Select e1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectE1List(final EurostatCriterioVO criterio);

    /**
     * Select f1 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectF1List(final EurostatCriterioVO criterio);

    /**
     * Select f2 list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<EurostatVO> selectF2List(final EurostatCriterioVO criterio);
}
