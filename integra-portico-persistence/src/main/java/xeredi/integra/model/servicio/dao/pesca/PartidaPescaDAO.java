package xeredi.integra.model.servicio.dao.pesca;


// TODO: Auto-generated Javadoc
/**
 * The Interface PartidaPescaDAO.
 */
public interface PartidaPescaDAO {

    /**
     * Update recalcular importe.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    public int updateRecalcularImporte(final Long ssrvId);

    /**
     * Update recalcular precio.
     *
     * @param ssrvId
     *            the ssrv id
     * @return the int
     */
    public int updateRecalcularPrecio(final Long ssrvId);
}
