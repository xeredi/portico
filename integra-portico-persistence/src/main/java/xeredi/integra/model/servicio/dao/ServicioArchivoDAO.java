package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.servicio.vo.ServicioArchivoVO;

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
    void insert(final @Nonnull ServicioArchivoVO srar);

    /**
     * Delete.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    int deleteList(final @Nonnull Long srvcId);

    /**
     * Select list.
     *
     * @param srvcId
     *            the srvc id
     * @return the list
     */
    List<ProcesoArchivoVO> selectList(final @Nonnull Long srvcId);

}
