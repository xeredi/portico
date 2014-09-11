package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.bo.Cargo;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.bo.Regla;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatible;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ReglaVersionVO;
import xeredi.integra.model.metamodelo.bo.TipoServicio;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicio;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
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
    private final List<EntidadVO> entiFacturableList = new ArrayList<>();

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

        final Regla rglaBO = BOFactory.getInjector().getInstance(ReglaBO.class);
        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setId(rgla.getId());
        rglaCriterioVO.setFechaVigencia(fechaVigencia);

        if (rgla.getRglv() != null) {
            rglaCriterioVO.setRglvId(rgla.getRglv().getId());
        }

        try {
            rgla = rglaBO.select(rglaCriterioVO);

            final ReglaIncompatible rginBO = BOFactory.getInjector().getInstance(ReglaIncompatibleBO.class);
            final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

            rginCriterioVO.setRgla1Id(rgla.getId());

            rginList.addAll(rginBO.selectList(rginCriterioVO));
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("rgla"), rglaCriterioVO.toString() }));
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

        final Cargo crgoBO = BOFactory.getInjector().getInstance(CargoBO.class);
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        crgoCriterioVO.setCrgvId(rgla.getCrgo().getCrgv().getId());

        final CargoVO crgo = crgoBO.select(crgoCriterioVO);
        final ReglaVersionVO rglv = new ReglaVersionVO();

        rgla = new ReglaVO();
        rglv.setFini(Calendar.getInstance().getTime());
        rgla.setRglv(rglv);
        rgla.setCrgo(crgo);

        {
            // Busqueda de entidades Facturables para el cargo al que va a pertenecer la regla
            final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicioBO.class);
            final TipoServicioCriterioVO tpsrCriterioVO = new TipoServicioCriterioVO();

            tpsrCriterioVO.setId(crgo.getTpsr().getId());
            tpsrCriterioVO.setFacturable(Boolean.TRUE);

            entiFacturableList.addAll(tpsrBO.selectList(tpsrCriterioVO));

            final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicioBO.class);
            final TipoSubservicioCriterioVO tpssCriterioVO = new TipoSubservicioCriterioVO();

            tpssCriterioVO.setTpsrId(crgo.getTpsr().getId());
            tpssCriterioVO.setFacturable(Boolean.TRUE);

            entiFacturableList.addAll(tpssBO.selectList(tpssCriterioVO));
        }

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

        final Regla rglaBO = BOFactory.getInjector().getInstance(ReglaBO.class);
        final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

        rglaCriterioVO.setRglvId(rgla.getRglv().getId());

        try {
            rgla = rglaBO.select(rglaCriterioVO);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { getText("rgla"), String.valueOf(rgla.getRglv().getId()) }));
        }

        return SUCCESS;
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
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_codigo") }));
            }

            if (rgla.getTipo() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_tipo") }));
            }

            if (rgla.getEnti() == null || rgla.getEnti().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_enti") }));
            }
        } else {
            Preconditions.checkNotNull(rgla.getId());
            Preconditions.checkNotNull(rgla.getRglv().getId());
        }

        if (rgla.getRglv().getFini() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_fini") }));
        }

        if (rgla.getRglv().getOrden() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_orden") }));
        }

        if (GenericValidator.isBlankOrNull(rgla.getRglv().getCondicion())) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_condicion") }));
        }

        if (GenericValidator.isBlankOrNull(rgla.getRglv().getFormula())) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_formula") }));
        }

        if (ReglaTipo.T == rgla.getTipo()) {
            if (rgla.getRglv().getImporteBase() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_importeBase") }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathImpuesto())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathImpuesto") }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathPagador())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathPagador") }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathEsSujPasivo())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathEsSujPasivo") }));
            }

            if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCodExen())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathCodExen") }));
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo1())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo1())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo1())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqInfo1") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo1())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathInfo1") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo2())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo2())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo2())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqInfo2") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo2())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathInfo2") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo3())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo3())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo3())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqInfo3") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo3())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathInfo3") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo4())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo4())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo4())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqInfo4") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo4())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathInfo4") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo5())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo5())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo5())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqInfo5") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo5())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathInfo5") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo6())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo6())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqInfo6())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqInfo6") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathInfo6())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathInfo6") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant1())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant1())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant1())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqCuant1") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant1())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathCuant1") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant2())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant2())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant2())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqCuant2") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant2())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathCuant2") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant3())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant3())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant3())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqCuant3") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant3())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathCuant3") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant4())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant4())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant4())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqCuant4") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant4())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathCuant4") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant5())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant5())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant5())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqCuant5") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant5())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathCuant5") }));
                }
            }

            if (!GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant6())
                    || !GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant6())) {
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getEtiqCuant6())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_etiqCuant6") }));
                }
                if (GenericValidator.isBlankOrNull(rgla.getRglv().getPathCuant6())) {
                    addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("rgla_pathCuant6") }));
                }
            }
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final Regla rglaBO = BOFactory.getInjector().getInstance(ReglaBO.class);

        switch (accion) {
        case create:
            try {
                rglaBO.insert(rgla);
            } catch (final OverlapException ex) {
                addActionError(getText(ErrorCode.E00009.name(), new String[] { getText("rgla") }));
            }
            break;
        case edit:
            try {
                rglaBO.update(rgla);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("rgla"), rgla.getCodigo() }));
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

        final Regla rglaBO = BOFactory.getInjector().getInstance(ReglaBO.class);

        try {
            rglaBO.delete(rgla);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("rgla"), rgla.getCodigo() }));
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
    public List<EntidadVO> getEntiFacturableList() {
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
