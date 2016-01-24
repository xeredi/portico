package xeredi.argo.model.item.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteVO.
 */
@Data
public final class ItemTramiteVO {

    /** The id. */
    private Long id;

    /** The item id. */
    private Long itemId;

    /** The trmt. */
    private TramiteVO trmt;

    /** The fecha. */
    private Date fecha;

    /** The fref. */
    private Date fref;

    /** The oitem fini. */
    private Date oitemFini;

    /** The oitem ffin. */
    private Date oitemFfin;

    /** The ditem fini. */
    private Date ditemFini;

    /** The ditem ffin. */
    private Date ditemFfin;

    /** The itdt map. */
    private final Map<Long, ItemTramiteDatoVO> ittdMap;

    /**
     * Instantiates a new item tramite vo.
     */
    public ItemTramiteVO() {
        super();

        ittdMap = new HashMap<Long, ItemTramiteDatoVO>();
    }
}
