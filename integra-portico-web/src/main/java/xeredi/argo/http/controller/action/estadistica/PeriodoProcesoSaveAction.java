package xeredi.argo.http.controller.action.estadistica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoSaveAction.
 */
public final class PeriodoProcesoSaveAction extends CrudSaveAction<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 230657854894847117L;

    /** The sobreescribir. */
    private Boolean sobreescribir;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoVO sprt = sprtBO.select(model.getSprt().getId(), getIdioma());

        final ProcesoBO prbtBO = new ProcesoBO();
        final Map<String, String> parametroMap = new HashMap<>();

        parametroMap.put(ProcesoCargaOppe.params.autp.name(), sprt.getCodigo());
        parametroMap.put(ProcesoCargaOppe.params.anio.name(), model.getAnio().toString());
        parametroMap.put(ProcesoCargaOppe.params.mes.name(), model.getMes().toString());
        parametroMap.put(ProcesoCargaOppe.params.sobreescribir.name(), sobreescribir.toString());

        switch (accion) {
        case load:
            final String foldername = ConfigurationProxy
                    .getString(ConfigurationKey.estadistica_files_oppe_entrada_home);
            final String filepath = foldername + "/" + model.getFilename() + ".zip";
            final File file = new File(filepath);

            prbtBO.crear(ProcesoTipo.EST_CARGA, parametroMap, null, null, file);

            break;
        case create:
            prbtBO.crear(ProcesoTipo.EST_CREACION, parametroMap, null, null, null);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getSprt());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getSprt().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, model.getAnio());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_mes, model.getMes());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, sobreescribir);
    }

    /**
     * Sets the sobreescribir.
     *
     * @param value
     *            the new sobreescribir
     */
    public void setSobreescribir(final Boolean value) {
        sobreescribir = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.pepr;
    }
}