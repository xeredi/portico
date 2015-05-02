package xeredi.integra.model.metamodelo.proxy;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEntidadDetailVO.
 */
public abstract class AbstractEntidadDetailVO {
    /**
     * Lista de Grupos de Datos de la Entidad (Pestañas) ordenadas por orden de visualización.
     */
    private List<EntidadGrupoDatoVO> engdList;

    /**
     * {@link List} de Ids de tipos de dato asociados a una entidad, ordenados por grupo de dato, fila y orden
     * dentro de la fila.
     */
    private List<Long> entdList;

    /** The entd map. */
    private Map<Long, EntidadTipoDatoVO> entdMap;

    /** {@link List} de identificadores de entidades padre de la entidad. */
    private List<Long> entiPadresList;

    /** {@link List} de identificadores de entidades hija de la entidad. */
    private List<Long> entiHijasList;

    /** {@link List} de acciones web que se pueden realizar sobre la entidad. */
    private List<EntidadAccionVO> enacList;

    /** {@link List} de acciones web que se pueden realizar sobre el grid de la entidad. */
    private List<EntidadAccionGridVO> enagList;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public abstract EntidadVO getEnti();

    /**
     * Gets the engd list.
     *
     * @return the engd list
     */
    public final List<EntidadGrupoDatoVO> getEngdList() {
        return engdList;
    }

    /**
     * Sets the engd list.
     *
     * @param value
     *            the new engd list
     */
    public final void setEngdList(final List<EntidadGrupoDatoVO> value) {
        engdList = value;
    }

    /**
     * Gets the enti padres list.
     *
     * @return the enti padres list
     */
    public final List<Long> getEntiPadresList() {
        return entiPadresList;
    }

    /**
     * Sets the enti padres list.
     *
     * @param value
     *            the new enti padres list
     */
    public final void setEntiPadresList(final List<Long> value) {
        entiPadresList = value;
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public final List<Long> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Sets the enti hijas list.
     *
     * @param value
     *            the new enti hijas list
     */
    public final void setEntiHijasList(final List<Long> value) {
        entiHijasList = value;
    }

    /**
     * Gets the enac list.
     *
     * @return the enac list
     */
    public final List<EntidadAccionVO> getEnacList() {
        return enacList;
    }

    /**
     * Sets the enac list.
     *
     * @param value
     *            the new enac list
     */
    public final void setEnacList(final List<EntidadAccionVO> value) {
        enacList = value;
    }

    /**
     * Gets the enag list.
     *
     * @return the enag list
     */
    public final List<EntidadAccionGridVO> getEnagList() {
        return enagList;
    }

    /**
     * Sets the enag list.
     *
     * @param value
     *            the new enag list
     */
    public final void setEnagList(final List<EntidadAccionGridVO> value) {
        enagList = value;
    }

    /**
     * Gets the entd list.
     *
     * @return the entd list
     */
    public List<Long> getEntdList() {
        return entdList;
    }

    /**
     * Sets the entd list.
     *
     * @param value
     *            the new entd list
     */
    public void setEntdList(final List<Long> value) {
        entdList = value;
    }

    /**
     * Gets the entd map.
     *
     * @return the entd map
     */
    public Map<Long, EntidadTipoDatoVO> getEntdMap() {
        return entdMap;
    }

    /**
     * Sets the entd map.
     *
     * @param value
     *            the value
     */
    public void setEntdMap(final Map<Long, EntidadTipoDatoVO> value) {
        entdMap = value;
    }
}
