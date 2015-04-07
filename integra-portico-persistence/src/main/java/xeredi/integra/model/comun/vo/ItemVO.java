package xeredi.integra.model.comun.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemVO.
 */
public abstract class ItemVO implements ItemEntidad {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The itdt map. */
    private Map<Long, ItemDatoVO> itdtMap;

    /**
     * Gets the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @return the itdt
     */
    public final ItemDatoVO getItdt(final @Nonnull Long tpdtId) {
        return itdtMap == null ? null : itdtMap.get(tpdtId);
    }

    /**
     * Adds the itdt.
     *
     * @param tpdtId
     *            the tpdt id
     * @param value
     *            the value
     */
    public final void addItdt(final @Nonnull Long tpdtId, final Long value) {
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
    public final void addItdt(final @Nonnull Long tpdtId, final Double value) {
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
    public final void addItdt(final @Nonnull Long tpdtId, final String value) {
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
    public final void addItdt(final @Nonnull Long tpdtId, final ParametroVO value) {
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
    public final void addItdt(final @Nonnull Long tpdtId, final ServicioVO value) {
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
    public final void addItdt(final @Nonnull Long tpdtId, final Date value) {
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
    private final void addItdt(final ItemDatoVO itdt) {
        if (itdtMap == null) {
            itdtMap = new HashMap<>();
        }

        itdtMap.put(itdt.getTpdtId(), itdt);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @Override
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    @Override
    public final void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    public final Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value
     *            the new enti id
     */
    public final void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the itdt map.
     *
     * @return the itdt map
     */
    public final Map<Long, ItemDatoVO> getItdtMap() {
        return itdtMap;
    }

    /**
     * Sets the itdt map.
     *
     * @param value
     *            the value
     */
    public final void setItdtMap(final Map<Long, ItemDatoVO> value) {
        itdtMap = value;
    }

}
