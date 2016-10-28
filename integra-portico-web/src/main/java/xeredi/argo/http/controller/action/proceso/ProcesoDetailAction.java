package xeredi.argo.http.controller.action.proceso;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoDetailAction.
 */
public final class ProcesoDetailAction extends CrudDetailAction<ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2068504814675826214L;

    /** The prar entrada list. */
    @Getter
    private List<ArchivoInfoVO> arinEntradaList;

    /** The prar salida list. */
    @Getter
    private List<ArchivoInfoVO> arinSalidaList;

    /** The prit entrada list. */
    @Getter
    private List<ProcesoItemVO> pritEntradaList;

    /** The prit salida list. */
    @Getter
    private List<ProcesoItemVO> pritSalidaList;

    /** The prpm map. */
    @Getter
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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.prbt;
    }
}
