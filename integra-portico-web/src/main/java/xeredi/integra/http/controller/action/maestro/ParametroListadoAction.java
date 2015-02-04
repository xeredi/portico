package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
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

    /** The enti id. */
    private TipoParametroVO enti;

    // Acciones web
    /**
     * Editar filtro.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-filter")
    public String filter() throws ApplicationException {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        if (itemCriterio.getFechaVigencia() == null) {
            itemCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        itemCriterio.setIdioma(getIdioma());

        enti = TipoParametroProxy.select(itemCriterio.getEntiId());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-list")
    public String list() throws ApplicationException {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        if (itemCriterio.getFechaVigencia() == null) {
            itemCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        itemCriterio.setSoloDatosGrid(true);
        itemCriterio.setIdioma(getIdioma());

        enti = TipoParametroProxy.select(itemCriterio.getEntiId());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(itemCriterio.getEntiId());

        itemList = prmtBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * Load label values map.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected final void loadLabelValuesMap() throws ApplicationException {
        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            final TipoParametroVO enti = TipoParametroProxy.select(itemCriterio.getEntiId());

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
                final ParametroBO prmtBO = new DefaultParametroBO();

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

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoParametroVO value) {
        enti = value;
    }

}
