package xeredi.integra.model.vo.estadistica;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoCriterioVO.
 */
public final class PeriodoProcesoCriterioVO implements Criterio {

    /** The id. */
    private Long id;

    /** The autp id. */
    private Long autpId;

    /** The anio. */
    private Integer anio;

    /** The mes. */
    private Integer mes;

    /** The trimestre. */
    private Integer trimestre;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getSearchLinks() {
        final Map<String, Object> map = new HashMap<>();

        if (autpId != null) {
            map.put("autpId", autpId);
        }
        if (anio != null) {
            map.put("anio", anio);
        }
        if (mes != null) {
            map.put("mes", mes);
        }

        return map;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the autp id.
     *
     * @return the autp id
     */
    public Long getAutpId() {
        return autpId;
    }

    /**
     * Sets the autp id.
     *
     * @param value
     *            the new autp id
     */
    public void setAutpId(final Long value) {
        autpId = value;
    }

    /**
     * Gets the anio.
     *
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * Sets the anio.
     *
     * @param value
     *            the new anio
     */
    public void setAnio(final Integer value) {
        anio = value;
    }

    /**
     * Gets the mes.
     *
     * @return the mes
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * Sets the mes.
     *
     * @param value
     *            the new mes
     */
    public void setMes(final Integer value) {
        mes = value;
    }

    /**
     * Gets the trimestre.
     *
     * @return the trimestre
     */
    public Integer getTrimestre() {
        return trimestre;
    }

    /**
     * Sets the trimestre.
     *
     * @param value
     *            the new trimestre
     */
    public void setTrimestre(final Integer value) {
        trimestre = value;
    }

}
