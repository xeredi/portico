package xeredi.integra.http.controller.action.estadistica;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.estadistica.cargaoppe.ProcesoCargaOppe;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoAction.
 */
public final class PeriodoProcesoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 849907867635380383L;

    /** The pepr form. */
    private PeriodoProcesoVO pepr;

    /** The autp list. */
    private List<LabelValueVO> autpList;

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
        setFechaVigencia(Calendar.getInstance().getTime());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Cargar.
     *
     * @return the string
     */
    @Action("pepr-cargar")
    public String cargar() throws InstanceNotFoundException {
        if (pepr == null) {
            pepr = new PeriodoProcesoVO();
        }

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_autp, pepr.getAutp());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.pepr_autp, pepr.getAutp().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, pepr.getAnio());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_mes, pepr.getMes());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, getSobreescribir());

        if (!hasErrors()) {
            final ProcesoBO prbtBO = new ProcesoBO();
            final Map<String, String> parametroMap = new HashMap<>();

            // FIXME Deberia llegar por el formulario
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.AUTORIDAD_PORTUARIA.getId());
            final ParametroVO autp = prmtBO.select(pepr.getAutp().getId(), getIdioma(), Calendar.getInstance()
                    .getTime());

            pepr.setAutp(autp);

            final String foldername = ConfigurationProxy
                    .getString(ConfigurationKey.estadistica_files_oppe_entrada_home);
            final String filepath = foldername + "/" + pepr.getFilename() + ".zip";
            final File file = new File(filepath);

            parametroMap.put(ProcesoCargaOppe.AUTP_PARAM, pepr.getAutp().getId().toString());
            parametroMap.put(ProcesoCargaOppe.ANIO_PARAM, pepr.getAnio().toString());
            parametroMap.put(ProcesoCargaOppe.MES_PARAM, pepr.getMes().toString());
            parametroMap.put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, getSobreescribir().toString());

            prbtBO.crear(ProcesoModulo.E, ProcesoTipo.EST_CARGA, parametroMap, null, null, file);
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
        setFechaVigencia(Calendar.getInstance().getTime());

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
        if (pepr == null) {
            pepr = new PeriodoProcesoVO();
        }

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_autp, pepr.getAutp());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.pepr_autp, pepr.getAutp().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.pepr_anio, pepr.getAnio());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_mes, pepr.getMes());
        FieldValidator.validateRequired(this, MessageI18nKey.pepr_sobreescribir, getSobreescribir());

        if (!hasErrors()) {
            final ProcesoBO prbtBO = new ProcesoBO();
            final Map<String, String> parametroMap = new HashMap<>();

            parametroMap.put(ProcesoCargaOppe.AUTP_PARAM, pepr.getAutp().getId().toString());
            parametroMap.put(ProcesoCargaOppe.ANIO_PARAM, pepr.getAnio().toString());
            parametroMap.put(ProcesoCargaOppe.MES_PARAM, pepr.getMes().toString());
            parametroMap.put(ProcesoCargaOppe.SOBREESCRIBIR_PARAM, getSobreescribir().toString());

            prbtBO.crear(ProcesoModulo.E, ProcesoTipo.EST_CREACION, parametroMap, null, null, null);
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
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        peprBO.delete(pepr.getId());

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
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        pepr = peprBO.select(pepr.getId());

        return SUCCESS;
    }

    /**
     * Load label values map.
     */
    private void loadLabelValuesMap() {
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.AUTORIDAD_PORTUARIA.getId());
        final Set<Long> tpprIds = Sets.newHashSet(Entidad.AUTORIDAD_PORTUARIA.getId());

        autpList = prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), getIdioma()).get(
                Entidad.AUTORIDAD_PORTUARIA.getId());
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
     * Gets the pepr.
     *
     * @return the pepr
     */
    public PeriodoProcesoVO getPepr() {
        return pepr;
    }

    /**
     * Sets the pepr.
     *
     * @param value
     *            the new pepr
     */
    public void setPepr(final PeriodoProcesoVO value) {
        pepr = value;
    }

    /**
     * Gets the autp list.
     *
     * @return the autp list
     */
    public List<LabelValueVO> getAutpList() {
        return autpList;
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
