package xeredi.argo.http.controller.action.proceso;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoDetailAction.
 */
@Data
public final class ProcesoDetailAction extends CrudDetailAction<ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2068504814675826214L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.prbt;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        model = prbtBO.select(model.getId());
        arinEntradaList = prbtBO.selectArinEntradaList(model.getId());
        arinSalidaList = prbtBO.selectArinSalidaList(model.getId());
        pritEntradaList = prbtBO.selectPritEntradaList(model.getId());
        pritSalidaList = prbtBO.selectPritSalidaList(model.getId());
        prpmMap = prbtBO.selectPrpmMap(model.getId());
    }
}
