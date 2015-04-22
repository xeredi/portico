package xeredi.integra.model.maestro.vo;

import java.util.Date;
import java.util.Set;

import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroCriterioVO.
 */
public final class ParametroCriterioVO extends ItemCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The prvr id. */
    private Long prvrId;

    /** The prvr ids. */
    private Set<Long> prvrIds;

    /** The parametro. */
    private String parametro;

    /** The parametros. */
    private Set<String> parametros;

    /** The prto. */
    private PuertoCriterioVO prto;

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

    /**
     * Gets the prvr id.
     *
     * @return the prvr id
     */
    public Long getPrvrId() {
        return prvrId;
    }

    /**
     * Sets the prvr id.
     *
     * @param value
     *            the new prvr id
     */
    public void setPrvrId(final Long value) {
        prvrId = value;
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoCriterioVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoCriterioVO value) {
        prto = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }
}
