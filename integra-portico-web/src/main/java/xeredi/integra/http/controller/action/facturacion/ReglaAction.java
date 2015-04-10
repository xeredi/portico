package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
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
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaAction.
 */
public final class ReglaAction extends ItemAction implements ModelDriven<ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5126050009155945054L;

    /** The rgla. */
    private ReglaVO model;

    /** The rgin list. */
    private List<ReglaIncompatibleVO> rginList;

    /** The enti facturable list. */
    private List<LabelValueVO> entiFacturableList;

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final ReglaBO rglaBO = new ReglaBO();

        model = rglaBO.select(model.getId(), getFechaVigencia());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

        rginCriterioVO.setRgla1Id(model.getId());

        rginList = rginBO.selectList(rginCriterioVO);

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
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getCrgo());
        Preconditions.checkNotNull(model.getCrgo().getId());
        Preconditions.checkNotNull(getFechaVigencia());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final ReglaBO rglaBO = new ReglaBO();

            model = rglaBO.select(model.getId(), getFechaVigencia());
        } else {
            final CargoBO crgoBO = new CargoBO();
            final CargoVO crgo = crgoBO.select(model.getCrgo().getId(), getFechaVigencia(), getIdioma());
            final ReglaVersionVO rglv = new ReglaVersionVO();

            rglv.setFini(Calendar.getInstance().getTime());

            model = new ReglaVO();
            model.setRglv(rglv);
            model.setCrgo(crgo);

            loadEntiFacturables();
        }

        return SUCCESS;
    }

    /**
     * Busqueda de entidades Facturables para el cargo al que va a pertenecer la regla.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private void loadEntiFacturables() throws ApplicationException {
        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final CargoBO crgoBO = new CargoBO();

        final CargoVO crgo = crgoBO.select(model.getCrgo().getId(), getFechaVigencia(), getIdioma());
        final TipoServicioCriterioVO tpsrCriterioVO = new TipoServicioCriterioVO();

        tpsrCriterioVO.setId(crgo.getTpsr().getId());
        tpsrCriterioVO.setFacturable(Boolean.TRUE);
        tpsrCriterioVO.setIdioma(getIdioma());

        entiFacturableList = tpsrBO.selectLabelValues(tpsrCriterioVO);

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
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getRglv());

        if (getAccion() == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getCrgo().getId());

            FieldValidator.validateRequired(this, MessageI18nKey.rgla_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getRglv().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.rgla_tipo, model.getTipo());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_enti, model.getEnti());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_fini, model.getRglv().getFini());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_orden, model.getRglv().getOrden());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_condicion, model.getRglv().getCondicion());
        FieldValidator.validateRequired(this, MessageI18nKey.rgla_formula, model.getRglv().getFormula());

        if (ReglaTipo.T == model.getTipo()) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_importeBase, model.getRglv().getImporteBase());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathImpuesto, model.getRglv().getPathImpuesto());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathPagador, model.getRglv().getPathPagador());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathEsSujPasivo, model.getRglv()
                    .getPathEsSujPasivo());
            FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCodExen, model.getRglv().getPathCodExen());

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqInfo1())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathInfo1())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo1, model.getRglv().getEtiqInfo1());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo1, model.getRglv().getPathInfo1());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqInfo2())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathInfo2())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo2, model.getRglv().getEtiqInfo2());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo2, model.getRglv().getPathInfo2());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqInfo3())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathInfo3())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo3, model.getRglv().getEtiqInfo3());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo3, model.getRglv().getPathInfo3());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqInfo4())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathInfo4())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo4, model.getRglv().getEtiqInfo4());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo4, model.getRglv().getPathInfo4());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqInfo5())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathInfo5())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo5, model.getRglv().getEtiqInfo5());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo5, model.getRglv().getPathInfo5());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqInfo6())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathInfo6())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqInfo6, model.getRglv().getEtiqInfo6());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathInfo6, model.getRglv().getPathInfo6());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqCuant1())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathCuant1())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant1, model.getRglv().getEtiqCuant1());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant1, model.getRglv().getPathCuant1());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqCuant2())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathCuant2())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant2, model.getRglv().getEtiqCuant2());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant2, model.getRglv().getPathCuant2());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqCuant3())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathCuant3())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant3, model.getRglv().getEtiqCuant3());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant3, model.getRglv().getPathCuant3());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqCuant4())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathCuant4())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant4, model.getRglv().getEtiqCuant4());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant4, model.getRglv().getPathCuant4());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqCuant5())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathCuant5())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant5, model.getRglv().getEtiqCuant5());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant5, model.getRglv().getPathCuant5());
            }

            if (!GenericValidator.isBlankOrNull(model.getRglv().getEtiqCuant6())
                    || !GenericValidator.isBlankOrNull(model.getRglv().getPathCuant6())) {
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_etiqCuant6, model.getRglv().getEtiqCuant6());
                FieldValidator.validateRequired(this, MessageI18nKey.rgla_pathCuant6, model.getRglv().getPathCuant6());
            }
        }

        if (!hasErrors()) {
            final ReglaBO rglaBO = new ReglaBO();

            switch (getAccion()) {
            case create:
                rglaBO.insert(model);

                break;
            case edit:
                rglaBO.update(model);

                break;
            default:
                throw new Error(getAccion() + " no implementada");
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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getRglv());
        Preconditions.checkNotNull(model.getRglv().getId());

        final ReglaBO rglaBO = new ReglaBO();

        rglaBO.delete(model.getRglv().getId());

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
     * {@inheritDoc}
     */
    @Override
    public ReglaVO getModel() {
        return model;
    }

    /**
     * Sets the rgla.
     *
     * @param value
     *            the new rgla
     */
    public void setModel(final ReglaVO value) {
        model = value;
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
