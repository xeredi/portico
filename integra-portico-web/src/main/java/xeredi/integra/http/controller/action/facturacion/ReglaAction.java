package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ReglaVersionVO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaAction.
 */
public final class ReglaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5126050009155945054L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The rgla. */
    private ReglaVO rgla;

    /** The rgin list. */
    private final List<ReglaIncompatibleVO> rginList = new ArrayList<>();

    /** The enti facturable list. */
    private final List<LabelValueVO> entiFacturableList = new ArrayList<>();

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("rgla-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final ReglaBO rglaBO = new ReglaBO();

        rgla = rglaBO.select(rgla.getId(), getFechaVigencia());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgla1Id(rgla.getId());

        rginList.addAll(rginBO.selectList(rginCriterioVO));

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("rgla-create")
    public String create() throws ApplicationException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getCrgo());
        Preconditions.checkNotNull(rgla.getCrgo().getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        accion = ACCION_EDICION.create;

        final CargoBO crgoBO = new CargoBO();
        final CargoVO crgo = crgoBO.select(rgla.getCrgo().getId(), getFechaVigencia(), getIdioma());
        final ReglaVersionVO rglv = new ReglaVersionVO();

        rglv.setFini(Calendar.getInstance().getTime());

        rgla = new ReglaVO();
        rgla.setRglv(rglv);
        rgla.setCrgo(crgo);

        loadEntiFacturables();

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("rgla-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        accion = ACCION_EDICION.edit;

        final ReglaBO rglaBO = new ReglaBO();

        rgla = rglaBO.select(rgla.getId(), getFechaVigencia());

        return SUCCESS;
    }

    /**
     * Busqueda de entidades Facturables para el cargo al que va a pertenecer la regla.
     */
    private void loadEntiFacturables() throws ApplicationException {
        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final CargoBO crgoBO = new CargoBO();

        final CargoVO crgo = crgoBO.select(rgla.getCrgo().getId(), getFechaVigencia(), getIdioma());
        final TipoServicioCriterioVO tpsrCriterioVO = new TipoServicioCriterioVO();

        tpsrCriterioVO.setId(crgo.getTpsr().getId());
        tpsrCriterioVO.setFacturable(Boolean.TRUE);
        tpsrCriterioVO.setIdioma(getIdioma());

        entiFacturableList.addAll(tpsrBO.selectLabelValues(tpsrCriterioVO));

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final TipoSubservicioCriterioVO tpssCriterioVO = new TipoSubservicioCriterioVO();

        tpssCriterioVO.setTpsrId(crgo.getTpsr().getId());
        tpssCriterioVO.setFacturable(Boolean.TRUE);
        tpssCriterioVO.setIdioma(getIdioma());

        entiFacturableList.addAll(tpssBO.selectLabelValues(tpssCriterioVO));
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("rgla-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());

        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(rgla.getCrgo().getId());

            FieldValidator.validateRequired(this, MessageI18nKey.rgla_codigo, rgla.getCodigo());
        } else {
            Preconditions.checkNotNull(rgla.getId());
            Preconditions.checkNotNull(rgla.getRglv().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.rgla_tipo, rgla.getTipo());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_enti, rgla.getEnti());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_fini, rgla.getRglv().getFini());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_orden, rgla.getRglv().getOrden());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_condicion, rgla.getRglv().getCondicion());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_formula, rgla.getRglv().getFormula());

        if (ReglaTipo.T == rgla.getTipo()) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_importeBase, rgla.getRglv().getImporteBase());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathImpuesto, rgla.getRglv().getPathImpuesto());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathPagador, rgla.getRglv().getPathPagador());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathEsSujPasivo, rgla.getRglv()
                    .getPathEsSujPasivo());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCodExen, rgla.getRglv().getPathCodExen());

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo1())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo1())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo1, rgla.getRglv().getEtiqInfo1());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo1, rgla.getRglv().getPathInfo1());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo2())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo2())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo2, rgla.getRglv().getEtiqInfo2());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo2, rgla.getRglv().getPathInfo2());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo3())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo3())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo3, rgla.getRglv().getEtiqInfo3());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo3, rgla.getRglv().getPathInfo3());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo4())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo4())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo4, rgla.getRglv().getEtiqInfo4());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo4, rgla.getRglv().getPathInfo4());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo5())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo5())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo5, rgla.getRglv().getEtiqInfo5());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo5, rgla.getRglv().getPathInfo5());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo6())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo6())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo6, rgla.getRglv().getEtiqInfo6());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo6, rgla.getRglv().getPathInfo6());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant1())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant1())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant1, rgla.getRglv().getEtiqCuant1());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant1, rgla.getRglv().getPathCuant1());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant2())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant2())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant2, rgla.getRglv().getEtiqCuant2());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant2, rgla.getRglv().getPathCuant2());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant3())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant3())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant3, rgla.getRglv().getEtiqCuant3());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant3, rgla.getRglv().getPathCuant3());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant4())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant4())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant4, rgla.getRglv().getEtiqCuant4());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant4, rgla.getRglv().getPathCuant4());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant5())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant5())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant5, rgla.getRglv().getEtiqCuant5());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant5, rgla.getRglv().getPathCuant5());
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant6())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant6())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant6, rgla.getRglv().getEtiqCuant6());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant6, rgla.getRglv().getPathCuant6());
            }
        }

        if (!hasErrors()) {
            final ReglaBO rglaBO = new ReglaBO();

            switch (accion) {
            case create:
                rglaBO.insert(rgla);

                break;
            case edit:
                rglaBO.update(rgla);

                break;
            default:
                throw new Error(accion + " no implementada");
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("rgla-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

        final ReglaBO rglaBO = new ReglaBO();

        rglaBO.delete(rgla);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the tipos.
     *
     * @return the tipos
     */
    public ReglaTipo[] getTipos() {
        return ReglaTipo.values();
    }

    /**
     * Gets the rgla.
     *
     * @return the rgla
     */
    public ReglaVO getRgla() {
        return rgla;
    }

    /**
     * Sets the rgla.
     *
     * @param value
     *            the new rgla
     */
    public void setRgla(final ReglaVO value) {
        rgla = value;
    }

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the enti facturable list.
     *
     * @return the enti facturable list
     */
    public List<LabelValueVO> getEntiFacturableList() {
        return entiFacturableList;
    }

    /**
     * Gets the rgin list.
     *
     * @return the rgin list
     */
    public List<ReglaIncompatibleVO> getRginList() {
        return rginList;
    }

}
