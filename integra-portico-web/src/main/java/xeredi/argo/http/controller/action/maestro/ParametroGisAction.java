package xeredi.argo.http.controller.action.maestro;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemGisAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.gis.vo.MapVO;
import xeredi.argo.model.gis.vo.MarkerVO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroGisAction.
 */
public final class ParametroGisAction extends ItemGisAction<ParametroCriterioVO, TipoParametroDetailVO, ParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4085597778730654074L;

	@Inject
	private ParametroService prmtService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doList() throws ApplicationException {
		final List<ParametroVO> itemList = prmtService.selectList(criterio);
		entiMap = new HashMap<Long, TipoParametroDetailVO>();

		double minLat = 0;
		double maxLat = 0;
		double minLon = 0;
		double maxLon = 0;

		map = new MapVO();
		itemMap = new HashMap<Long, ParametroVO>();

		map.setZoom(17);
		map.getOptions().setScaleControl(true);
		map.getOptions().setScrollwheel(true);
		map.getOptions().setStreetViewControl(false);

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
			marker.getOptions().setTitle(item.getEtiqueta());

			map.getMarkerList().add(marker);
			itemMap.put(item.getId(), item);
			entiMap.put(item.getEntiId(), entiProxy.selectTppr(item.getEntiId()));
		}

		map.getCenter().setLatitude((minLat + maxLat) / 2);
		map.getCenter().setLongitude((minLon + maxLon) / 2);

		map.getBounds().getNortheast().setLatitude(maxLat * (maxLat > 0 ? 1.001 : 0.999));
		map.getBounds().getNortheast().setLongitude(maxLon * (maxLon > 0 ? 1.001 : 0.999));
		map.getBounds().getSouthwest().setLatitude(minLat * (minLat > 0 ? 0.999 : 1.001));
		map.getBounds().getNortheast().setLongitude(minLon * (minLon > 0 ? 0.999 : 1.001));

		double angle = maxLon - minLon;

		if (angle < 0) {
			angle = -angle;
		}

		if (angle < 1) {
			map.setZoom(12);
		}
		if (angle < 0.1) {
			map.setZoom(16);
		}
		if (angle < 0.01) {
			map.setZoom(17);
		}
		if (angle < 0.001) {
			map.setZoom(18);
		}

		map.getOptions().setMinZoom(map.getZoom() - 3);
		map.getOptions().setMaxZoom(map.getZoom() + 3);
	}
}
