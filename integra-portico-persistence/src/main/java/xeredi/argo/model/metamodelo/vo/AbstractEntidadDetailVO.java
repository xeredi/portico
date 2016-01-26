package xeredi.argo.model.metamodelo.vo;

import java.util.ArrayList;
import java.util.HashMap;
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
    private List<EntidadGrupoDatoVO> engdList = new ArrayList<>();

    /**
     * {@link List} de Ids de tipos de dato asociados a una entidad, ordenados por grupo de dato, fila y orden
     * dentro de la fila.
     */
    private List<Long> entdList = new ArrayList<>();

    /** The entd grid list. */
    private List<Long> entdGridList = new ArrayList<>();

    /** The entd map. */
    private Map<Long, EntidadTipoDatoVO> entdMap = new HashMap<>();

    /** {@link List} de identificadores de entidades padre de la entidad. */
    private List<Long> entiPadresList = new ArrayList<>();

    /** {@link List} de identificadores de entidades hija de la entidad. */
    private List<Long> entiHijasList = new ArrayList<>();

    /** {@link List} de acciones web que se pueden realizar sobre la entidad. */
    private List<EntidadAccionVO> enacList = new ArrayList<>();

    /** {@link List} de acciones web que se pueden realizar sobre el grid de la entidad. */
    private List<EntidadAccionGridVO> enagList = new ArrayList<>();

    /** The trmt list. */
    private List<TramiteVO> trmtList = new ArrayList<>();

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public abstract EntidadVO getEnti();
}
