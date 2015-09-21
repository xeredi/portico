package xeredi.argo.model.servicio.dao.manifiesto;


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
    int updateBloquearFromEquipamiento(final Long equiId);

    /**
     * Update iniciar from equipamiento.
     *
     * @param equiId
     *            the equi id
     * @return the int
     */
    int updateIniciarFromEquipamiento(final Long equiId);

}
