package xeredi.integra.model.servicio.dao.manifiesto;

import javax.annotation.Nonnull;

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
    int updateBloquearFromPartida(final @Nonnull Long partId);

    /**
     * Update iniciar from partida.
     *
     * @param partId
     *            the part id
     * @return the int
     */
    int updateIniciarFromPartida(final @Nonnull Long partId);
}
