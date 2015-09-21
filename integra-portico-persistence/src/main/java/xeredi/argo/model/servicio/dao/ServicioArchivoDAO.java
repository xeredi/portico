package xeredi.argo.model.servicio.dao;

import java.util.List;

import xeredi.argo.model.proceso.vo.ProcesoArchivoVO;
import xeredi.argo.model.servicio.vo.ServicioArchivoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioArchivoDAO.
 */
public interface ServicioArchivoDAO {

    /**
     * Insert.
     *
     * @param srar
     *            the srar
     */
    void insert(final ServicioArchivoVO srar);

    /**
     * Delete.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int deleteList(final Long srvcId);

    /**
     * Select list.
     *
     * @param srvcId
     *            the srvc id
     * @return the list
     */
    List<ProcesoArchivoVO> selectList(final Long srvcId);

}
