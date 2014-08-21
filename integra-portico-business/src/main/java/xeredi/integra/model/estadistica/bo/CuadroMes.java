package xeredi.integra.model.estadistica.bo;

import java.util.List;
import java.util.Map;

import xeredi.integra.model.estadistica.vo.CuadroMesVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CuadroMes.
 */
public interface CuadroMes {

    /**
     * Select map.
     * 
     * @param peprId
     *            the pepr id
     * @return the map
     */
    Map<String, List<CuadroMesVO>> selectMap(final Long peprId);
}
