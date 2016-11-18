package xeredi.argo.model.seguridad.dao;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.FuncionalidadGrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FuncionalidadGrupoDAO.
 */
public interface FuncionalidadGrupoDAO {

    /**
     * Select list.
     *
     * @param fngrCriterio
     *            the fngr criterio
     * @return the list
     */
    List<FuncionalidadGrupoVO> selectList(@NonNull final FuncionalidadGrupoCriterioVO fngrCriterio);

    /**
     * Insert.
     *
     * @param fngr
     *            the fngr
     */
    void insert(@NonNull final FuncionalidadGrupoVO fngr);

    /**
     * Delete list.
     *
     * @param fngrCriterio
     *            the fngr criterio
     * @return the int
     */
    int deleteList(@NonNull final FuncionalidadGrupoCriterioVO fngrCriterio);
}
