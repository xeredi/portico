package xeredi.argo.model.facturacion.dao;

import java.util.Date;

import lombok.NonNull;
import xeredi.argo.model.facturacion.vo.ValoradorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoradorContextoDAO.
 */
public interface ValoradorContextoDAO {

    /**
     * Select fref.
     *
     * @param vldrContexto
     *            the contexto vo
     * @return the date
     */
    Date selectFref(@NonNull final ValoradorContextoVO vldrContexto);

    /**
     * Select fini.
     *
     * @param vldrContexto
     *            the contexto vo
     * @return the date
     */
    Date selectFini(@NonNull final ValoradorContextoVO vldrContexto);

    /**
     * Select ffin.
     *
     * @param vldrContexto
     *            the contexto vo
     * @return the date
     */
    Date selectFfin(@NonNull final ValoradorContextoVO vldrContexto);
}
