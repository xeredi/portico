package xeredi.integra.model.dao.facturacion;

import java.util.Date;

import xeredi.integra.model.vo.facturacion.ValoradorContextoVO;

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
