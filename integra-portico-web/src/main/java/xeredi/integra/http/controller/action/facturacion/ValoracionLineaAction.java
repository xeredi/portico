package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaAction.
 */
public final class ValoracionLineaAction extends ItemAction implements ModelDriven<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3876356981308567280L;

    /** The vlrl. */
    private ValoracionLineaVO model;

    /** The vlrl padre. */
    private ValoracionLineaVO vlrlPadre;

    /** The vlrl hijos list. */
    private List<ValoracionLineaVO> vlrlHijosList;

    /** The aspc. */
    private AspectoVO aspc;

    /** The impuesto list. */
    private List<ParametroVO> impuestoList;

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrl-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getVlrcId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(model.getId());
            vlrlCriterio.setIdioma(getIdioma());

            model = vlrcBO.selectVlrlObject(vlrlCriterio);
        }

        // Busqueda de las lineas hija (coef/bonif)
        if (model.getRgla().getTipo() == ReglaTipo.T) {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setPadreId(model.getId());
            vlrlCriterio.setSoloHijos(true);
            vlrlCriterio.setIdioma(getIdioma());

            vlrlHijosList = vlrcBO.selectVlrlList(vlrlCriterio);
        }

        loadDependencies();

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrl-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(model.getId());
            vlrlCriterio.setIdioma(getIdioma());

            model = vlrcBO.selectVlrlObject(vlrlCriterio);
        } else {
            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(model.getVlrcId());

            final ValoracionVO vlrc = vlrcBO.selectObject(vlrcCriterio);

            model.setFref(vlrc.getFref());
        }

        loadDependencies();
        loadLabelValues();

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrl-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());
        }

        loadDependencies();

        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (getAccion()) {
        case create:
            vlrcBO.insertVlrl(model, null);

            break;
        case edit:
            vlrcBO.updateVlrl(model);

            break;
        default:
            throw new Error("Accion no valida: " + getAccion());
        }

        return SUCCESS;
    }

    /**
     * Load data.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private void loadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getVlrcId());

        if (model.getId() != null) {
            if (model.getId() == model.getPadreId()) {
                vlrlPadre = model;
            } else {
                final ValoracionBO vlrcBO = new ValoracionBO();
                final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                vlrlCriterio.setId(model.getPadreId());
                vlrlCriterio.setIdioma(getIdioma());

                vlrlPadre = vlrcBO.selectVlrlObject(vlrlCriterio);
            }
        }

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setVlrcId(model.getVlrcId());
        aspcCriterio.setIdioma(getIdioma());

        aspc = aspcBO.selectObject(aspcCriterio);
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getFref());

        final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

        prmtCriterio.setEntiId(Entidad.TIPO_IVA.getId());
        prmtCriterio.setFechaVigencia(model.getFref());
        prmtCriterio.setIdioma(getIdioma());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(prmtCriterio.getEntiId());

        impuestoList = prmtBO.selectList(prmtCriterio);
    }

    // get / set

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    @Override
    public ValoracionLineaVO getModel() {
        return model;
    }

    /**
     * Sets the vlrl.
     *
     * @param value
     *            the vlrl
     */
    public void setModel(final ValoracionLineaVO value) {
        model = value;
    }

    /**
     * Gets the vlrl padre.
     *
     * @return the vlrl padre
     */
    public ValoracionLineaVO getVlrlPadre() {
        return vlrlPadre;
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }

    /**
     * Gets the impuesto list.
     *
     * @return the impuesto list
     */
    public List<ParametroVO> getImpuestoList() {
        return impuestoList;
    }

    /**
     * Gets the vlrl hijos list.
     *
     * @return the vlrl hijos list
     */
    public List<ValoracionLineaVO> getVlrlHijosList() {
        return vlrlHijosList;
    }

}
