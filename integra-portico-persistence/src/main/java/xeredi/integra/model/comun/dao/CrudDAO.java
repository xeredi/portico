package xeredi.integra.model.comun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

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
     * @param t
     *            Datos del nuevo item.
     */
    void insert(final T t);

    /**
     * Modificación de los datos de un item.
     *
     * @param t
     *            Nuevos datos del item.
     * @return Nº de filas modificadas.
     */
    int update(final T t);

    /**
     * Delete.
     *
     * @param t
     *            the t
     * @return the int
     */
    int delete(final T t);

    /**
     * Delete list.
     *
     * @param c
     *            the c
     * @return the int
     */
    int deleteList(final C c);

    /**
     * Exists.
     *
     * @param t
     *            the t
     * @return true, if successful
     */
    boolean exists(final T t);

    /**
     * Select list.
     *
     * @param c
     *            the c
     * @return the list
     */
    List<T> selectList(final C c);

    /**
     * Select list.
     *
     * @param c
     *            the c
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<T> selectList(final C c, final RowBounds bounds);

    /**
     * Count.
     *
     * @param c
     *            the c
     * @return the int
     */
    int count(final C c);

    /**
     * Select object.
     *
     * @param c
     *            the c
     * @return the t
     */
    T selectObject(final C c);
}
