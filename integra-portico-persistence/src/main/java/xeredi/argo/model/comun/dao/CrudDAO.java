package xeredi.argo.model.comun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * Interfaz base de todos los DAO de la aplicación.
 *
 * @param <T>
 *            Clase de Item
 * @param <C>
 *            Clase de criterio de búsqueda de items.
 */
public interface CrudDAO<T, C extends BaseCriterioVO> {

    /**
     * Inserción de los datos de un nuevo item.
     *
     * @param item
     *            the item
     */
    void insert(final T item);

    /**
     * Modificación de los datos de un item.
     *
     * @param item
     *            the item
     * @return Nº de filas modificadas.
     */
    int update(final T item);

    /**
     * Delete.
     *
     * @param item
     *            the item
     * @return the int
     */
    int delete(final T item);

    /**
     * Delete list.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int deleteList(final C criterio);

    /**
     * Exists.
     *
     * @param item
     *            the item
     * @return true, if successful
     */
    boolean exists(final T item);

    /**
     * Select label value list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<LabelValueVO> selectLabelValueList(final C criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<T> selectList(final C criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<T> selectList(final C criterio, final RowBounds bounds);

    /**
     * Count.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int count(final C criterio);

    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the t
     */
    T selectObject(final C criterio);
}
