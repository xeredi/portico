package xeredi.argo.model.metamodelo.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteDetailVO.
 */
@Data
public final class TramiteDetailVO {

    /** The trmt. */
    private TramiteVO trmt;

    /** The trtd map. */
    private Map<Long, TramiteTipoDatoVO> trtdMap;

    /** The tpdt list. */
    private List<Long> tpdtList;

    /**
     * Instantiates a new tramite detail vo.
     */
    public TramiteDetailVO() {
        super();

        trtdMap = new HashMap<Long, TramiteTipoDatoVO>();
        tpdtList = new ArrayList<Long>();
    }
}
