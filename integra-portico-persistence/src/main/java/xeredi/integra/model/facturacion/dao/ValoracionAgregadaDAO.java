package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.ValoracionAgregadaVO;
import xeredi.integra.model.facturacion.vo.ValoradorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionAgregadaDAO.
 */
public interface ValoracionAgregadaDAO {

    /**
     * Select list.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionAgregadaVO> selectList(final @Nonnull ValoradorContextoVO contextoVO);
}
