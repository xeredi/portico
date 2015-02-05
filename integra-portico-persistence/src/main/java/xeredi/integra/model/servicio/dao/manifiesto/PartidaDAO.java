package xeredi.integra.model.servicio.dao.manifiesto;

import javax.annotation.Nonnull;

// TODO: Auto-generated Javadoc
/**
 * The Interface PartidaDAO.
 */
public interface PartidaDAO {

    /**
     * Update bloquear from equipamiento.
     *
     * @param equiId
     *            the equi id
     * @return the int
     */
    int updateBloquearFromEquipamiento(final @Nonnull Long equiId);

    /**
     * Update iniciar from equipamiento.
     *
     * @param equiId
     *            the equi id
     * @return the int
     */
    int updateIniciarFromEquipamiento(final @Nonnull Long equiId);

}
