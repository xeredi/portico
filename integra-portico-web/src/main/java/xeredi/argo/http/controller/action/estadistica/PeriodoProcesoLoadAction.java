package xeredi.argo.http.controller.action.estadistica;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudLoadAction;
import xeredi.argo.http.controller.session.SessionManager;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.http.view.estadistica.ProcesoEstadisticaVO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoLoadFileSaveAction.
 */
public final class PeriodoProcesoLoadAction extends CrudLoadAction<ProcesoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5966692618549116508L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doLoad() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model);

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, model.getSobreescribir());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_file, model.getArchId());

        if (!hasErrors()) {
            final ProcesoBO prbtBO = new ProcesoBO();
            final Map<String, String> parametroMap = new HashMap<>();

            parametroMap.put(ProcesoCargaOppe.params.sobreescribir.name(), model.getSobreescribir().toString());

            prbtBO.crear(SessionManager.getUsroId(), ProcesoTipo.EST_CARGA, parametroMap, ItemTipo.arch,
                    Arrays.asList(model.getArchId()));
        }
    }
}
