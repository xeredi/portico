package xeredi.argo.http.controller.action.facturacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.vo.FacturadorVO;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.proceso.facturacion.ProcesoFacturador;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorSaveAction.
 */
@Data
public final class FacturadorSaveAction extends CrudSaveAction<FacturadorVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2241047270819035432L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final ProcesoBO prbtBO = new ProcesoBO();
        final Map<String, String> parametroMap = new HashMap<>();

        parametroMap.put(ProcesoFacturador.Params.ffac.name(), dateFormat.format(model.getFecha().getTime()));
        parametroMap.put(ProcesoFacturador.Params.fcsr.name(), model.getFcsrId().toString());

        if (model.getPagador() != null && model.getPagador().getId() != null) {
            parametroMap.put(ProcesoFacturador.Params.pagador.name(), model.getPagador().getParametro());
        }
        if (model.getPrtoId() != null) {
            parametroMap.put(ProcesoFacturador.Params.prto.name(), model.getPrtoId().toString());
        }
        if (model.getTpsrId() != null) {
            parametroMap.put(ProcesoFacturador.Params.tpsr.name(), model.getTpsrId().toString());
        }
        if (model.getSrvc() != null && model.getSrvc().getId() != null) {
            parametroMap.put(ProcesoFacturador.Params.srvc.name(), model.getSrvc().getId().toString());
        }
        if (model.getGrupoTipo() != null) {
            parametroMap.put(ProcesoFacturador.Params.grupoTipo.name(), model.getGrupoTipo().name());
        }

        final ProcesoVO prbt = prbtBO.crear(SessionManager.getUsroId(), ProcesoTipo.FACTURADOR, parametroMap,
                ItemTipo.vlrc, model.getVlrcId() == null ? null : Arrays.asList(model.getVlrcId()));

        model.setPrbtId(prbt.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.fcsr, model.getFcsrId());
        FieldValidator.validateRequired(this, MessageI18nKey.fliq, model.getFecha());

        if (model.getVlrcId() == null) {
            FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsrId());

            // FIXME Cambiar fref por grupoTipo
            FieldValidator.validateRequired(this, MessageI18nKey.fref, model.getGrupoTipo());
        }
    }
}
