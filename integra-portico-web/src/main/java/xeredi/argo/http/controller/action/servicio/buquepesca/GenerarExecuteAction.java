package xeredi.argo.http.controller.action.servicio.buquepesca;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.batch.pesca.ProcesoBuquePesca;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BuquePescaProcesoSaveAction.
 */
public final class GenerarExecuteAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4956601131901400553L;

    /** The model. */
    @Setter
    private ServicioCriterioVO model;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.ffin, model.getFrefMax());

        if (!hasErrors()) {
            final ProcesoBO prbtBO = new ProcesoBO();
            final Map<String, String> parametroMap = new HashMap<>();

            final DateFormat format = new SimpleDateFormat(ConfigurationProxy.getString(ConfigurationKey.date_format));

            parametroMap.put(ProcesoBuquePesca.params.ffin.name(), format.format(model.getFrefMax()));

            prbtBO.crear(ProcesoTipo.SBUP_CREACION, parametroMap, null, null, null);
        }
    }
}
