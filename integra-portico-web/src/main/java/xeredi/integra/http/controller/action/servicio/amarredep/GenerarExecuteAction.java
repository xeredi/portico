package xeredi.integra.http.controller.action.servicio.amarredep;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.proceso.batch.amarredep.ProcesoAmarreDeportivo;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GenerarExecuteAction.
 */
public final class GenerarExecuteAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6959998927420303375L;
    /** The model. */
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

            parametroMap.put(ProcesoAmarreDeportivo.params.ffin.name(), format.format(model.getFrefMax()));

            prbtBO.crear(ProcesoTipo.SAMD_CREACION, parametroMap, null, null, null);
        }
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final ServicioCriterioVO value) {
        model = value;
    }
}