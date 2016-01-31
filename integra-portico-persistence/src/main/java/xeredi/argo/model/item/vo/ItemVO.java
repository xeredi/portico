package xeredi.argo.model.item.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NonNull;
import xeredi.argo.model.comun.vo.ItemEntidad;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemVO.
 */
@Data
public abstract class ItemVO implements ItemEntidad {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The fref. */
    private Date fref;

    /** The itdt map. */
    private Map<Long, ItemDatoVO> itdtMap = new HashMap<>();

    protected ItemVO() {
        super();
    }

    /**
     * Gets the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt
     */
    public final ItemDatoVO getItdt(final @NonNull Long tpdtId) {
        return itdtMap.get(tpdtId);
    }

    /**
     * Adds the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @param value
     *            the value
     */
    public final void addItdt(final @NonNull Long tpdtId, final Long value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdtId);
        itdt.setCantidadEntera(value);

        addItdt(itdt);
    }

    /**
     * Adds the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @param value
     *            the value
     */
    public final void addItdt(final @NonNull Long tpdtId, final Double value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdtId);
        itdt.setCantidadDecimal(value);

        addItdt(itdt);
    }

    /**
     * Adds the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @param value
     *            the value
     */
    public final void addItdt(final @NonNull Long tpdtId, final String value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdtId);
        itdt.setCadena(value);

        addItdt(itdt);
    }

    /**
     * Adds the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @param value
     *            the value
     */
    public final void addItdt(final @NonNull Long tpdtId, final ParametroVO value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdtId);
        itdt.setPrmt(value);

        addItdt(itdt);
    }

    /**
     * Adds the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @param value
     *            the value
     */
    public final void addItdt(final @NonNull Long tpdtId, final ServicioVO value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdtId);
        itdt.setSrvc(value);

        addItdt(itdt);
    }

    /**
     * Adds the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @param value
     *            the value
     */
    public final void addItdt(final @NonNull Long tpdtId, final Date value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdtId);
        itdt.setFecha(value);

        addItdt(itdt);
    }

    /**
     * Adds the itdt.
     *
     * @param itdt
     *            the itdt
     */
    private final void addItdt(final @NonNull ItemDatoVO itdt) {
        itdtMap.put(itdt.getTpdtId(), itdt);
    }

    /**
     * Gets the itdt fecha.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt fecha
     */
    public final Date getItdtFecha(final @NonNull Long tpdtId) {
        return itdtMap.containsKey(tpdtId) ? itdtMap.get(tpdtId).getFecha() : null;
    }

    /**
     * Gets the itdt prmt.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt prmt
     */
    public final ParametroVO getItdtPrmt(final @NonNull Long tpdtId) {
        return itdtMap.containsKey(tpdtId) ? itdtMap.get(tpdtId).getPrmt() : null;
    }

    /**
     * Gets the itdt srvc.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt srvc
     */
    public final ServicioVO getItdtSrvc(final @NonNull Long tpdtId) {
        return itdtMap.containsKey(tpdtId) ? itdtMap.get(tpdtId).getSrvc() : null;
    }

    /**
     * Gets the itdt entero.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt entero
     */
    public final Long getItdtEntero(final @NonNull Long tpdtId) {
        return itdtMap.containsKey(tpdtId) ? itdtMap.get(tpdtId).getCantidadEntera() : null;
    }

    /**
     * Gets the itdt decimal.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt decimal
     */
    public final Double getItdtDecimal(final @NonNull Long tpdtId) {
        return itdtMap.containsKey(tpdtId) ? itdtMap.get(tpdtId).getCantidadDecimal() : null;
    }

    /**
     * Gets the itdt booleano.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt booleano
     */
    public final Boolean getItdtBooleano(final @NonNull Long tpdtId) {
        return itdtMap.containsKey(tpdtId) ? itdtMap.get(tpdtId).getCantidadEntera() == 1 : null;
    }

    /**
     * Gets the itdt cadena.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt cadena
     */
    public final String getItdtCadena(final @NonNull Long tpdtId) {
        return itdtMap.containsKey(tpdtId) ? itdtMap.get(tpdtId).getCadena() : null;
    }
}
