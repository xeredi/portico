package xeredi.integra.model.facturacion.dao;

import java.util.Date;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.ValoradorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoradorContextoDAO.
 */
public interface ValoradorContextoDAO {

    /**
     * Select fref.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the date
     */
    Date selectFref(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Select fini.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the date
     */
    Date selectFini(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Select ffin.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the date
     */
    Date selectFfin(final @Nonnull ValoradorContextoVO contextoVO);
}
