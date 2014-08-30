package xeredi.integra.model.maestro.vo;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroCriterioVO.
 */
public final class ParametroCriterioVO extends ItemCriterioVO {
    /** The prvr ids. */
    private Set<Long> prvrIds;

    /** The parametro. */
    private String parametro;

    /** The parametros. */
    private Set<String> parametros;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the prvr ids.
     *
     * @return the prvr ids
     */
    public Set<Long> getPrvrIds() {
        return prvrIds;
    }

    /**
     * Sets the prvr ids.
     *
     * @param value
     *            the new prvr ids
     */
    public void setPrvrIds(final Set<Long> value) {
        prvrIds = value;
    }

    /**
     * Gets the parametro.
     *
     * @return the parametro
     */
    public String getParametro() {
        return parametro;
    }

    /**
     * Sets the parametro.
     *
     * @param value
     *            the new parametro
     */
    public void setParametro(final String value) {
        if (value != null) {
            parametro = value.trim().toUpperCase();
        }
    }

    /**
     * Gets the parametros.
     *
     * @return the parametros
     */
    public Set<String> getParametros() {
        return parametros;
    }

    /**
     * Sets the parametros.
     *
     * @param value
     *            the new parametros
     */
    public void setParametros(final Set<String> value) {
        parametros = value;
    }
}
