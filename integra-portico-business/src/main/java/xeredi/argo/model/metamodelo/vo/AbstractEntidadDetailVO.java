package xeredi.argo.model.metamodelo.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NonNull;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEntidadDetailVO.
 */

/**
 * Instantiates a new abstract entidad detail vo.
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
    private Map<AccionCodigo, AccionEntidadVO> acenMap = new HashMap<>();

    /** {@link List} de acciones web que se pueden realizar sobre la entidad. */
    private List<AccionEspecialVO> acesList = new ArrayList<>();

    /** The trmt list. */
    private List<TramiteVO> trmtList = new ArrayList<>();

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public abstract EntidadVO getEnti();

    /**
     * Fill item.
     *
     * @param item
     *            the item
     */
    protected final void fillItem(@NonNull final ItemVO item) {
        item.setEntiId(getEnti().getId());

        for (final EntidadTipoDatoVO entd : entdMap.values()) {
            final ItemDatoVO itdt = new ItemDatoVO();

            itdt.setTpdtId(entd.getTpdt().getId());

            item.getItdtMap().put(itdt.getTpdtId(), itdt);
        }
    }
}
