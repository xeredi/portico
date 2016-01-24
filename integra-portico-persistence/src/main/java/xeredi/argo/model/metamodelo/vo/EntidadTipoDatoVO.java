package xeredi.argo.model.metamodelo.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroTipoDatoVO.
 */
@Data
public final class EntidadTipoDatoVO {

    /** The id. */
    private Long id;

    /** The tppr id. */
    private Long entiId;

    /** The tpdt. */
    private TipoDatoVO tpdt;

    /** The grupo. */
    private Integer grupo;

    /** The fila. */
    private Integer fila;

    /** The orden. */
    private Integer orden;

    /** The span. */
    private Integer span;

    /** The obligatorio. */
    private Boolean obligatorio;

    /** The gridable. */
    private Boolean gridable;

    /** The filtrable. */
    private Boolean filtrable;

    /** The valor defecto. */
    private String valorDefecto;

    /** The etiqueta. */
    private String etiqueta;

    /**
     * Gets the span normalizado.
     *
     * @param span
     *            the span
     * @return the span normalizado
     */
    private Integer getSpanNormalizado(final Double span) {
        if (span == null) {
            return null;
        }

        if (span < 1) {
            return 1;
        }

        if (span > 12) {
            return 12;
        }

        return (int) Math.round(span);
    }

    /**
     * Gets the span xl.
     *
     * @return the span xl
     */
    public Integer getSpanXl() {
        if (span == null) {
            return null;
        }

        return getSpanNormalizado(span / 1.61);
    }

    /**
     * Gets the span lg.
     *
     * @return the span lg
     */
    public Integer getSpanLg() {
        if (span == null) {
            return null;
        }

        return getSpanNormalizado(span / 1.21);
    }

    /**
     * Gets the span sm.
     *
     * @return the span sm
     */
    public Integer getSpanSm() {
        if (span == null) {
            return null;
        }

        return getSpanNormalizado(span * 1.29);
    }
}
