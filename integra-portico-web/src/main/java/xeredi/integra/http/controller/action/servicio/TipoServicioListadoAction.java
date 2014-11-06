package xeredi.integra.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListadoAction.
 */
public final class TipoServicioListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5523514529976849793L;

    /** The tpsrs. */
    private List<LabelValueVO> tpsrList;

    /** {@link Map} de tipos de subservicio indexados por id de tipo de servicio. */
    private Map<Long, List<LabelValueVO>> tpssMap;

    // Acciones web
    /**
     * Listado.
     *
     * @return the string
     */
    @Action(value = "tpsr-list")
    public String listado() {
        tpsrList = TipoServicioProxy.selectLabelValues();
        tpssMap = new HashMap<>();

        for (final TipoSubservicioVO vo : TipoSubservicioProxy.selectMap().values()) {
            if (!tpssMap.containsKey(vo.getTpsrId())) {
                tpssMap.put(vo.getTpsrId(), new ArrayList<LabelValueVO>());
            }

            tpssMap.get(vo.getTpsrId()).add(new LabelValueVO(vo.getNombre(), vo.getId()));
        }

        return SUCCESS;
    }

    // get/set

    /**
     * Gets the tpsrs.
     *
     * @return the tpsrs
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the tpss map.
     *
     * @return the tpss map
     */
    public Map<Long, List<LabelValueVO>> getTpssMap() {
        return tpssMap;
    }

}
