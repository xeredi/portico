package xeredi.integra.model.maestro.vo;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.comun.vo.ItemTypeahead;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroCriterioVO.
 */
public final class ParametroCriterioVO extends ItemCriterioVO implements ItemTypeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The prvr id. */
    private Long versionId;

    /** The prvr ids. */
    private Set<Long> versionIds;

    /** The parametro. */
    private String parametro;

    /** The parametros. */
    private Set<String> parametros;

    /** The prto. */
    private PuertoCriterioVO prto;

    /** The sprm map. */
    private Map<Long, SubparametroVO> sprmMap;

    /**
     * Gets the prvr ids.
     *
     * @return the prvr ids
     */
    public Set<Long> getVersionIds() {
        return versionIds;
    }

    /**
     * Sets the prvr ids.
     *
     * @param value
     *            the new prvr ids
     */
    public void setVersionIds(final Set<Long> value) {
        versionIds = value;
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
    public Long getVersionId() {
        return versionId;
    }

    /**
     * Sets the prvr id.
     *
     * @param value
     *            the new prvr id
     */
    public void setVersionId(final Long value) {
        versionId = value;
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

    /**
     * Gets the sprm map.
     *
     * @return the sprm map
     */
    public Map<Long, SubparametroVO> getSprmMap() {
        return sprmMap;
    }

    /**
     * Sets the sprm map.
     *
     * @param value
     *            the value
     */
    public void setSprmMap(final Map<Long, SubparametroVO> value) {
        sprmMap = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTextoBusqueda(final String value) {
        textoBusqueda = value;
    }
}
