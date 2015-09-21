package xeredi.argo.model.facturacion.dao;

import java.util.Date;

import xeredi.argo.model.facturacion.vo.ValoradorContextoVO;

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
    Date selectFref(final ValoradorContextoVO contextoVO);

    /**
     * Select fini.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the date
     */
    Date selectFini(final ValoradorContextoVO contextoVO);

    /**
     * Select ffin.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the date
     */
    Date selectFfin(final ValoradorContextoVO contextoVO);
}
