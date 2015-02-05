package xeredi.integra.model.servicio.dao.pesca;

import javax.annotation.Nonnull;

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
    public int updateRecalcularImporte(final @Nonnull Long srvcId);

    /**
     * Update recalcular peso.
     *
     * @param srvcId
     *            the srvc id
     * @return the int
     */
    public int updateRecalcularPeso(final @Nonnull Long srvcId);
}
