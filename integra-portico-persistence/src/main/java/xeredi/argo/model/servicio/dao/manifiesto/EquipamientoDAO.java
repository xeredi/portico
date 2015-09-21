package xeredi.argo.model.servicio.dao.manifiesto;


// TODO: Auto-generated Javadoc
/**
 * The Interface EquipamientoDAO.
 */
public interface EquipamientoDAO {

    /**
     * Update bloquear from partida.
     *
     * @param partId
     *            the part id
     * @return the int
     */
    int updateBloquearFromPartida(final Long partId);

    /**
     * Update iniciar from partida.
     *
     * @param partId
     *            the part id
     * @return the int
     */
    int updateIniciarFromPartida(final Long partId);
}
