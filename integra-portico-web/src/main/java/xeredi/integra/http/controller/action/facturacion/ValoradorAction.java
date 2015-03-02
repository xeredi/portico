package xeredi.integra.http.controller.action.facturacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.proceso.facturacion.ProcesoValorador;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorAction.
 */
public final class ValoradorAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3003393076467187485L;

    /** The srvc. */
    private ServicioVO srvc;

    /** The fliq. */
    private Date fliq;

    /** The crgo ids. */
    private Set<Long> crgoIds;

    // Acciones web

    /**
     * Prepare.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("vldr-prepare")
    public String prepare() throws InstanceNotFoundException {
        Preconditions.checkNotNull(srvc);
        Preconditions.checkNotNull(srvc.getId());
        Preconditions.checkNotNull(srvc.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(srvc.getEntiId());

        srvc = srvcBO.select(srvc.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Valorar.
     *
     * @return the string
     */
    @Action("vldr-valorar")
    public String valorar() {
        Preconditions.checkNotNull(fliq);
        Preconditions.checkNotNull(srvc);
        Preconditions.checkNotNull(srvc.getId());
        Preconditions.checkNotNull(srvc.getEntiId());

        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final ProcesoBO prbtBO = new ProcesoBO();
        final List<Long> itemEntradaList = Arrays.asList(srvc.getId());
        final Map<String, String> parametroMap = new HashMap<>();

        parametroMap.put(ProcesoValorador.FLIQ_PARAM, dateFormat.format(fliq));

        prbtBO.crear(ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc, itemEntradaList, null);

        return SUCCESS;
    }

    // get / set

    /** The crgo list. */
    private List<CargoVO> crgoList;

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the new srvc
     */
    public void setSrvc(final ServicioVO value) {
        srvc = value;
    }

    /**
     * Gets the fliq.
     *
     * @return the fliq
     */
    public Date getFliq() {
        return fliq;
    }

    /**
     * Sets the fliq.
     *
     * @param value
     *            the new fliq
     */
    public void setFliq(final Date value) {
        fliq = value;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }

    /**
     * Sets the crgo ids.
     *
     * @param value
     *            the new crgo ids
     */
    public void setCrgoIds(final Set<Long> value) {
        crgoIds = value;
    }

}
