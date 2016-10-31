package xeredi.argo.http.controller.action.comun;

import java.util.Map;

import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.I18nable;

// TODO: Auto-generated Javadoc
/**
 * The Interface I18nAction.
 *
 * @param <T>
 *            the generic type
 */
public interface I18nAction<T extends I18nable> {

    /**
     * Gets the i 18 n map.
     *
     * @return the i 18 n map
     */
    Map<String, I18nVO> getI18nMap();

    /**
     * Sets the I 18 n map.
     *
     * @param map
     *            the map
     */
    void setI18nMap(final Map<String, I18nVO> map);
}
