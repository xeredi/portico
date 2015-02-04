package xeredi.integra.model.servicio.dao.pesca;

// TODO: Auto-generated Javadoc
/**
 * The Interface ManifiestoPescaDAO.
 */
public interface ManifiestoPescaDAO {

    /**
     * Update recalcular importe.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    public int updateRecalcularImporte(final Long srvcId);

    /**
     * Update recalcular peso.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    public int updateRecalcularPeso(final Long srvcId);
}
