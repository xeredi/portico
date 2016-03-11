package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * DAO de acceso a las valoraciones de la aplicacion.
 */
public interface ValoracionDAO extends CrudDAO<ValoracionVO, ValoracionCriterioVO> {

    /**
     * Update fctr.
     *
     * @param vlrc the vlrc
     * @return the int
     */
    int updateFctr(final ValoracionVO vlrc);

    /**
     * Update importe.
     *
     * @param id the id
     * @return the int
     */
    int updateImporte(final Long id);
}
