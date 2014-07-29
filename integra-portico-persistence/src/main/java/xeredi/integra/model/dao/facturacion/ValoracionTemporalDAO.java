package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.ValoracionTemporalVO;
import xeredi.integra.model.vo.facturacion.ValoradorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionTemporalDAO.
 */
public interface ValoracionTemporalDAO {

    /**
     * Select aplicar regla servicio.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionTemporalVO> selectAplicarReglaServicio(final ValoradorContextoVO contextoVO);

    /**
     * Select aplicar regla decorador servicio.
     *
     * @param contextoVO the contexto vo
     * @return the list
     */
    List<ValoracionTemporalVO> selectAplicarReglaDecoradorServicio(final ValoradorContextoVO contextoVO);

    /**
     * Select aplicar regla subservicio.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionTemporalVO> selectAplicarReglaSubservicio(final ValoradorContextoVO contextoVO);

    /**
     * Select aplicar regla decorador subservicio.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionTemporalVO> selectAplicarReglaDecoradorSubservicio(final ValoradorContextoVO contextoVO);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final ValoracionTemporalVO vo);
}
