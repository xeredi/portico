package xeredi.integra.http.controller.action.proceso;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoParametroVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoAction.
 */
public final class ProcesoAction extends ItemAction implements ModelDriven<ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 899256989833948070L;

    /** The prbt. */
    private ProcesoVO model;

    /** The prar entrada list. */
    private List<ArchivoInfoVO> arinEntradaList;

    /** The prar salida list. */
    private List<ArchivoInfoVO> arinSalidaList;

    /** The prit entrada list. */
    private List<ProcesoItemVO> pritEntradaList;

    /** The prit salida list. */
    private List<ProcesoItemVO> pritSalidaList;

    /** The prpm map. */
    private Map<String, ProcesoParametroVO> prpmMap;

    // Acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prbt-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        model = prbtBO.select(model.getId());
        arinEntradaList = prbtBO.selectArinEntradaList(model.getId());
        arinSalidaList = prbtBO.selectArinSalidaList(model.getId());
        pritEntradaList = prbtBO.selectPritEntradaList(model.getId());
        pritSalidaList = prbtBO.selectPritSalidaList(model.getId());
        prpmMap = prbtBO.selectPrpmMap(model.getId());

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prbt-cancel")
    public String borrar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        prbtBO.cancelar(model.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ProcesoVO getModel() {
        return model;
    }

    /**
     * Sets the prbt.
     *
     * @param value
     *            the new prbt
     */
    public void setModel(final ProcesoVO value) {
        model = value;
    }

    /**
     * Gets the arin entrada list.
     *
     * @return the arin entrada list
     */
    public List<ArchivoInfoVO> getArinEntradaList() {
        return arinEntradaList;
    }

    /**
     * Gets the arin salida list.
     *
     * @return the arin salida list
     */
    public List<ArchivoInfoVO> getArinSalidaList() {
        return arinSalidaList;
    }

    /**
     * Gets the prit entrada list.
     *
     * @return the prit entrada list
     */
    public List<ProcesoItemVO> getPritEntradaList() {
        return pritEntradaList;
    }

    /**
     * Gets the prit salida list.
     *
     * @return the prit salida list
     */
    public List<ProcesoItemVO> getPritSalidaList() {
        return pritSalidaList;
    }

    /**
     * Gets the prpm map.
     *
     * @return the prpm map
     */
    public Map<String, ProcesoParametroVO> getPrpmMap() {
        return prpmMap;
    }

}
