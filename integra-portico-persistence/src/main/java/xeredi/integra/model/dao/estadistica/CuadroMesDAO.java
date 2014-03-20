package xeredi.integra.model.dao.estadistica;

import java.util.List;

import xeredi.integra.model.vo.estadistica.CuadroMesVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CuadroMesDAO.
 */
public interface CuadroMesDAO {

    /**
     * Exists.
     * 
     * @param peprId
     *            the pepr id
     * @return true, if successful
     */
    boolean exists(final Long peprId);

    /**
     * Delete.
     * 
     * @param peprId
     *            the pepr id
     * @return the int
     */
    int delete(final Long peprId);

    /**
     * Select list.
     * 
     * @param peprId
     *            the pepr id
     * @return the list
     */
    public List<CuadroMesVO> selectList(final Long peprId);
}
