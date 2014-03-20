package xeredi.integra.model.bo.estadistica;

import java.util.List;
import java.util.Map;

import xeredi.integra.model.vo.estadistica.CuadroMesVO;

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
