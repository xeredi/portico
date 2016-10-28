package xeredi.argo.http.controller.action.servicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.ValoradorVO;
import xeredi.argo.proceso.facturacion.ProcesoValorador;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorSaveAction.
 */
public final class ValoradorSaveAction extends CrudSaveAction<ValoradorVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8899968426612094160L;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vldr;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final ProcesoBO prbtBO = new ProcesoBO();
        final List<Long> itemEntradaList = Arrays.asList(model.getSrvc().getId());
        final Map<String, String> parametroMap = new HashMap<>();

        parametroMap.put(ProcesoValorador.Params.fliq.name(), dateFormat.format(model.getFliq()));

        final ProcesoVO prbt = prbtBO.crear(SessionManager.getUsroId(), ProcesoTipo.VALORADOR, parametroMap,
                ItemTipo.srvc, itemEntradaList);

        model.setPrbt(prbt);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getSrvc());
        Preconditions.checkNotNull(model.getSrvc().getEntiId());
        Preconditions.checkNotNull(model.getSrvc().getId());

        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fliq, model.getFliq());

        final TipoServicioDetailVO tpsr = TipoServicioProxy.select(model.getSrvc().getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getSrvc().getEntiId());
        final ServicioVO srvc = srvcBO.select(model.getSrvc().getId(), getIdioma());

        if (!tpsr.getEnti().getEstadosVlrcSet().contains(srvc.getEstado())) {
            addActionError(MessageI18nKey.E00016, srvc.getEstado());
        }
    }
}
