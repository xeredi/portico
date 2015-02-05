package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.ValoracionTemporalVO;
import xeredi.integra.model.facturacion.vo.ValoradorContextoVO;

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
    List<ValoracionTemporalVO> selectAplicarReglaServicio(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Select aplicar regla decorador servicio.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionTemporalVO> selectAplicarReglaDecoradorServicio(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Select aplicar regla subservicio.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionTemporalVO> selectAplicarReglaSubservicio(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Select aplicar regla decorador subservicio.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionTemporalVO> selectAplicarReglaDecoradorSubservicio(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Exists pendiente.
     *
     * @param contextoVO
     *            the contexto vo
     * @return true, if successful
     */
    boolean existsPendiente(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final @Nonnull ValoracionTemporalVO vo);

    /**
     * Delete temporal list.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the int
     */
    int deleteList(final @Nonnull ValoradorContextoVO contextoVO);

    /**
     * Delete incompatibilidad list.
     *
     * @param vlrt
     *            the vlrt
     * @return the int
     */
    int deleteIncompatibilidadList(final @Nonnull ValoracionTemporalVO vlrt);

    /**
     * Update recalcular cargo.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the int
     */
    int updateRecalcularCargo(final @Nonnull ValoradorContextoVO contextoVO);
}
