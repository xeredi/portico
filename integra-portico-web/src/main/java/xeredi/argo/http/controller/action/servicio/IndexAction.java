package xeredi.argo.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.ListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioListadoAction.
 */
public final class IndexAction extends ListAction<LabelValueVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5523514529976849793L;

    /** {@link Map} de tipos de subservicio indexados por id de tipo de servicio. */
    private Map<Long, List<LabelValueVO>> tpssMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        resultList = TipoServicioProxy.selectLabelValues();

        tpssMap = new HashMap<>();

        for (final TipoSubservicioDetailVO vo : TipoSubservicioProxy.selectMap().values()) {
            if (!tpssMap.containsKey(vo.getEnti().getTpsrId())) {
                tpssMap.put(vo.getEnti().getTpsrId(), new ArrayList<LabelValueVO>());
            }

            tpssMap.get(vo.getEnti().getTpsrId()).add(new LabelValueVO(vo.getEnti().getNombre(), vo.getEnti().getId()));
        }
    }

    // get/set

    /**
     * Gets the tpss map.
     *
     * @return the tpss map
     */
    public Map<Long, List<LabelValueVO>> getTpssMap() {
        return tpssMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.item;
    }
}
