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
    List<FuncionalidadGrupoVO> selectList(final @NonNull FuncionalidadGrupoCriterioVO fngrCriterio);

    /**
     * Insert.
     *
     * @param fngr
     *            the fngr
     */
    void insert(final @NonNull FuncionalidadGrupoVO fngr);

    /**
     * Delete list.
     *
     * @param fngrCriterio
     *            the fngr criterio
     * @return the int
     */
    int deleteList(final @NonNull FuncionalidadGrupoCriterioVO fngrCriterio);
}
