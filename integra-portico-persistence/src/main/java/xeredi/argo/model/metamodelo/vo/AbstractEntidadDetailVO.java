package xeredi.argo.model.metamodelo.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEntidadDetailVO.
 */
@Data
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

    /** The entd grid list. */
    private List<Long> entdGridList;

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

    /** The trmt list. */
    private List<TramiteVO> trmtList;

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public abstract EntidadVO getEnti();
}
