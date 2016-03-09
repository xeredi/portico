package xeredi.argo.http.controller.action.facturacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.vo.FacturadorVO;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.proceso.facturacion.ProcesoFacturador;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorSaveAction.
 */
public final class FacturadorSaveAction extends CrudSaveAction<FacturadorVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2241047270819035432L;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.fcdr;
    }

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
        if (model.getVlrc() != null && model.getVlrc().getId() != null) {
            parametroMap.put(ProcesoFacturador.Params.vlrc.name(), model.getVlrc().getId().toString());
        }

        final ProcesoVO prbt = prbtBO.crear(ProcesoTipo.FACTURADOR, parametroMap, ItemTipo.vlrc, null);

        model.setPrbtId(prbt.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.fcsr, model.getFcsrId());
        FieldValidator.validateRequired(this, MessageI18nKey.fcdr_fecha, model.getFecha());

        // FIXME Validar que puerto, tipo de servicio, ... son correctos
    }
}
