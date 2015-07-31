package xeredi.integra.model.metamodelo.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteDetailVO.
 */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the trmt.
     *
     * @return the trmt
     */
    public TramiteVO getTrmt() {
        return trmt;
    }

    /**
     * Sets the trmt.
     *
     * @param value
     *            the new trmt
     */
    public void setTrmt(final TramiteVO value) {
        trmt = value;
    }

    /**
     * Gets the trtd map.
     *
     * @return the trtd map
     */
    public Map<Long, TramiteTipoDatoVO> getTrtdMap() {
        return trtdMap;
    }

    /**
     * Sets the trtd map.
     *
     * @param value
     *            the value
     */
    public void setTrtdMap(final Map<Long, TramiteTipoDatoVO> value) {
        trtdMap = value;
    }

    /**
     * Gets the tpdt list.
     *
     * @return the tpdt list
     */
    public List<Long> getTpdtList() {
        return tpdtList;
    }

    /**
     * Sets the tpdt list.
     *
     * @param value
     *            the new tpdt list
     */
    public void setTpdtList(final List<Long> value) {
        tpdtList = value;
    }
}
