package xeredi.integra.http.controller.action.estadistica;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.proceso.batch.estadistica.ProcesoCargaOppe;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoAction.
 */
public final class PeriodoProcesoAction extends ItemAction implements ModelDriven<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 849907867635380383L;

    /** The pepr form. */
    private PeriodoProcesoVO model;

    /** The autp list. */
    private List<SuperpuertoVO> sprtList;

    /** The file. */
    private File file;

    /** The file content type. */
    private String fileContentType;

    /** The file file name. */
    private String fileFileName;

    /** The sobreescribir. */
    private Boolean sobreescribir;

    // Acciones web
    /**
     * Preparar carga.
     *
     * @return the string
     */
    @Action("pepr-preparar-carga")
    public String prepararCarga() {
        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Cargar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("pepr-cargar")
    public String cargar() throws InstanceNotFoundException {
        if (model == null) {
            model = new PeriodoProcesoVO();
        }

        FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getSprt());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getSprt().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, model.getAnio());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_mes, model.getMes());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, getSobreescribir());

        if (!hasErrors()) {
            final ProcesoBO prbtBO = new ProcesoBO();
            final Map<String, String> parametroMap = new HashMap<>();

            final String foldername = ConfigurationProxy
                    .getString(ConfigurationKey.estadistica_files_oppe_entrada_home);
            final String filepath = foldername + "/" + model.getFilename() + ".zip";
            final File file = new File(filepath);

            parametroMap.put(ProcesoCargaOppe.AUTP_PARAM, model.getSprt().getId().toString());
            parametroMap.put(ProcesoCargaOppe.ANIO_PARAM, model.getAnio().toString());
            parametroMap.put(ProcesoCargaOppe.MES_PARAM, model.getMes().toString());
            parametroMap.put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, getSobreescribir().toString());

            prbtBO.crear(ProcesoTipo.EST_CARGA, parametroMap, null, null, file);
        }

        return SUCCESS;
    }

    /**
     * Preparar creacion.
     *
     * @return the string
     */
    @Action("pepr-preparar-creacion")
    public String prepararCreacion() {
        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Creacion.
     *
     * @return the string
     */
    @Action("pepr-creacion")
    public String creacion() {
        if (model == null) {
            model = new PeriodoProcesoVO();
        }

        FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getSprt());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.sprt, model.getSprt().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, model.getAnio());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_mes, model.getMes());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, getSobreescribir());

        if (!hasErrors()) {
            final ProcesoBO prbtBO = new ProcesoBO();
            final Map<String, String> parametroMap = new HashMap<>();

            parametroMap.put(ProcesoCargaOppe.AUTP_PARAM, model.getSprt().getId().toString());
            parametroMap.put(ProcesoCargaOppe.ANIO_PARAM, model.getAnio().toString());
            parametroMap.put(ProcesoCargaOppe.MES_PARAM, model.getMes().toString());
            parametroMap.put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, getSobreescribir().toString());

            prbtBO.crear(ProcesoTipo.EST_CREACION, parametroMap, null, null, null);
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action("pepr-remove")
    public String borrar() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        peprBO.delete(model.getId());

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("pepr-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        model = peprBO.select(model.getId());

        return SUCCESS;
    }

    /**
     * Load label values map.
     */
    private void loadLabelValuesMap() {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterioVO = new SuperpuertoCriterioVO();

        sprtCriterioVO.setIdioma(getIdioma());

        sprtList = sprtBO.selectList(sprtCriterioVO);
    }

    // get / set

    /**
     * Gets the tpess.
     *
     * @return the tpess
     */
    public List<LabelValueVO> getTpesList() {
        return TipoEstadisticaProxy.selectLabelValues();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PeriodoProcesoVO getModel() {
        return model;
    }

    /**
     * Sets the pepr.
     *
     * @param value
     *            the new pepr
     */
    public void setModel(final PeriodoProcesoVO value) {
        model = value;
    }

    /**
     * Gets the sprt list.
     *
     * @return the sprt list
     */
    public List<SuperpuertoVO> getSprtList() {
        return sprtList;
    }

    /**
     * Gets the file.
     *
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the file.
     *
     * @param value
     *            the new file
     */
    public void setFile(final File value) {
        file = value;
    }

    /**
     * Gets the file content type.
     *
     * @return the file content type
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * Sets the file content type.
     *
     * @param value
     *            the new file content type
     */
    public void setFileContentType(final String value) {
        fileContentType = value;
    }

    /**
     * Gets the file file name.
     *
     * @return the file file name
     */
    public String getFileFileName() {
        return fileFileName;
    }

    /**
     * Sets the file file name.
     *
     * @param value
     *            the new file file name
     */
    public void setFileFileName(final String value) {
        fileFileName = value;
    }

    /**
     * Gets the sobreescribir.
     *
     * @return the sobreescribir
     */
    public Boolean getSobreescribir() {
        return sobreescribir;
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

}
