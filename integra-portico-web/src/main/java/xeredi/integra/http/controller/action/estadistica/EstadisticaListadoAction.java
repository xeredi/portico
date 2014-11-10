package xeredi.integra.http.controller.action.estadistica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.comun.vo.ItemDatoCriterioVO;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaListadoAction.
 */
public final class EstadisticaListadoAction extends ItemListadoAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3980612360200744744L;

    /** The enti. */
    private TipoEstadisticaVO enti;

    /** The estds. */
    private PaginatedList<EstadisticaVO> itemList;

    /** The estd criterio form. */
    private EstadisticaCriterioVO itemCriterio;

    /** The subp list. */
    private final List<ParametroVO> subpList = new ArrayList<>();

    // Acciones web
    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("estd-filter")
    public String filtro() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());
        Preconditions.checkNotNull(itemCriterio.getPepr());
        Preconditions.checkNotNull(itemCriterio.getPepr().getId());
        Preconditions.checkNotNull(itemCriterio.getPepr().getAutpId());

        itemCriterio.setIdioma(getIdioma());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("estd-list")
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());
        Preconditions.checkNotNull(itemCriterio.getPepr());
        Preconditions.checkNotNull(itemCriterio.getPepr().getId());
        Preconditions.checkNotNull(itemCriterio.getPepr().getAutpId());

        final EstadisticaBO estdBO = new EstadisticaBO();

        itemCriterio.setSoloDatosGrid(true);
        itemCriterio.setIdioma(getIdioma());

        itemList = estdBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        enti = TipoEstadisticaProxy.select(itemCriterio.getEntiId());

        return SUCCESS;
    }

    // get / set

    /**
     * Load label values map.
     */
    protected final void loadLabelValuesMap() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());
        Preconditions.checkNotNull(itemCriterio.getPepr());
        Preconditions.checkNotNull(itemCriterio.getPepr().getId());
        Preconditions.checkNotNull(itemCriterio.getPepr().getAutpId());
        Preconditions.checkNotNull(itemCriterio.getIdioma());

        final ParametroBO prmtBO = new ParametroBO();

        {
            final TipoEstadisticaVO enti = TipoEstadisticaProxy.select(itemCriterio.getEntiId());

            // Carga de los labelValues (Si los hay)
            final Set<Long> tpprIds = new HashSet<>();

            if (enti.getEntdList() != null) {
                for (final EntidadTipoDatoVO entdVO : enti.getEntdList()) {
                    if (entdVO.getFiltrable() && entdVO.getTpdt().getTpht() != TipoHtml.F
                            && entdVO.getTpdt().getEnti() != null && entdVO.getTpdt().getEnti().getId() != null) {
                        tpprIds.add(entdVO.getTpdt().getEnti().getId());
                    }
                }
            }

            if (!tpprIds.isEmpty()) {
                labelValuesMap = new HashMap<>();
                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(),
                        getItemCriterio().getIdioma()));
            }
        }

        {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();
            final ItemDatoCriterioVO itdt = new ItemDatoCriterioVO();
            final ParametroVO autp = new ParametroVO();

            autp.setId(itemCriterio.getPepr().getAutpId());

            itdt.setTpdtId(TipoDato.AUT_PORT.getId());
            itdt.setPrmt(autp);

            prmtCriterioVO.setEntiId(Entidad.AUTORIDAD_PORTUARIA.getId());
            prmtCriterioVO.setItdtMap(new HashMap<Long, ItemDatoCriterioVO>());
            prmtCriterioVO.getItdtMap().put(itdt.getTpdtId(), itdt);
            prmtCriterioVO.setIdioma(itemCriterio.getIdioma());
            prmtCriterioVO.setFechaVigencia(Calendar.getInstance().getTime());

            subpList.addAll(prmtBO.selectList(prmtCriterioVO));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final EstadisticaCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final EstadisticaCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public final PaginatedList<EstadisticaVO> getItemList() {
        return itemList;
    }

    /**
     * Gets the subp list.
     *
     * @return the subp list
     */
    public List<ParametroVO> getSubpList() {
        return subpList;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoEstadisticaVO getEnti() {
        return enti;
    }

}
