package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.servicio.vo.ServicioArchivoVO;

public interface ServicioArchivoDAO {
    /**
     * Insert.
     *
     * @param prarVO
     *            the prar vo
     */
    void insert(final @Nonnull ServicioArchivoVO srarVO);

    /**
     * Delete.
     *
     * @param prbtId
     *            the prbt id
     * @return the int
     */
    int deleteList(final @Nonnull Long srvcId);

    /**
     * Select list.
     *
     * @param prbtId
     *            the prbt id
     * @return the list
     */
    List<ProcesoArchivoVO> selectList(final @Nonnull Long srvcId);

}
