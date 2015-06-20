package xeredi.integra.http.controller.action.facturacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.proceso.facturacion.ProcesoValorador;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorSaveAction.
 */
public final class ValoradorSaveAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8899968426612094160L;

    /** The srvc. */
    private ServicioVO srvc;

    /** The fliq. */
    private Date fliq;

    /** The crgo ids. */
    private Set<Long> crgoIds;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(srvc);
        Preconditions.checkNotNull(srvc.getId());
        Preconditions.checkNotNull(srvc.getEntiId());
        Preconditions.checkNotNull(fliq);

        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final ProcesoBO prbtBO = new ProcesoBO();
        final List<Long> itemEntradaList = Arrays.asList(srvc.getId());
        final Map<String, String> parametroMap = new HashMap<>();

        parametroMap.put(ProcesoValorador.FLIQ_PARAM, dateFormat.format(fliq));

        prbtBO.crear(ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc, itemEntradaList, null);
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
     * Sets the fliq.
     *
     * @param value
     *            the new fliq
     */
    public void setFliq(final Date value) {
        fliq = value;
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
