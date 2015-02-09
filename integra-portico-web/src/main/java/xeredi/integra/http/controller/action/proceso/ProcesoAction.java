package xeredi.integra.http.controller.action.proceso;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoParametroVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoAction.
 */
public final class ProcesoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 899256989833948070L;

    /** The prbt. */
    private ProcesoVO prbt;

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
        Preconditions.checkNotNull(prbt);
        Preconditions.checkNotNull(prbt.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        prbt = prbtBO.select(prbt.getId());
        arinEntradaList = prbtBO.selectArinEntradaList(prbt.getId());
        arinSalidaList = prbtBO.selectArinSalidaList(prbt.getId());
        pritEntradaList = prbtBO.selectPritEntradaList(prbt.getId());
        pritSalidaList = prbtBO.selectPritSalidaList(prbt.getId());
        prpmMap = prbtBO.selectPrpmMap(prbt.getId());

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
        Preconditions.checkNotNull(prbt);
        Preconditions.checkNotNull(prbt.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        prbtBO.cancelar(prbt.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the prbt.
     *
     * @return the prbt
     */
    public ProcesoVO getPrbt() {
        return prbt;
    }

    /**
     * Sets the prbt.
     *
     * @param value
     *            the new prbt
     */
    public void setPrbt(final ProcesoVO value) {
        prbt = value;
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
