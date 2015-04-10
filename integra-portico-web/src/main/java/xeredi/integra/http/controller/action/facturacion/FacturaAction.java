package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.FacturaCargoVO;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAction.
 */
public final class FacturaAction extends ItemAction implements ModelDriven<FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2376088438196649237L;

    /** The fctr. */
    private FacturaVO model;

    /** The aspc. */
    private AspectoVO aspc;

    /** The fcts list. */
    private List<FacturaServicioVO> fctsList;

    /** The fcti list. */
    private List<FacturaImpuestoVO> fctiList;

    /** The fctg list. */
    private List<FacturaCargoVO> fctgList;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctr-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctrBO = new FacturaBO();
        final AspectoBO aspcBO = new AspectoBO();

        model = fctrBO.select(model.getId());
        aspc = aspcBO.select(model.getAspc().getId(), model.getFref(), getIdioma());
        fctsList = fctrBO.selectFctsList(model.getId());
        fctiList = fctrBO.selectFctiList(model.getId());
        fctgList = fctrBO.selectFctgList(model.getId());

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctr-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctrBO = new FacturaBO();

        model = fctrBO.select(model.getId());

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("fctr-save")
    public String save() {
        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaVO getModel() {
        return model;
    }

    /**
     * Sets the fctr.
     *
     * @param value
     *            the new fctr
     */
    public void setModel(final FacturaVO value) {
        model = value;
    }

    /**
     * Gets the fcts list.
     *
     * @return the fcts list
     */
    public List<FacturaServicioVO> getFctsList() {
        return fctsList;
    }

    /**
     * Gets the fcti list.
     *
     * @return the fcti list
     */
    public List<FacturaImpuestoVO> getFctiList() {
        return fctiList;
    }

    /**
     * Gets the fctg list.
     *
     * @return the fctg list
     */
    public List<FacturaCargoVO> getFctgList() {
        return fctgList;
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }
}
