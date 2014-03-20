package xeredi.integra.model.vo.proceso;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.util.pagination.Criterio;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCriterioVO.
 */
public final class ProcesoCriterioVO implements Criterio {

    /** The modulo. */
    private ProcesoModulo modulo;

    /** The tipo. */
    private ProcesoTipo tipo;

    /** The estado. */
    private ProcesoEstado estado;

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

        if (modulo != null) {
            map.put("modulo", modulo);
        }
        if (tipo != null) {
            map.put("tipo", tipo);
        }
        if (estado != null) {
            map.put("estado", estado);
        }

        return map;
    }

    /**
     * Gets the modulo.
     *
     * @return the modulo
     */
    public ProcesoModulo getModulo() {
        return modulo;
    }

    /**
     * Sets the modulo.
     *
     * @param value
     *            the new modulo
     */
    public void setModulo(final ProcesoModulo value) {
        modulo = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ProcesoTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the new tipo
     */
    public void setTipo(final ProcesoTipo value) {
        tipo = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public ProcesoEstado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the new estado
     */
    public void setEstado(final ProcesoEstado value) {
        estado = value;
    }

}
