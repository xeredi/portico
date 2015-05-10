package xeredi.integra.http.controller.action.maestro;

import java.util.HashMap;

import xeredi.integra.http.controller.action.item.ItemGisAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.gis.vo.MapVO;
import xeredi.integra.model.gis.vo.MarkerVO;
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

        double minLat = 0;
        double maxLat = 0;
        double minLon = 0;
        double maxLon = 0;

        map = new MapVO();

        map.setZoom(17);

        for (final ParametroVO item : itemList) {
            if (entiMap.isEmpty()) {
                minLat = item.getVersion().getLat();
                maxLat = item.getVersion().getLat();
                minLon = item.getVersion().getLon();
                maxLon = item.getVersion().getLon();
            }

            minLat = item.getVersion().getLat() < minLat ? item.getVersion().getLat() : minLat;
            maxLat = item.getVersion().getLat() > maxLat ? item.getVersion().getLat() : maxLat;
            minLon = item.getVersion().getLon() < minLon ? item.getVersion().getLon() : minLon;
            maxLon = item.getVersion().getLon() > maxLon ? item.getVersion().getLon() : maxLon;

            final MarkerVO marker = new MarkerVO();

            marker.setId(item.getId());
            marker.getCoords().setLatitude(item.getVersion().getLat());
            marker.getCoords().setLongitude(item.getVersion().getLon());

            map.getMarkerList().add(marker);

            if (item.getVersion().getLat() < minLat) {
                if (entiMap.containsKey(item.getEntiId())) {
                    entiMap.put(item.getEntiId(), TipoParametroProxy.select(item.getEntiId()));
                }
            }
        }

        map.getCenter().setLatitude((minLat + maxLat) / 2);
        map.getCenter().setLongitude((minLon + maxLon) / 2);
    }
}
