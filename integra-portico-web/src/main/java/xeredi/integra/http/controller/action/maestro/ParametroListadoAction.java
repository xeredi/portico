package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.comun.vo.ItemDatoCriterioVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroListadoAction.
 */
public final class ParametroListadoAction extends ItemListadoAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4719886690588825194L;

    /** The prmts. */
    private PaginatedList<ParametroVO> itemList;

    /** The criterio vo. */
    private ParametroCriterioVO itemCriterio;

    /** The enti. */
    private TipoParametroVO enti;

    /**
     * Instantiates a new parametro listado action.
     */
    public ParametroListadoAction() {
        super();

        itemCriterio = new ParametroCriterioVO();

        itemCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        itemCriterio.setIdioma(getIdioma());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("prmt-filter")
    public String filter() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        enti = TipoParametroProxy.select(itemCriterio.getEntiId());

        // Inicializar el filtro - Necesario para AngularJS
        if (itemCriterio.getItdtMap() == null) {
            itemCriterio.setItdtMap(new HashMap<String, ItemDatoCriterioVO>());
        }

        if (enti.getEntdMap() != null) {
            for (final EntidadTipoDatoVO entdVO : enti.getEntdMap().values()) {
                if (entdVO.getFiltrable() && !itemCriterio.getItdtMap().containsKey(entdVO.getTpdt().getId())) {
                    itemCriterio.getItdtMap().put(entdVO.getTpdt().getId().toString(), new ItemDatoCriterioVO());
                }
            }
        }

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("prmt-list")
    public String list() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        if (itemCriterio.getFechaVigencia() == null) {
            itemCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }
        itemCriterio.setSoloDatosGrid(true);
        itemCriterio.setIdioma(getIdioma());

        enti = TipoParametroProxy.select(itemCriterio.getEntiId());

        final ParametroBO prmtBO = new ParametroBO();

        itemList = prmtBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * Load label values map.
     */
    protected final void loadLabelValuesMap() {
        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            final TipoParametroVO enti = TipoParametroProxy.select(itemCriterio.getEntiId());

            // Carga de los labelValues (Si los hay)
            final Set<Long> tpprIds = new HashSet<>();

            if (enti.getEntdMap() != null) {
                for (final EntidadTipoDatoVO entdVO : enti.getEntdMap().values()) {
                    if (entdVO.getFiltrable() && entdVO.getTpdt().getTpht() != TipoHtml.F
                            && entdVO.getTpdt().getEnti() != null && entdVO.getTpdt().getEnti().getId() != null) {
                        tpprIds.add(entdVO.getTpdt().getEnti().getId());
                    }
                }
            }

            if (!tpprIds.isEmpty()) {
                final ParametroBO prmtBO = new ParametroBO();

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getItemCriterio().getFechaVigencia(),
                        getItemCriterio().getIdioma()));
            }
        }
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public final ParametroCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final ParametroCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public final PaginatedList<ParametroVO> getItemList() {
        return itemList;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoParametroVO getEnti() {
        return enti;
    }

}
