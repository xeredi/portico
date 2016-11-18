package xeredi.argo.model.seguridad.dao;

import lombok.NonNull;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioGrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioGrupoDAO.
 */
public interface UsuarioGrupoDAO {

    /**
     * Insert.
     *
     * @param usgr
     *            the usgr
     */
    void insert(@NonNull final UsuarioGrupoVO usgr);

    /**
     * Delete list.
     *
     * @param usgrCriterio
     *            the usgr criterio
     * @return the int
     */
    int deleteList(@NonNull final UsuarioGrupoCriterioVO usgrCriterio);
}
