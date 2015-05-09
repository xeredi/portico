package xeredi.integra.http.controller.action.maestro;

import java.util.HashMap;

import xeredi.integra.http.controller.action.item.ItemGisAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroGisAction.
 */
public final class ParametroGisAction extends ItemGisAction<ParametroCriterioVO, TipoParametroDetailVO, ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4085597778730654074L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doList() throws ApplicationException {
        final ParametroBO prmtBO = ParametroBOFactory.newDefaultInstance();

        itemList = prmtBO.selectList(criterio);
        entiMap = new HashMap<Long, TipoParametroDetailVO>();

        for (final ParametroVO item : itemList) {
            if (entiMap.containsKey(item.getEntiId())) {
                entiMap.put(item.getEntiId(), TipoParametroProxy.select(item.getEntiId()));
            }
        }
    }
}
