package xeredi.integra.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * DAO de acceso a las valoraciones de la aplicacion.
 */
public interface ValoracionDAO {

    /**
     * Alta de los datos de una valoracion.
     *
     * @param vlrcVO
     *            Datos de una valoracion
     */
    void insert(final ValoracionVO vlrcVO);

    /**
     * Update.
     *
     * @param vlrcVO
     *            the vlrc vo
     * @return the int
     */
    int update(final ValoracionVO vlrcVO);

    /**
     * Borrado de las valoraciones que cumplan un criterio de busqueda.
     *
     * @param vlrcCriterioVO
     *            Criterio de busqueda de valoraciones.
     * @return Numero de filas modificadas.
     */
    int delete(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Busqueda de los datos de una valoracion a partir de su identificador.
     *
     * @param vlrcCriterio
     *            the vlrc criterio
     * @return Datos de la valoracion buscada.
     */
    ValoracionVO selectObject(final ValoracionCriterioVO vlrcCriterio);

    /**
     * Busqueda de una lista de valoraciones que cumplan un criterio de busqueda.
     *
     * @param vlrcCriterioVO
     *            Criterio de busqueda de valoraciones.
     * @return {@link List} de valoraciones que cumplan el criterio de busqueda.
     */
    List<ValoracionVO> selectList(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Cuenta del numero de valoraciones que cumplan un criterio de busqueda.
     *
     * @param vlrcCriterioVO
     *            Criterio de busqueda de valoraciones.
     * @return Numero de valoraciones que cumplen el criterio de busqueda.
     */
    int count(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Busqueda de una pagina de una lista de valoraciones que cumplan un criterio de busqueda.
     *
     * @param vlrcCriterioVO
     *            Criterio de busqueda de valoraciones.
     * @param bounds
     *            Limites de la pagina.
     * @return {@link List} de valoraciones que cumplan el criterio de busqueda.
     */
    List<ValoracionVO> selectPaginatedList(final ValoracionCriterioVO vlrcCriterioVO, final RowBounds bounds);
}
