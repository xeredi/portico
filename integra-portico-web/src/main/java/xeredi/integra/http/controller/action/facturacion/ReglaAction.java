package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ReglaVersionVO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.InstanceNotFoundException;

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

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The enti facturable list. */
    private final List<LabelValueVO> entiFacturableList = new ArrayList<>();

    /**
     * Instantiates a new regla action.
     */
    public ReglaAction() {
        super();

        fechaVigencia = Calendar.getInstance().getTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("rgla-detail")
    public String detail() {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkArgument(rgla.getId() != null && fechaVigencia != null || rgla.getRglv() != null
                && rgla.getRglv().getId() != null);

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setId(rgla.getId());
        rglaCriterioVO.setFechaVigencia(fechaVigencia);

        if (rgla.getRglv() != null) {
            rglaCriterioVO.setRglvId(rgla.getRglv().getId());
        }

        try {
            rgla = rglaBO.select(rglaCriterioVO);

            final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
            final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

            rginCriterioVO.setRgla1Id(rgla.getId());

            rginList.addAll(rginBO.selectList(rginCriterioVO));
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.rgla.name()),
                rglaCriterioVO.toString() }));
        }

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("rgla-create")
    public String create() {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getCrgo());
        Preconditions.checkNotNull(rgla.getCrgo().getCrgv());
        Preconditions.checkNotNull(rgla.getCrgo().getCrgv().getId());

        accion = ACCION_EDICION.create;

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setCrgvId(rgla.getCrgo().getCrgv().getId());

        final CargoVO crgo = crgoBO.select(crgoCriterioVO);
        final ReglaVersionVO rglv = new ReglaVersionVO();

        rgla = new ReglaVO();
        rglv.setFini(Calendar.getInstance().getTime());
        rgla.setRglv(rglv);
        rgla.setCrgo(crgo);

        loadEntiFacturables();

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     */
    @Action("rgla-edit")
    public String edit() {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

        accion = ACCION_EDICION.edit;

        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setRglvId(rgla.getRglv().getId());

        try {
            rgla = rglaBO.select(rglaCriterioVO);

            loadEntiFacturables();
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.rgla.name()),
                String.valueOf(rgla.getRglv().getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Busqueda de entidades Facturables para el cargo al que va a pertenecer la regla.
     */
    private void loadEntiFacturables() {
        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoServicioCriterioVO tpsrCriterioVO = new TipoServicioCriterioVO();

        tpsrCriterioVO.setId(rgla.getCrgo().getTpsr().getId());
        tpsrCriterioVO.setFacturable(Boolean.TRUE);

        entiFacturableList.addAll(tpsrBO.selectLabelValues(tpsrCriterioVO));

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final TipoSubservicioCriterioVO tpssCriterioVO = new TipoSubservicioCriterioVO();

        tpssCriterioVO.setTpsrId(rgla.getCrgo().getTpsr().getId());
        tpssCriterioVO.setFacturable(Boolean.TRUE);

        entiFacturableList.addAll(tpssBO.selectLabelValues(tpssCriterioVO));
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("rgla-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());

        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(rgla.getCrgo().getId());

            if (GenericValidator.isBlankOrNull(rgla.getCodigo())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.rgla_codigo.name()) }));
            }
        } else {
            Preconditions.checkNotNull(rgla.getId());
            Preconditions.checkNotNull(rgla.getRglv().getId());
        }

        if (rgla.getRglv().getTipo() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.rgla_tipo.name()) }));
        }

        if (rgla.getRglv().getEnti() == null || rgla.getRglv().getEnti().getId() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.rgla_enti.name()) }));
        }

        if (rgla.getRglv().getFini() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.rgla_fini.name()) }));
        }

        if (rgla.getRglv().getOrden() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.rgla_orden.name()) }));
        }

        if (GenericValidator.isBlankOrNull(rgla.getRglv().getCondicion())) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.rgla_condicion.name()) }));
        }

        if (GenericValidator.isBlankOrNull(rgla.getRglv().getFormula())) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.rgla_formula.name()) }));
        }

        if (ReglaTipo.T == rgla.getRglv().getTipo()) {
            if (rgla.getRglv().getImporteBase() == null) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.rgla_importeBase.name()) }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathImpuesto())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.rgla_pathImpuesto.name()) }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathPagador())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.rgla_pathPagador.name()) }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathEsSujPasivo())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.rgla_pathEsSujPasivo.name()) }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCodExen())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.rgla_pathCodExen.name()) }));
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo1())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo1())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo1())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqInfo1.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo1())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathInfo1.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo2())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo2())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo2())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqInfo2.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo2())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathInfo2.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo3())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo3())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo3())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqInfo3.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo3())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathInfo3.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo4())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo4())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo4())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqInfo4.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo4())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathInfo4.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo5())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo5())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo5())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqInfo5.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo5())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathInfo5.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo6())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo6())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo6())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqInfo6.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo6())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathInfo6.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant1())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant1())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant1())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqCuant1.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant1())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathCuant1.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant2())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant2())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant2())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqCuant2.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant2())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathCuant2.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant3())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant3())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant3())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqCuant3.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant3())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathCuant3.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant4())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant4())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant4())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqCuant4.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant4())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathCuant4.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant5())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant5())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant5())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqCuant5.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant5())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathCuant5.name()) }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant6())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant6())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant6())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_etiqCuant6.name()) }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant6())) {
                    addActionError(getText(MessageI18nKey.E00001.name(),
                            new String[] { getText(MessageI18nKey.rgla_pathCuant6.name()) }));
                }
            }
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final ReglaBO rglaBO = new ReglaBO();

        switch (accion) {
        case create:
            try {
                rglaBO.insert(rgla);
            } catch (final OverlapException ex) {
                addActionError(getText(MessageI18nKey.E00009.name(),
                        new String[] { getText(MessageI18nKey.rgla.name()) }));
            }
            break;
        case edit:
            try {
                rglaBO.update(rgla);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(MessageI18nKey.E00008.name(), new String[] {
                    getText(MessageI18nKey.rgla.name()), rgla.getCodigo() }));
            } catch (final OverlapException ex) {
                addActionError(getText(MessageI18nKey.E00009.name(),
                        new String[] { getText(MessageI18nKey.rgla.name()) }));
            }
            break;
        default:
            break;
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("rgla-remove")
    public String remove() {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

        final ReglaBO rglaBO = new ReglaBO();

        try {
            rglaBO.delete(rgla);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.rgla.name()),
                rgla.getCodigo() }));
        }

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
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
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
